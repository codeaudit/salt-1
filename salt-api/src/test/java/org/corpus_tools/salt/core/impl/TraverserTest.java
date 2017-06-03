package org.corpus_tools.salt.core.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.corpus_tools.salt.core.GraphTraverseHandler;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;

public abstract class TraverserTest implements GraphTraverseHandler {
	protected SGraph graph;
	protected List<SNode> startNodes;
	protected GRAPH_TRAVERSE_TYPE traverseType;
	protected boolean isCycleSafe = false;
	protected List<String> nodeOrderWayThere = new ArrayList<>();
	protected List<String> nodeOrderWayBack = new ArrayList<>();
	protected boolean preventRunInCycle = false;
	private final Stack<SNode> nodePath = new Stack<>();

	@Override
	public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode,
			SRelation<? extends SNode, ? extends SNode> relation, SNode fromNode, long order) {
		if (fromNode == null) {
			nodePath.clear();
		}
		nodePath.push(currNode);
		nodeOrderWayThere.add(currNode.getName());
	}

	@Override
	public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode,
			SRelation<? extends SNode, ? extends SNode> relation, SNode fromNode, long order) {
		nodeOrderWayBack.add(currNode.getName());
	}

	@Override
	public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType, String traversalId,
			SRelation<? extends SNode, ? extends SNode> relation, SNode currNode, long order) {
		if (preventRunInCycle && whenNodeWasReachedTwice(currNode)) {
			return false;
		}
		return true;
	}

	private boolean whenNodeWasReachedTwice(SNode currNode) {
		return nodePath.contains(currNode);
	}

	protected void when() {
		graph.traverse(startNodes, traverseType, "test_TOP_DOWN_BREADTH_FIRST_Tree", this, isCycleSafe);
	}
}