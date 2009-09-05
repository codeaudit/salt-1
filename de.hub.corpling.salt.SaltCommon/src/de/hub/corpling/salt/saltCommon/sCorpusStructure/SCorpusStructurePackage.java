/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sCorpusStructure;

import de.hub.corpling.salt.saltCore.SaltCorePackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructureFactory
 * @model kind="package"
 * @generated
 */
public interface SCorpusStructurePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sCorpusStructure";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "sCorpusStructure";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sCorpusStructure";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SCorpusStructurePackage eINSTANCE = de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl <em>SCorpus Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl#getSCorpusGraph()
	 * @generated
	 */
	int SCORPUS_GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__NAME = SaltCorePackage.SGRAPH__NAME;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SANNOTATIONS = SaltCorePackage.SGRAPH__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SELEMENT_ID = SaltCorePackage.SGRAPH__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SRelations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SRELATIONS = SaltCorePackage.SGRAPH__SRELATIONS;

	/**
	 * The feature id for the '<em><b>SNodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SNODES = SaltCorePackage.SGRAPH__SNODES;

	/**
	 * The feature id for the '<em><b>SDocuments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SDOCUMENTS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Salt Project</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SALT_PROJECT = SaltCorePackage.SGRAPH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SCorpora</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SCORPORA = SaltCorePackage.SGRAPH_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>SCorpus Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SCORPUS_RELATIONS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>SCorpus Document Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SCORPUS_DOCUMENT_RELATIONS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>SCorpus Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH_FEATURE_COUNT = SaltCorePackage.SGRAPH_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SDocumentImpl <em>SDocument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SDocumentImpl
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl#getSDocument()
	 * @generated
	 */
	int SDOCUMENT = 1;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SANNOTATIONS = SaltCorePackage.SNODE__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__NAME = SaltCorePackage.SNODE__NAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SELEMENT_ID = SaltCorePackage.SNODE__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SGRAPH = SaltCorePackage.SNODE__SGRAPH;

	/**
	 * The feature id for the '<em><b>SCorpus Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SCORPUS_GRAPH = SaltCorePackage.SNODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SDOCUMENT_GRAPH = SaltCorePackage.SNODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>SDocument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_FEATURE_COUNT = SaltCorePackage.SNODE_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusImpl <em>SCorpus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusImpl
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl#getSCorpus()
	 * @generated
	 */
	int SCORPUS = 2;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SANNOTATIONS = SaltCorePackage.SNODE__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__NAME = SaltCorePackage.SNODE__NAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SELEMENT_ID = SaltCorePackage.SNODE__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SGRAPH = SaltCorePackage.SNODE__SGRAPH;

	/**
	 * The feature id for the '<em><b>SCorpus Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SCORPUS_GRAPH = SaltCorePackage.SNODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SCorpus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_FEATURE_COUNT = SaltCorePackage.SNODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusRelationImpl <em>SCorpus Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusRelationImpl
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl#getSCorpusRelation()
	 * @generated
	 */
	int SCORPUS_RELATION = 3;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__NAME = SaltCorePackage.SRELATION__NAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SELEMENT_ID = SaltCorePackage.SRELATION__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Source SNode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SOURCE_SNODE = SaltCorePackage.SRELATION__SOURCE_SNODE;

	/**
	 * The feature id for the '<em><b>Target SNode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__TARGET_SNODE = SaltCorePackage.SRELATION__TARGET_SNODE;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SGRAPH = SaltCorePackage.SRELATION__SGRAPH;

	/**
	 * The feature id for the '<em><b>SSuper Corpus</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SSUPER_CORPUS = SaltCorePackage.SRELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SSub Corpus</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SSUB_CORPUS = SaltCorePackage.SRELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SCorpus Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SCORPUS_GRAPH = SaltCorePackage.SRELATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SCorpus Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION_FEATURE_COUNT = SaltCorePackage.SRELATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusDocumentRelationImpl <em>SCorpus Document Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusDocumentRelationImpl
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl#getSCorpusDocumentRelation()
	 * @generated
	 */
	int SCORPUS_DOCUMENT_RELATION = 4;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__NAME = SaltCorePackage.SRELATION__NAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SELEMENT_ID = SaltCorePackage.SRELATION__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Source SNode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SOURCE_SNODE = SaltCorePackage.SRELATION__SOURCE_SNODE;

	/**
	 * The feature id for the '<em><b>Target SNode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__TARGET_SNODE = SaltCorePackage.SRELATION__TARGET_SNODE;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SGRAPH = SaltCorePackage.SRELATION__SGRAPH;

	/**
	 * The feature id for the '<em><b>SCorpus</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SCORPUS = SaltCorePackage.SRELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SDocument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SDOCUMENT = SaltCorePackage.SRELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SCorpus Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SCORPUS_GRAPH = SaltCorePackage.SRELATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SCorpus Document Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION_FEATURE_COUNT = SaltCorePackage.SRELATION_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCorpus Graph</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph
	 * @generated
	 */
	EClass getSCorpusGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSDocuments <em>SDocuments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SDocuments</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSDocuments()
	 * @see #getSCorpusGraph()
	 * @generated
	 */
	EReference getSCorpusGraph_SDocuments();

	/**
	 * Returns the meta object for the container reference '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSaltProject <em>Salt Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Salt Project</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSaltProject()
	 * @see #getSCorpusGraph()
	 * @generated
	 */
	EReference getSCorpusGraph_SaltProject();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpora <em>SCorpora</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SCorpora</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpora()
	 * @see #getSCorpusGraph()
	 * @generated
	 */
	EReference getSCorpusGraph_SCorpora();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusRelations <em>SCorpus Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SCorpus Relations</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusRelations()
	 * @see #getSCorpusGraph()
	 * @generated
	 */
	EReference getSCorpusGraph_SCorpusRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusDocumentRelations <em>SCorpus Document Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SCorpus Document Relations</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusDocumentRelations()
	 * @see #getSCorpusGraph()
	 * @generated
	 */
	EReference getSCorpusGraph_SCorpusDocumentRelations();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument <em>SDocument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SDocument</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument
	 * @generated
	 */
	EClass getSDocument();

	/**
	 * Returns the meta object for the container reference '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument#getSCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SCorpus Graph</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument#getSCorpusGraph()
	 * @see #getSDocument()
	 * @generated
	 */
	EReference getSDocument_SCorpusGraph();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SDocument Graph</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument#getSDocumentGraph()
	 * @see #getSDocument()
	 * @generated
	 */
	EReference getSDocument_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus <em>SCorpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCorpus</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus
	 * @generated
	 */
	EClass getSCorpus();

	/**
	 * Returns the meta object for the container reference '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus#getSCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SCorpus Graph</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus#getSCorpusGraph()
	 * @see #getSCorpus()
	 * @generated
	 */
	EReference getSCorpus_SCorpusGraph();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation <em>SCorpus Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCorpus Relation</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation
	 * @generated
	 */
	EClass getSCorpusRelation();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSSuperCorpus <em>SSuper Corpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SSuper Corpus</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSSuperCorpus()
	 * @see #getSCorpusRelation()
	 * @generated
	 */
	EReference getSCorpusRelation_SSuperCorpus();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSSubCorpus <em>SSub Corpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SSub Corpus</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSSubCorpus()
	 * @see #getSCorpusRelation()
	 * @generated
	 */
	EReference getSCorpusRelation_SSubCorpus();

	/**
	 * Returns the meta object for the container reference '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SCorpus Graph</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSCorpusGraph()
	 * @see #getSCorpusRelation()
	 * @generated
	 */
	EReference getSCorpusRelation_SCorpusGraph();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation <em>SCorpus Document Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCorpus Document Relation</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation
	 * @generated
	 */
	EClass getSCorpusDocumentRelation();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpus <em>SCorpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SCorpus</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpus()
	 * @see #getSCorpusDocumentRelation()
	 * @generated
	 */
	EReference getSCorpusDocumentRelation_SCorpus();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSDocument <em>SDocument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SDocument</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSDocument()
	 * @see #getSCorpusDocumentRelation()
	 * @generated
	 */
	EReference getSCorpusDocumentRelation_SDocument();

	/**
	 * Returns the meta object for the container reference '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SCorpus Graph</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpusGraph()
	 * @see #getSCorpusDocumentRelation()
	 * @generated
	 */
	EReference getSCorpusDocumentRelation_SCorpusGraph();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SCorpusStructureFactory getSCorpusStructureFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl <em>SCorpus Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl
		 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl#getSCorpusGraph()
		 * @generated
		 */
		EClass SCORPUS_GRAPH = eINSTANCE.getSCorpusGraph();

		/**
		 * The meta object literal for the '<em><b>SDocuments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_GRAPH__SDOCUMENTS = eINSTANCE.getSCorpusGraph_SDocuments();

		/**
		 * The meta object literal for the '<em><b>Salt Project</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_GRAPH__SALT_PROJECT = eINSTANCE.getSCorpusGraph_SaltProject();

		/**
		 * The meta object literal for the '<em><b>SCorpora</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_GRAPH__SCORPORA = eINSTANCE.getSCorpusGraph_SCorpora();

		/**
		 * The meta object literal for the '<em><b>SCorpus Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_GRAPH__SCORPUS_RELATIONS = eINSTANCE.getSCorpusGraph_SCorpusRelations();

		/**
		 * The meta object literal for the '<em><b>SCorpus Document Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_GRAPH__SCORPUS_DOCUMENT_RELATIONS = eINSTANCE.getSCorpusGraph_SCorpusDocumentRelations();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SDocumentImpl <em>SDocument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SDocumentImpl
		 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl#getSDocument()
		 * @generated
		 */
		EClass SDOCUMENT = eINSTANCE.getSDocument();

		/**
		 * The meta object literal for the '<em><b>SCorpus Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT__SCORPUS_GRAPH = eINSTANCE.getSDocument_SCorpusGraph();

		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT__SDOCUMENT_GRAPH = eINSTANCE.getSDocument_SDocumentGraph();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusImpl <em>SCorpus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusImpl
		 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl#getSCorpus()
		 * @generated
		 */
		EClass SCORPUS = eINSTANCE.getSCorpus();

		/**
		 * The meta object literal for the '<em><b>SCorpus Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS__SCORPUS_GRAPH = eINSTANCE.getSCorpus_SCorpusGraph();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusRelationImpl <em>SCorpus Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusRelationImpl
		 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl#getSCorpusRelation()
		 * @generated
		 */
		EClass SCORPUS_RELATION = eINSTANCE.getSCorpusRelation();

		/**
		 * The meta object literal for the '<em><b>SSuper Corpus</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_RELATION__SSUPER_CORPUS = eINSTANCE.getSCorpusRelation_SSuperCorpus();

		/**
		 * The meta object literal for the '<em><b>SSub Corpus</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_RELATION__SSUB_CORPUS = eINSTANCE.getSCorpusRelation_SSubCorpus();

		/**
		 * The meta object literal for the '<em><b>SCorpus Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_RELATION__SCORPUS_GRAPH = eINSTANCE.getSCorpusRelation_SCorpusGraph();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusDocumentRelationImpl <em>SCorpus Document Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusDocumentRelationImpl
		 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl#getSCorpusDocumentRelation()
		 * @generated
		 */
		EClass SCORPUS_DOCUMENT_RELATION = eINSTANCE.getSCorpusDocumentRelation();

		/**
		 * The meta object literal for the '<em><b>SCorpus</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_DOCUMENT_RELATION__SCORPUS = eINSTANCE.getSCorpusDocumentRelation_SCorpus();

		/**
		 * The meta object literal for the '<em><b>SDocument</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_DOCUMENT_RELATION__SDOCUMENT = eINSTANCE.getSCorpusDocumentRelation_SDocument();

		/**
		 * The meta object literal for the '<em><b>SCorpus Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_DOCUMENT_RELATION__SCORPUS_GRAPH = eINSTANCE.getSCorpusDocumentRelation_SCorpusGraph();

	}

} //SCorpusStructurePackage