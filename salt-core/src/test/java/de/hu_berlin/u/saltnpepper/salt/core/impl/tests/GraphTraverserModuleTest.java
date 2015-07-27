/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package de.hu_berlin.u.saltnpepper.salt.core.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.impl.GraphFactory;
import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.core.GraphTraverseHandler;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.core.impl.GraphTraverserModule;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltTraverserException;

public class GraphTraverserModuleTest {
	private GraphTraverserModule<SGraph<SNode,SRelation<SNode, SNode>>, SNode, SRelation<SNode, SNode>> fixture = null;

	public void setFixture(GraphTraverserModule fixture) {
		this.fixture = fixture;
	}

	public GraphTraverserModule getFixture() {
		return fixture;
	}

	public void setUp() {
		this.setFixture(new GraphTraverserModule());
	}

	/**
	 * This class checks if a traversing uses the predefined way. The predefined
	 * way can be set via the variables nodeOrderWayThere and nodeOrderWayBack.
	 * This class implements the interface {@link GraphTraverseHandler} and
	 * therefore listens for callbacks of the graph traversal.
	 * 
	 * @author Florian Zipser
	 *
	 */
	class TraverserChecker implements GraphTraverseHandler<SNode, SRelation<SNode,SNode>>, Runnable {
		// class TraverserChecker
		/**
		 * determines if current run is cyclesafe. If this value is true, each
		 * cycle will be traversed two times, than the method
		 * {@link #checkConstraint(GRAPH_TRAVERSE_TYPE, String, Edge, Node, long)}
		 * will return false;
		 */
		public boolean isCycleSafe = true;

		/**
		 * The names of the nodes in order of how they shall be visited in
		 * current traversal mode on the way there.
		 */
		private String[] nodeOrderWayThere;
		/**
		 * Position in list nodeOrderWayThere, of node to be reached next.
		 */
		private int posInWayThere = 0;

		/**
		 * The names of the nodes in order of how they shall be visited in
		 * current traversal mode on the way back.
		 */
		private String[] nodeOrderWayBack;
		/**
		 * Position in list nodeOrderWayBack, of node to be left next.
		 */
		private int posInWayBack = 0;

		public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation rel, SNode fromNode, long order) {
			currentPath.add(currNode);
			if (!currNode.getId().equalsIgnoreCase(nodeOrderWayThere[posInWayThere])) {
				String path = null;
				for (String nodeName : nodeOrderWayThere) {
					if (path == null)
						path = nodeName;
					else
						path = path + "->" + nodeName;
				}
				throw new RuntimeException("Test fails, another way than expected has been traversed on way there. Expected way was '" + path + "', but instead of node '" + nodeOrderWayThere[posInWayThere] + "' at position '" + posInWayThere + "', node '" + currNode.getId() + "' was found.");
			}
			posInWayThere++;
		}

		public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation<SNode, SNode> rel, SNode fromNode, long order) {
			if (GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST == traversalType || GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST == traversalType) {
				currentPath.remove(currentPath.size() - 1);
			}
			if (!currNode.getId().equalsIgnoreCase(nodeOrderWayBack[posInWayBack])) {
				String path = null;
				for (String nodeName : nodeOrderWayBack) {
					if (path == null)
						path = nodeName;
					else
						path = path + "->" + nodeName;
				}
				throw new RuntimeException("Test fails, another way than expected has been traversed on way back. Expected way was '" + path + "', but instead of node '" + nodeOrderWayBack[posInWayBack] + "' at position '" + (posInWayBack + 1) + "', node '" + currNode.getId() + "' was found.");
			}
			posInWayBack++;
		}

		/**
		 * Stores the current node path
		 */
		private List<SNode> currentPath = new ArrayList<>();

		public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SRelation<SNode, SNode> rel, SNode currNode, long order) {
			boolean retVal = true;

			if (isCycleSafe == false) {// checks if a path in currentPath is
										// contained two times
				Integer numOfOccurences = 0;
				for (int i = 0; i < currentPath.size(); i++) {
					if (currentPath.get(i).equals(currNode)) {
						numOfOccurences++;
					}
				}
				if (numOfOccurences >= 2)
					retVal = false;
			}// checks if a path in currentPath is contained two times

			return retVal;
		}

		public boolean checkNumberOfTraversedNodes() {
			return posInWayThere == nodeOrderWayThere.length && posInWayBack == nodeOrderWayBack.length;
		}

		private List<SNode> startNodes = null;
		private GRAPH_TRAVERSE_TYPE traverseType = null;
		private String traverseId = null;
		private Exception exception = null;
		public volatile int runs = 0;
		Thread traverseThread;

		public void start(List<SNode> startNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId) {
			this.startNodes = startNodes;
			this.traverseType = traverseType;
			this.traverseId = traverseId;
			traverseThread = new Thread(this, "traverse_" + traverseId);
			traverseThread.start();
		}

		public void run() {
			try {
				getFixture().traverse(startNodes, traverseType, traverseId, this, isCycleSafe);
			} catch (Exception e) {
				this.exception = e;
			} finally {
				runs++;
			}
		}
	}// class TraverserChecker

	// ==================================================== start: tests

	/**
	 * Checks if wrong parameter calling is detected.
	 */
	public void testTraverseParameters() {
		List<SNode> startNodes = null;
		GRAPH_TRAVERSE_TYPE traverseType = null;
		GraphTraverseHandler handler = null;

		{// test 1
			startNodes = null;
			traverseType = GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST;
			handler = new TraverserChecker();

			try {
				getFixture().traverse(startNodes, traverseType, "test_TOP_DOWN_DEPTH_FIRST_Tree", handler);
				fail("null parameters are not allowed");
			} catch (Exception e) {
			}
		}// test 1

		{// test 2
			startNodes = new ArrayList<SNode>();
			startNodes.add(SaltFactory.createSNode());
			traverseType = null;
			handler = new TraverserChecker();

			try {
				getFixture().traverse(startNodes, traverseType, "test_TOP_DOWN_DEPTH_FIRST_Tree", handler);
				fail("null parameters are not allowed");
			} catch (Exception e) {
			}
		}// test 2

		{// test 3
			startNodes = new ArrayList<>();
			startNodes.add(SaltFactory.createSNode());
			traverseType = GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST;
			handler = null;

			try {
				getFixture().traverse(startNodes, traverseType, "test_TOP_DOWN_DEPTH_FIRST_Tree", handler);
				fail("null parameters are not allowed");
			} catch (Exception e) {
			}
		}// test 3
	}

	/**
	 * Tests the method {@link GraphTraverserModule#getRoots()} and checks if
	 * the correct roots are returned, using the several graph types.
	 */
	public void testGetRoots() {
		List<Node> expectedRoots = null;
		List<Node> roots = null;
		SGraph<SNode, SRelation<SNode,SNode>> graph = null;

		{// test 1
			graph = SGraphTest.createGraph_Tree();
			getFixture().setGraph(graph);
			expectedRoots = new ArrayList<Node>();
			expectedRoots.add(graph.getNode("node1"));
			roots = getFixture().getGraph().getRoots();
			assertEquals("The expected number of roots are not the same, as the returned number", expectedRoots.size(), roots.size());
			for (Node expectedRoot : expectedRoots) {
				assertTrue("The list of returned roots does not contain expected root '" + expectedRoot.getId() + "'.", roots.contains(expectedRoot));
			}
		}// test 1

		{// test 2
			graph = SGraphTest.createGraph_DAG();
			getFixture().setGraph(graph);
			expectedRoots = new ArrayList<Node>();
			expectedRoots.add(graph.getNode("node1"));
			expectedRoots.add(graph.getNode("node4"));
			roots = getFixture().getGraph().getRoots();
			assertEquals("The expected number of roots are not the same, as the returned number", expectedRoots.size(), roots.size());
			for (Node expectedRoot : expectedRoots) {
				assertTrue("The list of returned roots does not contain expected root '" + expectedRoot.getId() + "'.", roots.contains(expectedRoot));
			}
		}// test 2

		{// test 3
			graph = SGraphTest.createGraph_Cycle();
			getFixture().setGraph(graph);
			expectedRoots = new ArrayList<Node>();
			expectedRoots.add(graph.getNode("node1"));
			expectedRoots.add(graph.getNode("node4"));
			roots = getFixture().getGraph().getRoots();
			assertEquals("The expected number of roots are not the same, as the returned number", expectedRoots.size(), roots.size());
			for (Node expectedRoot : expectedRoots) {
				assertTrue("The list of returned roots does not contain expected root '" + expectedRoot.getId() + "'.", roots.contains(expectedRoot));
			}
		}// test 3
	}

	/**
	 * Tests the method {@link GraphTraverserModule#getLeafs()} and checks if
	 * the correct leafs are returned, using the several graph types.
	 */
	public void testGetLeafs() {
		List<Node> expectedLeafs = null;
		List<Node> leafs = null;
		SGraph<SNode, SRelation<SNode,SNode>> graph = null;

		{// test 1
			graph = SGraphTest.createGraph_Tree();
			getFixture().setGraph(graph);
			expectedLeafs = new ArrayList<Node>();
			expectedLeafs.add(graph.getNode("node3"));
			expectedLeafs.add(graph.getNode("node6"));
			expectedLeafs.add(graph.getNode("node5"));
			expectedLeafs.add(graph.getNode("node7"));
			leafs = getFixture().getGraph().getLeafs();
			assertEquals("The expected number of leafs are not the same, as the returned number", expectedLeafs.size(), leafs.size());
			for (Node expectedLeaf : expectedLeafs) {
				assertTrue("The list of returned roots does not contain expected leaf '" + expectedLeaf.getId() + "'.", leafs.contains(expectedLeaf));
			}
		}// test 1

		{// test 2
			graph = SGraphTest.createGraph_DAG();
			getFixture().setGraph(graph);
			expectedLeafs = new ArrayList<Node>();
			expectedLeafs.add(graph.getNode("node3"));
			expectedLeafs.add(graph.getNode("node6"));
			leafs = getFixture().getGraph().getLeafs();
			assertEquals("The expected number of leafs are not the same, as the returned number", expectedLeafs.size(), leafs.size());
			for (Node expectedLeaf : expectedLeafs) {
				assertTrue("The list of returned leafs does not contain expected leaf '" + expectedLeaf.getId() + "'.", leafs.contains(expectedLeaf));
			}
		}// test 2

		{// test 3
			graph = SGraphTest.createGraph_Cycle();
			getFixture().setGraph(graph);
			expectedLeafs = new ArrayList<Node>();
			expectedLeafs.add(graph.getNode("node3"));
			leafs = getFixture().getGraph().getLeafs();
			assertEquals("The expected number of leafs are not the same, as the returned number", expectedLeafs.size(), leafs.size());
			for (Node expectedLeaf : expectedLeafs) {
				assertTrue("The list of returned roots does not contain expected leaf '" + expectedLeaf.getId() + "'.", leafs.contains(expectedLeaf));
			}
		}// test 3
	}

	/**
	 * Checks if it is detected, that a traverseId cannot be used twice.
	 * 
	 * @throws InterruptedException
	 */
	public void testTraverseId() throws InterruptedException {
		List<SNode> startNodes = null;
		GRAPH_TRAVERSE_TYPE traverseType = null;
		String traverseId = "traverseId";
		getFixture().setGraph(SGraphTest.createGraph_Tree());

		startNodes = getFixture().getGraph().getRoots();
		traverseType = GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST;

		String[] nodeOrderWayThere = { "node1", "node2", "node3", "node6", "node4", "node5", "node7" };
		String[] nodeOrderWayBack = { "node3", "node6", "node2", "node5", "node4", "node7", "node1" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		checker.start(startNodes, traverseType, traverseId);
		checker.start(startNodes, traverseType, traverseId);
		while (checker.runs != 2) {
			Thread.sleep(100);
		}

		if ((checker.exception == null) || (!(checker.exception instanceof SaltTraverserException))) {
			checker.exception.printStackTrace();
			fail("A GraphTaverserException should have been thrown, because the same id was used twice with the same callback handler");
		}
	}

	/**
	 * Starts 3 threads to traverse the graph and checks, that no problem
	 * concerning the use of threads occurs. Uses
	 * {@link GRAPH_TRAVERSE_TYPE#TOP_DOWN_DEPTH_FIRST} as traverse order.
	 * 
	 * @throws Exception
	 */
	public void testThreading_TOP_DOWN_DEPTH_FIRST() throws Exception {
		// uses the tree as graph
		getFixture().setGraph(SGraphTest.createGraph_Tree());

		List<SNode> startNodes = null;
		GRAPH_TRAVERSE_TYPE traverseType = null;
		String traverseId = null;
		getFixture().setGraph(SGraphTest.createGraph_Tree());

		startNodes = getFixture().getGraph().getRoots();
		traverseType = GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST;

		TraverserChecker traverseChecker1 = null;
		TraverserChecker traverseChecker2 = null;
		TraverserChecker traverseChecker3 = null;

		String[] nodeOrderWayThere = { "node1", "node2", "node3", "node6", "node4", "node5", "node7" };
		String[] nodeOrderWayBack = { "node3", "node6", "node2", "node5", "node4", "node7", "node1" };

		{// thread 1
			traverseId = "testThreading_1";
			traverseChecker1 = new TraverserChecker();
			traverseChecker1.nodeOrderWayThere = nodeOrderWayThere;
			traverseChecker1.nodeOrderWayBack = nodeOrderWayBack;
			traverseChecker1.start(startNodes, traverseType, traverseId);
		}// thread 1

		{// thread 2
			traverseId = "testThreading_2";
			traverseChecker2 = new TraverserChecker();
			traverseChecker2.nodeOrderWayThere = nodeOrderWayThere;
			traverseChecker2.nodeOrderWayBack = nodeOrderWayBack;
			traverseChecker2.start(startNodes, traverseType, traverseId);
		}// thread 2

		{// thread 3
			traverseId = "testThreading_3";
			traverseChecker3 = new TraverserChecker();
			traverseChecker3.nodeOrderWayThere = nodeOrderWayThere;
			traverseChecker3.nodeOrderWayBack = nodeOrderWayBack;
			traverseChecker3.start(startNodes, traverseType, traverseId);
		}// thread 3

		while ((traverseChecker1.runs < 1) || (traverseChecker2.runs < 1) || (traverseChecker3.runs < 1)) {
			Thread.sleep(100);
		}

		List<TraverserChecker> traverseCheckers = new ArrayList<GraphTraverserModuleTest.TraverserChecker>();
		traverseCheckers.add(traverseChecker1);
		traverseCheckers.add(traverseChecker2);
		traverseCheckers.add(traverseChecker3);

		for (TraverserChecker traverseChecker : traverseCheckers) {
			if ((traverseChecker.exception != null)) {
				throw traverseChecker.exception;
			}
		}
	}

	/**
	 * Starts 3 threads to traverse the graph and checks, that no problem
	 * concerning the use of threads occurs. Uses
	 * {@link GRAPH_TRAVERSE_TYPE#TOP_DOWN_BREADTH_FIRST} as traverse order.
	 * 
	 * @throws Exception
	 */
	public void testThreading_TOP_DOWN_BREADTH_FIRST() throws Exception {
		// uses the tree as graph
		getFixture().setGraph(SGraphTest.createGraph_Tree());

		List<SNode> startNodes = null;
		GRAPH_TRAVERSE_TYPE traverseType = null;
		String traverseId = null;
		getFixture().setGraph(SGraphTest.createGraph_Tree());

		startNodes = getFixture().getGraph().getRoots();
		traverseType = GRAPH_TRAVERSE_TYPE.TOP_DOWN_BREADTH_FIRST;

		TraverserChecker traverseChecker1 = null;
		TraverserChecker traverseChecker2 = null;
		TraverserChecker traverseChecker3 = null;

		String[] nodeOrderWayThere = { "node1", "node2", "node4", "node7", "node3", "node6", "node5" };
		String[] nodeOrderWayBack = { "node1", "node2", "node4", "node7", "node3", "node6", "node5" };

		{// thread 1
			traverseId = "testThreading_1";
			traverseChecker1 = new TraverserChecker();
			traverseChecker1.isCycleSafe = false;
			traverseChecker1.nodeOrderWayThere = nodeOrderWayThere;
			traverseChecker1.nodeOrderWayBack = nodeOrderWayBack;
			traverseChecker1.start(startNodes, traverseType, traverseId);
		}// thread 1

		{// thread 2
			traverseId = "testThreading_2";
			traverseChecker2 = new TraverserChecker();
			traverseChecker2.isCycleSafe = false;
			traverseChecker2.nodeOrderWayThere = nodeOrderWayThere;
			traverseChecker2.nodeOrderWayBack = nodeOrderWayBack;
			traverseChecker2.start(startNodes, traverseType, traverseId);
		}// thread 2

		{// thread 3
			traverseId = "testThreading_3";
			traverseChecker3 = new TraverserChecker();
			traverseChecker3.isCycleSafe = false;
			traverseChecker3.nodeOrderWayThere = nodeOrderWayThere;
			traverseChecker3.nodeOrderWayBack = nodeOrderWayBack;
			traverseChecker3.start(startNodes, traverseType, traverseId);
		}// thread 3

		// while ( (traverseChecker1.runs< 1 )||
		// (traverseChecker2.runs< 1 ) ||
		// (traverseChecker3.runs< 1 ))
		// {
		// Thread.sleep(100);
		// }
		traverseChecker3.traverseThread.join();
		traverseChecker2.traverseThread.join();
		traverseChecker1.traverseThread.join();

		List<TraverserChecker> traverseCheckers = new ArrayList<GraphTraverserModuleTest.TraverserChecker>();
		traverseCheckers.add(traverseChecker1);
		traverseCheckers.add(traverseChecker2);
		traverseCheckers.add(traverseChecker3);

		for (TraverserChecker traverseChecker : traverseCheckers) {
			if ((traverseChecker.exception != null)) {
				throw traverseChecker.exception;
			}
		}
	}

	/**
	 * Tests the traversing of top-down, depth first of graph_Tree.
	 */
	public void testTraverse_TOP_DOWN_DEPTH_FIRST_Tree() {
		SGraph<SNode, SRelation<SNode,SNode>> graph = SGraphTest.createGraph_Tree();
		String[] nodeOrderWayThere = { "node1", "node2", "node3", "node6", "node4", "node5", "node7" };
		String[] nodeOrderWayBack = { "node3", "node6", "node2", "node5", "node4", "node7", "node1" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		getFixture().traverse(getFixture().getGraph().getRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, "test_TOP_DOWN_DEPTH_FIRST_Tree", checker);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of top-down, depth first of graph_DAG.
	 */
	public void testTraverse_TOP_DOWN_DEPTH_FIRST_DAG() {
		SGraph<SNode, SRelation<SNode,SNode>> graph = SGraphTest.createGraph_DAG();
		String[] nodeOrderWayThere = { "node1", "node2", "node3", "node6", "node4", "node2", "node3", "node6" };
		String[] nodeOrderWayBack = { "node3", "node6", "node2", "node1", "node3", "node6", "node2", "node4" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		getFixture().traverse(getFixture().getGraph().getRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, "test_TOP_DOWN_DEPTH_FIRST_DAG", checker);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of top-down, depth first of graph_Cycle.
	 * 
	 * @throws Exception
	 */
	public void testTraverse_TOP_DOWN_DEPTH_FIRST_Cycle() throws Exception {
		SGraph<SNode, SRelation<SNode,SNode>> graph = SGraphTest.createGraph_Cycle();
		String[] nodeOrderWayThere = { "node1", "node2", "node3", "node6", "node7", "node2", "node6", "node7", "node2" };
		String[] nodeOrderWayBack = { "node3", "node6", "node2", "node1", "node3", "node6", "node2", "node4" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		try {
			getFixture().traverse(getFixture().getGraph().getRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, "test_TOP_DOWN_DEPTH_FIRST_Cycle", checker);
			assertTrue(checker.checkNumberOfTraversedNodes());
			fail("The graph contains a cycle, that shall invoke an exception.");
		} catch (Exception e) {
		}
	}

	/**
	 * Tests the traversing of top-down, depth first of graph_Cycle.
	 */
	public void testTraverse_TOP_DOWN_DEPTH_FIRST_CycleUnsafe() {
		SGraph<SNode, SRelation<SNode,SNode>> graph = SGraphTest.createGraph_SimpleCycle();
		String[] nodeOrderWayThere = { "node1", "node2", "node3", "node6", "node7", "node2", "node3", "node6", "node7" };
		String[] nodeOrderWayBack = { "node3", "node3", "node7", "node6", "node2", "node7", "node6", "node2", "node1" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		checker.isCycleSafe = false;
		getFixture().setGraph(graph);
		getFixture().traverse(getFixture().getGraph().getRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, "test_TOP_DOWN_DEPTH_FIRST_Cycle", checker, false);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of bottom-up, depth first of graph_Tree.
	 */
	public void testTraverse_BOTTOM_UP_DEPTH_FIRST_Tree() {
		SGraph<SNode, SRelation<SNode,SNode>> graph = SGraphTest.createGraph_Tree();
		String[] nodeOrderWayThere = { "node3", "node2", "node1", "node5", "node4", "node1", "node6", "node2", "node1", "node7", "node1" };
		String[] nodeOrderWayBack = { "node1", "node2", "node3", "node1", "node4", "node5", "node1", "node2", "node6", "node1", "node7" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		getFixture().traverse(getFixture().getGraph().getLeafs(), GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST, "test_BOTTOM_UP_DEPTH_FIRST_Tree", checker);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of bottom-up, depth first of graph_DAG.
	 */
	public void testTraverse_BOTTOM_UP_DEPTH_FIRST_DAG() {
		SGraph<SNode, SRelation<SNode,SNode>> graph = SGraphTest.createGraph_DAG();
		String[] nodeOrderWayThere = { "node3", "node2", "node1", "node4", "node6", "node2", "node1", "node4" };
		String[] nodeOrderWayBack = { "node1", "node4", "node2", "node3", "node1", "node4", "node2", "node6" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		getFixture().traverse(getFixture().getGraph().getLeafs(), GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST, "test_BOTTOM_UP_DEPTH_FIRST_DAG", checker);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of bottom-up, depth first of graph_Cycle.
	 */
	public void testTraverse_BOTTOM_UP_DEPTH_FIRST_Cycle() {
		SGraph<SNode, SRelation<SNode,SNode>> graph = SGraphTest.createGraph_Cycle();
		String[] nodeOrderWayThere = { "node3", "node2", "node1", "node4", "node7", "node6", "node2", "node1", "node4" };
		String[] nodeOrderWayBack = { "node1", "node4", "node2", "node3", "node1", "node4", "node2", "node6" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		try {
			getFixture().traverse(getFixture().getGraph().getLeafs(), GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST, "test_BOTTOM_UP_DEPTH_FIRST_Cycle", checker);
			assertTrue(checker.checkNumberOfTraversedNodes());
			fail("The graph contains a cycle, that shall invoke an exception.");
		} catch (Exception e) {
		}
	}

	/**
	 * Starts 3 threads to traverse the graph and checks, that no problem
	 * concerning the use of threads occurs. Uses
	 * {@link GRAPH_TRAVERSE_TYPE#BOTTOM_UP_DEPTH_FIRST} as traverse order.
	 * 
	 * @throws Exception
	 */
	public void testThreading_BOTTOM_UP_DEPTH_FIRST() throws Exception {
		// uses the tree as graph
		getFixture().setGraph(SGraphTest.createGraph_Tree());

		List<SNode> startNodes = null;
		GRAPH_TRAVERSE_TYPE traverseType = null;
		String traverseId = null;
		getFixture().setGraph(SGraphTest.createGraph_Tree());

		startNodes = getFixture().getGraph().getLeafs();
		traverseType = GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST;

		TraverserChecker traverseChecker1 = null;
		TraverserChecker traverseChecker2 = null;
		TraverserChecker traverseChecker3 = null;
		String[] nodeOrderWayThere = { "node3", "node2", "node1", "node5", "node4", "node1", "node6", "node2", "node1", "node7", "node1" };
		String[] nodeOrderWayBack = { "node1", "node2", "node3", "node1", "node4", "node5", "node1", "node2", "node6", "node1", "node7" };

		{// thread 1
			traverseId = "testThreading_1";
			traverseChecker1 = new TraverserChecker();
			traverseChecker1.nodeOrderWayThere = nodeOrderWayThere;
			traverseChecker1.nodeOrderWayBack = nodeOrderWayBack;
			traverseChecker1.start(startNodes, traverseType, traverseId);
		}// thread 1

		{// thread 2
			traverseId = "testThreading_2";
			traverseChecker2 = new TraverserChecker();
			traverseChecker2.nodeOrderWayThere = nodeOrderWayThere;
			traverseChecker2.nodeOrderWayBack = nodeOrderWayBack;
			traverseChecker2.start(startNodes, traverseType, traverseId);
		}// thread 2

		{// thread 3
			traverseId = "testThreading_3";
			traverseChecker3 = new TraverserChecker();
			traverseChecker3.nodeOrderWayThere = nodeOrderWayThere;
			traverseChecker3.nodeOrderWayBack = nodeOrderWayBack;
			traverseChecker3.start(startNodes, traverseType, traverseId);
		}// thread 3

		while ((traverseChecker1.runs < 1) || (traverseChecker2.runs < 1) || (traverseChecker3.runs < 1)) {
			Thread.sleep(100);
		}

		List<TraverserChecker> traverseCheckers = new ArrayList<GraphTraverserModuleTest.TraverserChecker>();
		traverseCheckers.add(traverseChecker1);
		traverseCheckers.add(traverseChecker2);
		traverseCheckers.add(traverseChecker3);

		for (TraverserChecker traverseChecker : traverseCheckers) {
			if ((traverseChecker.exception != null)) {
				throw traverseChecker.exception;
			}
		}
		for (TraverserChecker checker : traverseCheckers) {
			assertTrue(checker.checkNumberOfTraversedNodes());
		}
	}

	/**
	 * Tests the traversing of
	 * {@link GRAPH_TRAVERSE_TYPE#TOP_DOWN_BREADTH_FIRST} of graph_Tree, with
	 * tree {@inheritDoc SGraphTest#createGraph_Tree()}.
	 */
	public void testTraverse_TOP_DOWN_BREADTH_FIRST_Tree() {
		SGraph<SNode, SRelation<SNode,SNode>> graph = SGraphTest.createGraph_Tree();
		String[] nodeOrderWayThere = { "node1", "node2", "node4", "node7", "node3", "node6", "node5" };
		String[] nodeOrderWayBack = { "node1", "node2", "node4", "node7", "node3", "node6", "node5" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		getFixture().traverse(getFixture().getGraph().getRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_BREADTH_FIRST, "test_TOP_DOWN_BREADTH_FIRST_Tree", checker, false);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of
	 * {@link GRAPH_TRAVERSE_TYPE#TOP_DOWN_BREADTH_FIRST} of graph_DAG, with
	 * graph {@inheritDoc SGraphTest#createGraph_DAG()}.
	 */
	public void testTraverse_TOP_DOWN_BREADTH_FIRST_DAG() {
		SGraph<SNode, SRelation<SNode,SNode>> graph = SGraphTest.createGraph_DAG();
		String[] nodeOrderWayThere = { "node1", "node4", "node2", "node2", "node3", "node6", "node3", "node6" };
		String[] nodeOrderWayBack = { "node1", "node4", "node2", "node2", "node3", "node6", "node3", "node6" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		getFixture().traverse(getFixture().getGraph().getRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_BREADTH_FIRST, "test_TOP_DOWN_BREADTH_FIRST_DAG", checker, false);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of
	 * {@link GRAPH_TRAVERSE_TYPE#TOP_DOWN_BREADTH_FIRST} of graph_DAG, with
	 * graph {@inheritDoc SGraphTest#createGraph_DAG()}. Starting with a node
	 * that is not a root node
	 */
	public void testTraverse_TOP_DOWN_BREADTH_FIRST_DAG_NON_ROOT_START() {
		SGraph<SNode, SRelation<SNode,SNode>> graph = SGraphTest.createGraph_DAG();
		String[] nodeOrderWayThere = { "node2", "node3", "node6" };
		String[] nodeOrderWayBack = { "node2", "node3", "node6" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		List<SNode> startNodes = (new ArrayList<>());
		startNodes.add(getFixture().getGraph().getNode("node2"));
		getFixture().traverse(startNodes, GRAPH_TRAVERSE_TYPE.TOP_DOWN_BREADTH_FIRST, "test_TOP_DOWN_BREADTH_FIRST_DAG", checker, false);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of
	 * {@link GRAPH_TRAVERSE_TYPE#TOP_DOWN_BREADTH_FIRST} of graph_DAG, with
	 * graph {@inheritDoc SGraphTest#createGraph_DAG()}. Starting with a node
	 * that is not a root node
	 */
	public void testTraverse_TOP_DOWN_DEPTH_FIRST_DAG_NON_ROOT_START() {
		SGraph<SNode, SRelation<SNode,SNode>> graph = SGraphTest.createGraph_DAG();
		String[] nodeOrderWayThere = { "node2", "node3", "node6" };
		String[] nodeOrderWayBack = { "node3", "node6", "node2" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		List<SNode> startNode = (new ArrayList<>());
		startNode.add(getFixture().getGraph().getNode("node2"));
		getFixture().traverse(startNode, GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, "test_TOP_DOWN_DEPTH_FIRST_DAG_NON_ROOT_START", checker);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of
	 * {@link GRAPH_TRAVERSE_TYPE#TOP_DOWN_BREADTH_FIRST} of graph_DAG, with
	 * graph {@inheritDoc SGraphTest#createGraph_DAG()}. Starting with a node
	 * that is not a root node
	 */
	public void testTraverse_TOP_DOWN_DEPTH_FIRST_NO_REAL_CYCLES() {
		SGraph<SNode, SRelation<SNode,SNode>> graph = SaltFactory.createSGraph();
		graph.setId("graph1");
		SNode node1 = SaltFactory.createSNode();
		graph.addNode(node1);
		SNode node2 = SaltFactory.createSNode();
		graph.addNode(node2);
		SNode node3 = SaltFactory.createSNode();
		graph.addNode(node3);

		SRelation<SNode, SNode> edge1 = SaltFactory.createSRelation();
		edge1.setSource(node1);
		edge1.setTarget(node2);
		graph.addRelation(edge1);
		SRelation<SNode, SNode> edge2 = SaltFactory.createSRelation();
		edge2.setSource(node2);
		edge2.setTarget(node3);
		graph.addRelation(edge2);
		SRelation<SNode, SNode> edge3 = SaltFactory.createSRelation();
		edge3.setSource(node3);
		edge3.setTarget(node2);
		Label label = GraphFactory.createLabel();
		label.setName("name");
		label.setValue("notCheck");
		edge3.addLabel(label);
		graph.addRelation(edge3);

		GraphTraverseHandler<SNode, SRelation<SNode,SNode>> graphTraverseHandler = new GraphTraverseHandler() {
			@Override
			public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation relation, SNode fromNode, long order) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation relation, SNode fromNode, long order) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SRelation relation, SNode currNode, long order) {
				if ((relation != null) && (relation.getLabel("name") != null) && (relation.getLabel("name").getValue().equals("notCheck")))
					return false;
				else
					return true;
			
			}
		};
		getFixture().setGraph(graph);

		List<SNode> startNode = (new ArrayList<>());
		startNode.add(node1);
		getFixture().traverse(startNode, GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, "test_TOP_DOWN_DEPTH_FIRST_NO_REAL_CYCLES", graphTraverseHandler);
	}

	/**
	 * Tests the traversing of
	 * {@link GRAPH_TRAVERSE_TYPE#TOP_DOWN_BREADTH_FIRST} of graph_Tree, with
	 * graph {@inheritDoc SGraphTest#createGraph_SimpleCycle()}.
	 */
	public void testTraverse_TOP_DOWN_BREADTH_FIRST_CycleUnsafe() {
		SGraph<SNode, SRelation<SNode,SNode>> graph = SGraphTest.createGraph_SimpleCycle();
		String[] nodeOrderWayThere = { "node1", "node2", "node3", "node6", "node7", "node2", "node3", "node6", "node7" };
		String[] nodeOrderWayBack = nodeOrderWayThere.clone();
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		checker.isCycleSafe = false;
		getFixture().setGraph(graph);
		getFixture().traverse(getFixture().getGraph().getRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_BREADTH_FIRST, "test_TOP_DOWN_BREADTH_FIRST_Cycle", checker, false);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of
	 * {@link GRAPH_TRAVERSE_TYPE#BOTTOM_UP_BREADTH_FIRST} of graph_Tree, with
	 * tree {@inheritDoc SGraphTest#createGraph_Tree()}.
	 */
	public void testTraverse_BOTTOM_UP_BREADTH_FIRST_Tree() {
		SGraph<SNode, SRelation<SNode,SNode>> graph = SGraphTest.createGraph_Tree();
		// String[] nodeOrderWayThere= {"node3", "node6", "node5", "node7",
		// "node2", "node2", "node4", "node1", "node1", "node1", "node1"};
		String[] nodeOrderWayThere = { "node3", "node5", "node6", "node7", "node2", "node4", "node2", "node1", "node1", "node1", "node1" };
		String[] nodeOrderWayBack = nodeOrderWayThere.clone();

		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		getFixture().traverse(getFixture().getGraph().getLeafs(), GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST, "test_BOTTOM_UP_BREADTH_FIRST_Tree", checker, false);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of
	 * {@link GRAPH_TRAVERSE_TYPE#BOTTOM_UP_BREADTH_FIRST} of graph_DAG, with
	 * graph {@inheritDoc SGraphTest#createGraph_DAG()}.
	 */
	public void testTraverse_BOTTOM_UP_BREADTH_FIRST_DAG() {
		SGraph<SNode, SRelation<SNode,SNode>> graph = SGraphTest.createGraph_DAG();
		String[] nodeOrderWayThere = { "node3", "node6", "node2", "node2", "node1", "node4", "node1", "node4" };
		String[] nodeOrderWayBack = nodeOrderWayThere.clone();
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		getFixture().traverse(getFixture().getGraph().getLeafs(), GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST, "test_BOTTOM_UP_BREADTH_FIRST_DAG", checker, false);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of
	 * {@link GRAPH_TRAVERSE_TYPE#BOTTOM_UP_BREADTH_FIRST} of graph_Cycle, with
	 * graph {@inheritDoc SGraphTest#createGraph_Cycle()}.
	 */
	public void testTraverse_BOTTOM_UP_BREADTH_FIRST_Cycle() {
		SGraph<SNode, SRelation<SNode,SNode>> graph = SGraphTest.createGraph_Cycle();
		{
			String[] nodeOrderWayThere = { "node3", "node2", "node1", "node4" };
			String[] nodeOrderWayBack = { "node3", "node2", "node1", "node4" };
			TraverserChecker checker = new TraverserChecker();
			checker.nodeOrderWayThere = nodeOrderWayThere;
			checker.nodeOrderWayBack = nodeOrderWayBack;
			getFixture().setGraph(graph);
			try {
				getFixture().traverse(getFixture().getGraph().getLeafs(), GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST, "test_BOTTOM_UP_BREADTH_FIRST_Cycle", checker);
				assertTrue(checker.checkNumberOfTraversedNodes());
			} catch (Exception e) {
				if (e instanceof SaltTraverserException) {

				} else {
					fail("The graph contains a cycle, that shall invoke an exception.");
				}
			}
		}
		{
			List<SNode> startNodes = new ArrayList<>();
			startNodes.add(graph.getNode("node3"));
			startNodes.add(graph.getNode("node7"));
			String[] nodeOrderWayThere = { "node3", "node7", "node2", "node6", "node1", "node4", "node7" };
			String[] nodeOrderWayBack = { "node3", "node7", "node2", "node6", "node1", "node4", "node7" };
			TraverserChecker checker = new TraverserChecker();
			checker.nodeOrderWayThere = nodeOrderWayThere;
			checker.nodeOrderWayBack = nodeOrderWayBack;
			getFixture().setGraph(graph);
			getFixture().setGraph(graph);
			try {
				getFixture().traverse(startNodes, GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST, "test_BOTTOM_UP_BREADTH_FIRST_Cycle", checker);
				assertTrue(checker.checkNumberOfTraversedNodes());
			} catch (Exception e) {
				if (e instanceof SaltTraverserException) {

				} else {
					fail("The graph contains a cycle, that shall invoke an exception.");
				}
			}
		}
	}

	/**
	 * Tests the traversing of
	 * {@link GRAPH_TRAVERSE_TYPE#BOTTOM_UP_BREADTH_FIRST} of graph_Tree, with
	 * graph {@inheritDoc SGraphTest#createGraph_SimpleCycle()}.
	 */
	public void testTraverse_BOTTOM_UP_BREADTH_FIRST_CycleUnsafe() {
		SGraph<SNode, SRelation<SNode,SNode>> graph = SGraphTest.createGraph_SimpleCycle();
		List<SNode> startNodes = new ArrayList<>();
		startNodes.add(graph.getNode("node3"));
		startNodes.add(graph.getNode("node7"));
		String[] nodeOrderWayThere = { "node3", "node7", "node2", "node6", "node1", "node7", "node2", "node6", "node1" };
		String[] nodeOrderWayBack = nodeOrderWayThere.clone();
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		checker.isCycleSafe = false;
		getFixture().setGraph(graph);
		getFixture().traverse(startNodes, GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST, "test_BOTTOM_UP_BREADTH_FIRST_Cycle", checker, false);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}
}
