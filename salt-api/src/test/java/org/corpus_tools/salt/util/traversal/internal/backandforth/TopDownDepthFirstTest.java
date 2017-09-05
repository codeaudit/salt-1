package org.corpus_tools.salt.util.traversal.internal.backandforth;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.corpus_tools.salt.graph.SampleGraphs;
import org.corpus_tools.salt.util.traversal.ExcludeFilter;
import org.corpus_tools.salt.util.traversal.TraversalLocation;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;
import org.junit.Before;
import org.junit.Test;

public class TopDownDepthFirstTest extends TraverserTest {
	@Before
	public void beforeEach() {
		strategy = TraversalStrategy.TOP_DOWN_DEPTH_FIRST;
	}

	@Test
	public void whenGraphIsTree() {
		// GIVEN
		graph = SampleGraphs.createTree();
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n1", "n2", "n3", "n4", "n5", "n6", "n7");
		assertThat(nodeOrderWayBack).containsExactly("n3", "n4", "n2", "n6", "n5", "n7", "n1");
	}

	@Test
	public void whenGraphIsTreeAndTraversalShouldNotGoOn() {
		// GIVEN
		graph = SampleGraphs.createTree();
		stopNodes.addAll(Arrays.asList("n3", "n4", "n6", "n7"));
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n1", "n2", "n5");
		assertThat(nodeOrderWayBack).containsExactly("n2", "n5", "n1");
	}

	@Test
	public void whenGraphIsDiamond() {
		// GIVEN
		graph = SampleGraphs.createDiamond();
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n1", "n2", "n3", "n4", "n3");
		assertThat(nodeOrderWayBack).containsExactly("n3", "n2", "n3", "n4", "n1");
	}

	@Test
	public void whenGraphIsDiamondAndTraversalShouldNotGoOn() {
		// GIVEN
		graph = SampleGraphs.createDiamond();
		stopNodes.add("n3");
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n1", "n2", "n4");
		assertThat(nodeOrderWayBack).containsExactly("n2", "n4", "n1");
	}

	@Test
	public void whenGraphIsDag() {
		// GIVEN
		graph = SampleGraphs.createDag();
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n1", "n2", "n3", "n6", "n4", "n2", "n3", "n6");
		assertThat(nodeOrderWayBack).containsExactly("n3", "n6", "n2", "n1", "n3", "n6", "n2", "n4");
	}

	@Test
	public void whenGraphIsDagAndTraversalShouldNotGoOn() {
		// GIVEN
		graph = SampleGraphs.createDag();
		stopNodes.add("n2");
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n1", "n4");
		assertThat(nodeOrderWayBack).containsExactly("n1", "n4");
	}

	@Test
	public void whenGraphIsCycledDagAndIsCycleSafe() {
		// GIVEN
		graph = SampleGraphs.createCycledDag();
		// WHEN
		when();
		// THEN no endless loop
	}

	@Test
	public void whenGraphIsCycledTreeAndIsNotCycleSafe() {
		// GIVEN
		graph = SampleGraphs.createCycledTree();
		preventRunInCycle = true;
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n1", "n2", "n3", "n6", "n7");
		assertThat(nodeOrderWayBack).containsExactly("n3", "n7", "n6", "n2", "n1");
	}

	@Test
	public void whenExcludingNothing_allNodesMustBeVisited() {
		// GIVEN
		graph = SampleGraphs.createTree();
		traversalFilter = new ExcludeFilter() {
			@Override
			public boolean test(TraversalLocation location) {
				return false;
			}
		};
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n1", "n2", "n3", "n4", "n5", "n6", "n7");
		assertThat(nodeOrderWayBack).containsExactly("n3", "n4", "n2", "n6", "n5", "n7", "n1");
	}

	@Test
	public void whenExcludingNodeN2_subgraphsMustNotBeVisited() {
		// GIVEN
		graph = SampleGraphs.createTree();
		traversalFilter = new ExcludeFilter() {
			@Override
			public boolean test(TraversalLocation location) {
				String nodeName = location.getCurrentNode().getName();
				if ("n2".equals(nodeName)) {
					return true;
				}
				return false;
			}
		};
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n1", "n5", "n6", "n7");
		assertThat(nodeOrderWayBack).containsExactly("n6", "n5", "n7", "n1");
	}
}
