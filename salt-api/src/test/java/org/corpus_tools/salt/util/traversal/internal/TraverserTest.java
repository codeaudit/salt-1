package org.corpus_tools.salt.util.traversal.internal;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.util.traversal.BackAndForthTraverseHandler;
import org.corpus_tools.salt.util.traversal.TraversalFilter;
import org.corpus_tools.salt.util.traversal.TraversalLocation;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;
import org.corpus_tools.salt.util.traversal.internal.Traverser;
import org.junit.Test;

public class TraverserTest {

	private TraversalFilter FILTER_TRUE = new TraversalFilter() {
		@Override
		public boolean test(TraversalLocation arg0) {
			return true;
		}
	};

	private TraversalFilter FILTER_FALSE = new TraversalFilter() {
		@Override
		public boolean test(TraversalLocation arg0) {
			return false;
		}
	};

	private final Collection<TraversalFilter> filters = new ArrayList<>();
	private boolean result;
	private BackAndForthTraverseHandler traversalHandler = null;

	private void when(boolean isFilterTest) {
		Traverser traverser = new Traverser(null, null, null, traversalHandler, false, null, filters) {
			@Override
			public void traverse() {
			}
		};
		TraversalLocation location = TraversalLocation.createWithStrategy(TraversalStrategy.BOTTOM_UP_BREADTH_FIRST)
				.withCurrentNode(SaltFactory.createSNode())
				.build();
		result = isFilterTest ? traverser.filter(location) : traverser.filterAndCheckShouldGoOn(location);
	}

	@Test
	public void whenFilteringWithMultipleFiltersAndOneReturnsTrue_resultMustBeTrue() {
		filters.addAll(Arrays.asList(FILTER_FALSE, FILTER_FALSE, FILTER_TRUE, FILTER_FALSE));
		when(true);
		assertThat(result).isTrue();
	}

	@Test
	public void whenFilteringWithMultipleFiltersAndAllReturnsTrue_resultMustBeTrue() {
		filters.addAll(Arrays.asList(FILTER_TRUE, FILTER_TRUE, FILTER_TRUE, FILTER_TRUE));
		when(true);
		assertThat(result).isTrue();
	}

	@Test
	public void whenFilteringWithMultipleFiltersAndAllReturnsFalse_resultMustBeFalse() {
		filters.addAll(Arrays.asList(FILTER_FALSE, FILTER_FALSE, FILTER_FALSE, FILTER_FALSE));
		when(true);
		assertThat(result).isFalse();
	}

	@Test
	public void whenfilterAndCheckShouldGoOnAndFilterIsFalseAndShouldGoOnIsTrue_resultMustBeFalse() {
		filters.add(FILTER_FALSE);
		traversalHandler = new BackAndForthTraverseHandler() {
			@Override
			public boolean shouldTraversalGoOn(TraversalLocation location) {
				return true;
			}

			@Override
			public void nodeReachedOnWayForth(TraversalLocation location) {
			}

			@Override
			public void nodeReachedOnWayBack(TraversalLocation location) {
			}
		};
		when(false);
		assertThat(result).isFalse();
	}

	@Test
	public void whenfilterAndCheckShouldGoOnAndFilterIsTrueAndShouldGoOnIsFalse_resultMustBeFalse() {
		filters.add(FILTER_TRUE);
		traversalHandler = new BackAndForthTraverseHandler() {
			@Override
			public boolean shouldTraversalGoOn(TraversalLocation location) {
				return false;
			}

			@Override
			public void nodeReachedOnWayForth(TraversalLocation location) {
			}

			@Override
			public void nodeReachedOnWayBack(TraversalLocation location) {
			}
		};
		when(false);
		assertThat(result).isFalse();
	}

	@Test
	public void whenfilterAndCheckShouldGoOnAndFilterIsFalseAndShouldGoOnIsFalse_resultMustBeFalse() {
		filters.add(FILTER_FALSE);
		traversalHandler = new BackAndForthTraverseHandler() {
			@Override
			public boolean shouldTraversalGoOn(TraversalLocation location) {
				return false;
			}

			@Override
			public void nodeReachedOnWayForth(TraversalLocation location) {
			}

			@Override
			public void nodeReachedOnWayBack(TraversalLocation location) {
			}
		};
		when(false);
		assertThat(result).isFalse();
	}

	@Test
	public void whenfilterAndCheckShouldGoOnAndFilterIsTrueAndShouldGoOnIsTrue_resultMustBeTrue() {
		filters.add(FILTER_TRUE);
		traversalHandler = new BackAndForthTraverseHandler() {
			@Override
			public boolean shouldTraversalGoOn(TraversalLocation location) {
				return true;
			}

			@Override
			public void nodeReachedOnWayForth(TraversalLocation location) {
			}

			@Override
			public void nodeReachedOnWayBack(TraversalLocation location) {
			}
		};
		when(false);
		assertThat(result).isTrue();
	}
}
