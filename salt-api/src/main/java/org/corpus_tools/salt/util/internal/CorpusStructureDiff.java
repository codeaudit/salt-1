package org.corpus_tools.salt.util.internal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.core.GraphTraverseHandler;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.util.DIFF_TYPES;
import org.corpus_tools.salt.util.Difference;
import org.corpus_tools.salt.util.SaltUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CorpusStructureDiff extends AbstractDiff<SCorpusGraph> {
	private static final Logger logger = LoggerFactory.getLogger(CorpusStructureDiff.class);

	public CorpusStructureDiff(SCorpusGraph template, SCorpusGraph other) {
		super(template, other);
	}

	public CorpusStructureDiff(SCorpusGraph template, SCorpusGraph other, Map<String, Boolean> optionMap) {
		super(template, other, optionMap);
	}

	/**
	 * Compares the set graphs and returns if they are isomorphic or not. If
	 * graphs are not isomporphic, this method finds and records all differences
	 * and lists them. This means the entire graphs have to be compared and
	 * could slow down the computation. If you are only interested in the result
	 * and not in the particular differences, use method {@link #isIsomorph()}.
	 * 
	 * @param diffsRequested
	 *            if false, only isomorphie is computed, which makes the process
	 *            faster but does not collect all differences
	 * @return true, if graphs are isomorphic, false otherwise.
	 */
	@Override
	protected boolean findDiffs(boolean diffsRequested) {
		if (!compareSize(templateGraph, otherGraph)) {
			if (!diffsRequested) {
				return false;
			}
		}
		final List<SNode> templateRoots = templateGraph.getRoots();
		final List<SNode> otherRoots = otherGraph.getRoots();
		if (SaltUtil.isNotNullOrEmpty(otherRoots) && SaltUtil.isNotNullOrEmpty(templateRoots)) {
			for (SNode templateRoot : templateRoots) {
				for (SNode otherRoot : otherRoots) {
					boolean isIsomorph = true;
					// check whether both data sources have the same id
					Set<Difference> subDiffs = new HashSet<Difference>();
					compareIdentifiableElements(templateRoot, otherRoot, subDiffs);
					if (subDiffs.size() > 0) {
						if (!diffsRequested) {
							return false;
						}
						isIsomorph = false;
						addDifference(templateRoot, otherRoot, null, DIFF_TYPES.NODE_DIFFERING, subDiffs);
					}
					// check whether both data sources have the same labels
					subDiffs = new HashSet<Difference>();
					compareAnnotationContainers(templateRoot, otherRoot, subDiffs);
					if (subDiffs.size() > 0) {
						if (!diffsRequested) {
							return false;
						}
						isIsomorph = false;
						addDifference(templateRoot, otherRoot, null, DIFF_TYPES.NODE_DIFFERING, subDiffs);
					}
					if (isIsomorph) {
						getIsoNodes().put(templateRoot, otherRoot);
					}
				}
			}

			final List<SNode> remainingOtherNodes = new ArrayList<>(templateGraph.getCorpora().size() + templateGraph.getDocuments().size());
			remainingOtherNodes.addAll(otherGraph.getCorpora());
			remainingOtherNodes.addAll(otherGraph.getDocuments());
			final DifferenceHandler handler = new DifferenceHandler();
			handler.remainingTemplateNodes = remainingOtherNodes;
			templateGraph.traverse(templateRoots, GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, "diff_" + templateGraph.getId(), handler, false);
			if (getDifferences().size() > 0) {
				return (false);
			}
			if (remainingOtherNodes.size() > 0) {
				for (SNode remainingNode : remainingOtherNodes) {
					if (!diffsRequested) {
						return false;
					}
					addDifference(null, remainingNode, null, DIFF_TYPES.NODE_MISSING, null);
				}
			}
		}
		return true;
	}

	private class DifferenceHandler implements GraphTraverseHandler {
		List<SNode> remainingTemplateNodes = null;
		private boolean abort = false;
		/**
		 * set of already visited {@link SRelation}s while traversing, this is
		 * necessary to avoid cycles
		 **/
		private Set<SRelation> visitedRelations = new HashSet<>();

		/**
		 * Called by Pepper as callback, when otherGraph is traversed. Currently
		 * only returns <code>true</code> to traverse the entire graph.
		 */
		@Override
		public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SRelation sRelation, SNode currNode, long order) {
			boolean retVal = true;
			if (sRelation != null) {
				if (visitedRelations.contains(sRelation)) {
					retVal = false;
				} else {
					visitedRelations.add(sRelation);
				}
			}
			return (retVal);
		}

		/**
		 * Called by Pepper as callback, when otherGraph is traversed. Currently
		 * is empty.
		 */
		@Override
		public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation sRelation, SNode fromNode, long order) {
			if (fromNode != null && currNode != null) {
				final SNode otherParent = getIsoNodes().get(fromNode);
				final List<SNode> otherChilds = otherGraph.getChildren(otherParent, null);
				boolean hasFoundNode = false;
				for (SNode otherChild : otherChilds) {
					if (currNode.getClass().equals(otherChild.getClass()))
						if (compareIdentifiableElements(currNode, otherChild, null)) {
							if (compareAnnotationContainers(currNode, otherChild, null)) {
								// found matching child
								getIsoNodes().put(currNode, otherChild);
								hasFoundNode = true;
								break;
							}
						}
				}
				if (!hasFoundNode) {
					addDifference(currNode, null, null, DIFF_TYPES.NODE_MISSING, null);
				}
			}
		}

		/**
		 * Called by Pepper as callback, when otherGraph is traversed.
		 */
		@Override
		public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation edge, SNode otherNode, long order) {
		}

	}

	/**
	 * This method tests whether in both graphs are the same number of objects
	 * contained. Number of:
	 * <ul>
	 * <li>nodes</li>
	 * <li>relations</li>
	 * <li>corpora</li>
	 * <li>corpus relations</li>
	 * <li>documents</li>
	 * <li>corpus document relations</li>
	 * </ul>
	 * 
	 * @param template
	 *            first SDocGraph
	 * @param other
	 *            second SDocGraph
	 * @return returns whether sizes are the same
	 **/
	private static boolean compareSize(final SCorpusGraph template, final SCorpusGraph other) {
		// size comparison for all data structures in Salt beside STimeline
		if (template.getNodes().size() != other.getNodes().size()) {
			return false;
		}
		if (template.getRelations().size() != other.getRelations().size()) {
			return false;
		}
		if (template.getCorpora().size() != other.getCorpora().size()) {
			return false;
		}
		if (template.getCorpusRelations().size() != other.getCorpusRelations().size()) {
			return false;
		}
		if (template.getDocuments().size() != other.getDocuments().size()) {
			return false;
		}
		if (template.getCorpusDocumentRelations().size() != other.getCorpusDocumentRelations().size()) {
			return false;
		}
		return true;
	}
}