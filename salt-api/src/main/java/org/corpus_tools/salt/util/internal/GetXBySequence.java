package org.corpus_tools.salt.util.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SSequentialDS;
import org.corpus_tools.salt.common.SSequentialRelation;
import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.STextOverlappingRelation;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.STimeOverlappingRelation;
import org.corpus_tools.salt.common.STimeline;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.core.GraphTraverseHandler;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.graph.Relation;
import org.corpus_tools.salt.util.DataSourceSequence;

public class GetXBySequence {
	private final SDocumentGraph documentGraph;

	public GetXBySequence(SDocumentGraph documentGraph) {
		if (documentGraph == null) {
			throw new SaltParameterException("Cannot start method please set the document graph first.");
		}

		this.documentGraph = documentGraph;
	}

	/**
	 * Returns all {@link SToken} objects which refer to the passed
	 * {@link DataSourceSequence} object. The passed object determines the
	 * borders of the sequence by the values <em>sStart</em> and <em>sEnd</em>
	 * and the type of datasource by the instance <em>sSequentialDS</em>.
	 * 
	 * @param DataSourceSequence
	 *            an object determing the sequence to which the returned
	 *            {@link SToken} objects refer to.
	 * @return a list of {@link SToken} objects which refer or overlap the
	 *         passed sequence
	 */
	public List<SToken> getTokensBySequence(DataSourceSequence DataSourceSequence) {
		final List<SToken> tokens = ((List<SToken>) (List<? extends SNode>) getSNodesBySequence(DataSourceSequence,
				Arrays.<Class<? extends SNode>>asList(SToken.class)));
		return (tokens);
	}

	/**
	 * Returns all {@link SSpan} objects which refer to the passed
	 * {@link DataSourceSequence} object. The passed object determines the
	 * borders of the sequence by the values <em>sStart</em> and <em>sEnd</em>
	 * and the type of datasource by the instance <em>sSequentialDS</em>.
	 * 
	 * @param DataSourceSequence
	 *            an object determing the sequence to which the returned
	 *            {@link SSpan} objects refer to.
	 * @return a list of {@link SSpan} objects which refer or overlap the passed
	 *         sequence
	 */
	public List<SSpan> getSpanBySequence(DataSourceSequence DataSourceSequence) {
		final List<SSpan> spans = ((List<SSpan>) (List<? extends SNode>) getSNodesBySequence(DataSourceSequence,
				Arrays.<Class<? extends SNode>>asList(SSpan.class)));
		return (spans);
	}

	/**
	 * Returns all {@link SStructure} objects which refer to the passed
	 * {@link DataSourceSequence} object. The passed object determines the
	 * borders of the sequence by the values <em>sStart</em> and <em>sEnd</em>
	 * and the type of datasource by the instance <em>sSequentialDS</em>.
	 * 
	 * @param DataSourceSequence
	 *            an object determing the sequence to which the returned
	 *            {@link SStructure} objects refer to.
	 * @return a list of {@link SStructure} objects which refer or overlap the
	 *         passed sequence
	 */
	public List<SStructure> getStructureBySequence(DataSourceSequence DataSourceSequence) {
		final List<SStructure> structs = ((List<SStructure>) (List<? extends SNode>) getSNodesBySequence(
				DataSourceSequence, Arrays.<Class<? extends SNode>>asList(SStructure.class)));
		return (structs);
	}

	/**
	 * Returns all {@link SNode} objects which refer to the passed
	 * {@link DataSourceSequence} object. The passed object determines the
	 * borders of the sequence by the values <em>sStart</em> and <em>sEnd</em>
	 * and the type of datasource by the instance <em>sSequentialDS</em>.
	 * 
	 * @param DataSourceSequence
	 *            an object determing the sequence to which the returned
	 *            {@link SNode} objects refer to.
	 * @return a list of {@link SNode} objects which refer or overlap the passed
	 *         sequence
	 */
	public List<SNode> getNodeBySequence(DataSourceSequence DataSourceSequence) {
		final List<SNode> nodes = getSNodesBySequence(DataSourceSequence,
				Arrays.<Class<? extends SNode>>asList(SNode.class));
		return (nodes);
	}

	/**
	 * Searches for all {@link SNode} objects of the given node type, which
	 * cover the given sequence.
	 * 
	 * @param sequence
	 *            sequence, which is overlapped
	 * @param nodeClasses
	 *            type of nodes to be returned
	 * @return nodes, which overlaps the given sequence
	 */
	private List<SNode> getSNodesBySequence(DataSourceSequence sequence, List<Class<? extends SNode>> nodeClasses) {
		if (sequence == null) {
			throw new SaltParameterException(
					"Cannot start returning nodes overlapping a data source, because the 'DataSourceSequence' object, determining the sequence which shall be overlapped is empty.");
		}
		if (sequence.getStart() == null) {
			throw new SaltParameterException(
					"Cannot start returning nodes overlapping a data source, because the 'sStart' value of the 'DataSourceSequence' object, determining the sequence which shall be overlapped is empty.");
		}
		if (sequence.getEnd() == null) {
			throw new SaltParameterException(
					"Cannot start returning nodes overlapping a data source, because the 'sEnd' value of the 'DataSourceSequence' object, determining the sequence which shall be overlapped is empty.");
		}

		final List<? extends SSequentialRelation> relations = findRelationsToDataSourceSequence(documentGraph,
				sequence);
		final List<SToken> tokens = findTokensReferedByRelationsInSequence(relations, sequence);
		final List<SNode> nodes = new ArrayList<>();
		nodes.addAll(findNodesOverlappingTokens(tokens, nodeClasses, findRelationTypeToDataSourceSequence(sequence)));
		return (nodes);
	}

	Class<? extends Relation> findRelationTypeToDataSourceSequence(DataSourceSequence<?> sequence) {
		if (sequence == null || sequence.getDataSource() == null) {
			return null;
		}
		if (sequence.getDataSource() instanceof STextualDS) {
			return STextOverlappingRelation.class;
		} else if (sequence.getDataSource() instanceof STimeline) {
			return STimeOverlappingRelation.class;
		}
		return null;
	}

	private List<? extends SSequentialRelation> findRelationsToDataSourceSequence(SDocumentGraph documentGraph,
			DataSourceSequence<Number> sequence) {
		List<? extends SSequentialRelation> relations = null;
		if (sequence.getDataSource() instanceof STextualDS) {
			relations = documentGraph.getTextualRelations();
		} else if (sequence.getDataSource() instanceof STimeline) {
			relations = documentGraph.getTimelineRelations();
		} else {
			throw new SaltParameterException(
					"Cannot compute overlaped nodes, because the given dataSource is not supported by this method.");
		}
		return relations;
	}

	private List<SToken> findTokensReferedByRelationsInSequence(List<? extends SSequentialRelation> relations,
			DataSourceSequence sequence) {
		final List<SToken> tokens = new ArrayList<>();
		for (SSequentialRelation<SToken, ? extends SSequentialDS, ? extends Number> seqRel : relations) {
			// walk through all sequential relations
			if ((sequence.getDataSource().equals(seqRel.getTarget()))
					&& (seqRel.getStart().doubleValue() >= sequence.getStart().doubleValue())
					&& (seqRel.getEnd().doubleValue() <= sequence.getEnd().doubleValue())) {
				// sequential relation is in the interval
				tokens.add(seqRel.getSource());
			}
		}
		return tokens;
	}

	private Set<SNode> findNodesOverlappingTokens(List<SToken> tokens, final List<Class<? extends SNode>> nodeClasses,
			final Class<? extends Relation> relationClazz) {
		if (tokens.isEmpty()) {
			return Collections.emptySet();
		}
		final Set<SNode> overlappingNodes = new HashSet<>();
		documentGraph.traverse((List<SNode>) (List<? extends SNode>) tokens, GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST,
				"", new GraphTraverseHandler() {
					@Override
					public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode,
							SRelation<SNode, SNode> relation, SNode fromNode, long order) {
						if (nodeClasses == null) {
							return;
						}
						for (Class<? extends SNode> nodeClass : nodeClasses) {
							if (nodeClass.isAssignableFrom(currNode.getClass())) {
								overlappingNodes.add(currNode);
							}
						}
					}

					@Override
					public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode,
							SRelation<SNode, SNode> relation, SNode fromNode, long order) {
					}

					@Override
					public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType, String traversalId,
							SRelation<SNode, SNode> relation, SNode currNode, long order) {
						if (relation == null) {
							return true;
						}
						if (relationClazz != null) {
							if (relationClazz.isAssignableFrom(relation.getClass())) {
								return true;
							}
						}
						return false;
					}
				}, false);
		return overlappingNodes;
	}
}
