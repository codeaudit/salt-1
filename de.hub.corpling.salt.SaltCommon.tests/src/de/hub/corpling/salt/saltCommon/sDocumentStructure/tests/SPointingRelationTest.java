/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SStructuredNode;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SPointing Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SPointingRelation#getSStructuredSource() <em>SStructured Source</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SPointingRelation#getSStructuredTarget() <em>SStructured Target</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SPointingRelation#getSDocumentGraph() <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SPointingRelationTest extends TestCase {

	/**
	 * The fixture for this SPointing Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SPointingRelation fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SPointingRelationTest.class);
	}

	/**
	 * Constructs a new SPointing Relation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SPointingRelationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SPointing Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SPointingRelation fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SPointing Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SPointingRelation getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SDocumentStructureFactory.eINSTANCE.createSPointingRelation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SPointingRelation#getSStructuredSource() <em>SStructured Source</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SPointingRelation#getSStructuredSource()
	 */
	public void testGetSStructuredSource() 
	{
		SStructuredNode sStructSource= null;
		
		//test for token
		sStructSource= SaltCommonFactory.eINSTANCE.createSToken();
		this.getFixture().setSStructuredSource(sStructSource);
		assertEquals(sStructSource, this.getFixture().getSStructuredSource());
		
		//test for span
		sStructSource= SaltCommonFactory.eINSTANCE.createSSpan();
		this.getFixture().setSStructuredSource(sStructSource);
		assertEquals(sStructSource, this.getFixture().getSStructuredSource());
		
		//test for structure
		sStructSource= SaltCommonFactory.eINSTANCE.createSStructure();
		this.getFixture().setSStructuredSource(sStructSource);
		assertEquals(sStructSource, this.getFixture().getSStructuredSource());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SPointingRelation#setSStructuredSource(de.hub.corpling.salt.saltCommon.sDocumentStructure.SStructuredNode) <em>SStructured Source</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SPointingRelation#setSStructuredSource(de.hub.corpling.salt.saltCommon.sDocumentStructure.SStructuredNode)
	 */
	public void testSetSStructuredSource() 
	{
		this.testGetSStructuredSource();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SPointingRelation#getSStructuredTarget() <em>SStructured Target</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SPointingRelation#getSStructuredTarget()
	 */
	public void testGetSStructuredTarget() 
	{
		SStructuredNode sStructTarget= null;
		
		//test for token
		sStructTarget= SaltCommonFactory.eINSTANCE.createSToken();
		this.getFixture().setSStructuredTarget(sStructTarget);
		assertEquals(sStructTarget, this.getFixture().getSStructuredTarget());
		
		//test for span
		sStructTarget= SaltCommonFactory.eINSTANCE.createSSpan();
		this.getFixture().setSStructuredTarget(sStructTarget);
		assertEquals(sStructTarget, this.getFixture().getSStructuredTarget());
		
		//test for structure
		sStructTarget= SaltCommonFactory.eINSTANCE.createSStructure();
		this.getFixture().setSStructuredTarget(sStructTarget);
		assertEquals(sStructTarget, this.getFixture().getSStructuredTarget());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SPointingRelation#setSStructuredTarget(de.hub.corpling.salt.saltCommon.sDocumentStructure.SStructuredNode) <em>SStructured Target</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SPointingRelation#setSStructuredTarget(de.hub.corpling.salt.saltCommon.sDocumentStructure.SStructuredNode)
	 */
	public void testSetSStructuredTarget() 
	{
		this.testGetSStructuredTarget();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SPointingRelation#getSDocumentGraph() <em>SDocument Graph</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SPointingRelation#getSDocumentGraph()
	 */
	public void testGetSDocumentGraph() 
	{
		SDocumentGraph sSDocumentGraph= SaltCommonFactory.eINSTANCE.createSDocumentGraph();
		this.getFixture().setSDocumentGraph(sSDocumentGraph);
		assertEquals(sSDocumentGraph, this.getFixture().getSDocumentGraph());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SPointingRelation#setSDocumentGraph(de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph) <em>SDocument Graph</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SPointingRelation#setSDocumentGraph(de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph)
	 */
	public void testSetSDocumentGraph() 
	{
		this.testGetSDocumentGraph();
	}

} //SPointingRelationTest
