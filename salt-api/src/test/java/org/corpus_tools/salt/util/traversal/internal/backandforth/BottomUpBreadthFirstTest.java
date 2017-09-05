package org.corpus_tools.salt.util.traversal.internal.backandforth;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.corpus_tools.salt.graph.SampleGraphs;
import org.corpus_tools.salt.util.traversal.ExcludeFilter;
import org.corpus_tools.salt.util.traversal.TraversalLocation;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;
import org.junit.Before;
import org.junit.Test;

public class BottomUpBreadthFirstTest extends TraverserTest {
	@Before
	public void beforeEach() {
		strategy = TraversalStrategy.BOTTOM_UP_BREADTH_FIRST;
	}

	@Test
	public void whenGraphIsTree() {
		// GIVEN
		graph = SampleGraphs.createTree();
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n3", "n4", "n6", "n7", "n2", "n2", "n5", "n1", "n1", "n1", "n1");
		assertThat(nodeOrderWayBack).containsExactly("n3", "n4", "n6", "n7", "n2", "n2", "n5", "n1", "n1", "n1", "n1");
	}

	@Test
	public void whenGraphIsDag() {
		// GIVEN
		graph = SampleGraphs.createDag();
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n3", "n6", "n2", "n2", "n1", "n4", "n1", "n4");
		assertThat(nodeOrderWayBack).containsExactly("n3", "n6", "n2", "n2", "n1", "n4", "n1", "n4");
	}

	@Test
	public void whenCycleSafeIsEnabled() {
		// GIVEN
		graph = SampleGraphs.createCycledDag();
		// WHEN
		when();

		// THEN no endless loop
	}

	@Test
	public void whenGraphIsCycledTree() {
		// GIVEN
		graph = SampleGraphs.createCycledTree();
		startNodes = Arrays.asList(graph.getNodeByName("n3").get(), graph.getNodeByName("n7").get());
		preventRunInCycle = true;
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n3", "n7", "n2", "n6", "n1");
		assertThat(nodeOrderWayBack).containsExactly("n3", "n7", "n2", "n6", "n1");
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
		assertThat(nodeOrderWayThere).containsExactly("n3", "n4", "n6", "n7", "n2", "n2", "n5", "n1", "n1", "n1", "n1");
		assertThat(nodeOrderWayBack).containsExactly("n3", "n4", "n6", "n7", "n2", "n2", "n5", "n1", "n1", "n1", "n1");
	}

	@Test
	public void whenExcludingNodeN2_subgraphsMustNotBeVisited() {
		// GIVEN
		graph = SampleGraphs.createTree();
		traversalFilter = new ExcludeFilter() {
			@Override
			public boolean test(TraversalLocation location) {
				String nodeName = location.getCurrentNode().getName();
				if ("n2".equals(nodeName) || "n3".equals(nodeName)) {
					return true;
				}
				return false;
			}
		};
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n4", "n6", "n7", "n5", "n1", "n1");
		assertThat(nodeOrderWayBack).containsExactly("n4", "n6", "n7", "n5", "n1", "n1");
	}
}
