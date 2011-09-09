/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltElementNotContainedInGraphException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SDocument Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualDSs() <em>STextual DSs</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualRelations() <em>STextual Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens() <em>STokens</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline() <em>STimeline</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimelineRelations() <em>STimeline Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpanningRelations() <em>SSpanning Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpans() <em>SSpans</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSStructures() <em>SStructures</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDominanceRelations() <em>SDominance Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSPointingRelations() <em>SPointing Relations</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#addSNode(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME) <em>Add SNode</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SDocumentGraphTest extends TestCase {

	/**
	 * The fixture for this SDocument Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDocumentGraph fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SDocumentGraphTest.class);
	}

	/**
	 * Constructs a new SDocument Graph test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentGraphTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SDocument Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SDocumentGraph fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SDocument Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDocumentGraph getFixture() {
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
		setFixture(SDocumentStructureFactory.eINSTANCE.createSDocumentGraph());
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualDSs() <em>STextual DSs</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualDSs()
	 */
	public void testGetSTextualDSs() 
	{
		String[] ids= {"salt:/graph1#text1", "salt:/graph1#text2", "salt:/graph1#text3", "salt:/graph1#text4"};
		EList<STextualDS> textDSs= new BasicEList<STextualDS>();
		for (String id: ids)
		{
			STextualDS textDs= SaltCommonFactory.eINSTANCE.createSTextualDS();
			textDs.setSId(id);
			this.getFixture().addSNode(textDs);
			textDSs.add(textDs);
		}	
		
		assertTrue(textDSs.containsAll(this.getFixture().getSTextualDSs()));
		assertTrue(this.getFixture().getSTextualDSs().containsAll(textDSs));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualRelations() <em>STextual Relations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualRelations()
	 */
	public void testGetSTextualRelations() 
	{
		String[] ids= {"salt:/graph1#textRel1", "salt:/graph1#textRel2", "salt:/graph1#textRel3", "salt:/graph1#textRel4"};
		EList<STextualRelation> textRels= new BasicEList<STextualRelation>();
		for (String id: ids)
		{
			STextualRelation textRel= SaltCommonFactory.eINSTANCE.createSTextualRelation();
			textRel.setSId(id);
			this.getFixture().addSRelation(textRel);
			textRels.add(textRel);
		}	
		assertTrue(textRels.containsAll(this.getFixture().getSTextualRelations()));
		assertTrue(this.getFixture().getSTextualRelations().containsAll(textRels));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens() <em>STokens</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens()
	 */
	public void testGetSTokens() 
	{
		String[] ids= {"salt:/graph1#tok1", "salt:/graph1#tok2", "salt:/graph1#tok3", "salt:/graph1#tok4"};
		EList<SToken> toks= new BasicEList<SToken>();
		for (String id: ids)
		{
			SToken tok= SaltCommonFactory.eINSTANCE.createSToken();
			tok.setSId(id);
			this.getFixture().addSNode(tok);
			toks.add(tok);
		}	
		
		assertTrue(toks.containsAll(this.getFixture().getSTokens()));
		assertTrue(this.getFixture().getSTokens().containsAll(toks));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline() <em>STimeline</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline()
	 */
	public void testGetSTimeline() 
	{
		STimeline sTimeline= SaltCommonFactory.eINSTANCE.createSTimeline();
		EList<String> timeline= new BasicEList<String>();
		timeline.add("1.0");
		timeline.add("1.1");
		timeline.add("1.2");
		timeline.add("1.3");
		timeline.add("1.4");
		for (String point: timeline)
			sTimeline.addSPointOfTime(point);
		this.getFixture().setSTimeline(sTimeline);
		assertNotNull(this.getFixture().getSTimeline());
		assertNotNull(this.getFixture().getSTimeline().getSPointsOfTime());
		for (String point1: timeline)
		{
			boolean hasOpponend= false;
			for (String point2: this.getFixture().getSTimeline().getSPointsOfTime())
			{
				if (point1.equals(point2))
					hasOpponend= true;
			}
			assertTrue(hasOpponend);
		}
		assertTrue(timeline.containsAll(this.getFixture().getSTimeline().getSPointsOfTime()));
		assertTrue(this.getFixture().getSTimeline().getSPointsOfTime().containsAll(timeline));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#setSTimeline(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline) <em>STimeline</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#setSTimeline(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline)
	 */
	public void testSetSTimeline() 
	{
		this.testGetSTimeline();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimelineRelations() <em>STimeline Relations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimelineRelations()
	 */
	public void testGetSTimelineRelations() 
	{
		EList<STimelineRelation> timeRels= new BasicEList<STimelineRelation>();
		for (int i= 0; i< 10; i++)
		{
			STimelineRelation sTimeRel= SaltCommonFactory.eINSTANCE.createSTimelineRelation();
			timeRels.add(sTimeRel);
			this.getFixture().addSRelation(sTimeRel);
		}	
		assertTrue(timeRels.containsAll(this.getFixture().getSTimelineRelations()));
		assertTrue(this.getFixture().getSTimelineRelations().containsAll(timeRels));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpanningRelations() <em>SSpanning Relations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpanningRelations()
	 */
	public void testGetSSpanningRelations() 
	{
		EList<SSpanningRelation> spanRels= new BasicEList<SSpanningRelation>();
		for (int i= 0; i< 10; i++)
		{
			SSpanningRelation sSpanRel= SaltCommonFactory.eINSTANCE.createSSpanningRelation();
			spanRels.add(sSpanRel);
			this.getFixture().addSRelation(sSpanRel);
		}	
		assertTrue(spanRels.containsAll(this.getFixture().getSSpanningRelations()));
		assertTrue(this.getFixture().getSSpanningRelations().containsAll(spanRels));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpans() <em>SSpans</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpans()
	 */
	public void testGetSSpans() 
	{
		String[] names= {"salt:/graph1#span1", "salt:/graph1#span2", "salt:/graph1#span3", "salt:/graph1#span4"};
		EList<SSpan> spans= new BasicEList<SSpan>();
		for (String name: names)
		{
			SSpan span= SaltCommonFactory.eINSTANCE.createSSpan();
			span.setSName(name);
			this.getFixture().addSNode(span);
			spans.add(span);
		}	
		
		assertTrue(spans.containsAll(this.getFixture().getSSpans()));
		assertTrue(this.getFixture().getSSpans().containsAll(spans));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSStructures() <em>SStructures</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSStructures()
	 */
	public void testGetSStructures() 
	{
		String[] names= {"salt:/graph1#structure1", "salt:/graph1#structure2", "salt:/graph1#structure3", "salt:/graph1#structure4"};
		EList<SStructure> structures= new BasicEList<SStructure>();
		for (String name: names)
		{
			SStructure structure= SaltCommonFactory.eINSTANCE.createSStructure();
			structure.setSName(name);
			this.getFixture().addSNode(structure);
			structures.add(structure);
		}	
		
		assertTrue(structures.containsAll(this.getFixture().getSStructures()));
		assertTrue(this.getFixture().getSStructures().containsAll(structures));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDominanceRelations() <em>SDominance Relations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDominanceRelations()
	 */
	public void testGetSDominanceRelations() 
	{
		EList<SDominanceRelation> domRels= new BasicEList<SDominanceRelation>();
		for (int i= 0; i< 10; i++)
		{
			SDominanceRelation sDomRel= SaltCommonFactory.eINSTANCE.createSDominanceRelation();
			domRels.add(sDomRel);
			this.getFixture().addSRelation(sDomRel);
		}	
		assertTrue(domRels.containsAll(this.getFixture().getSDominanceRelations()));
		assertTrue(this.getFixture().getSDominanceRelations().containsAll(domRels));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSPointingRelations() <em>SPointing Relations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSPointingRelations()
	 */
	public void testGetSPointingRelations() 
	{
		EList<SPointingRelation> pointingRels= new BasicEList<SPointingRelation>();
		for (int i= 0; i< 10; i++)
		{
			SPointingRelation sDomRel= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			pointingRels.add(sDomRel);
			this.getFixture().addSRelation(sDomRel);
		}	
		assertTrue(pointingRels.containsAll(this.getFixture().getSPointingRelations()));
		assertTrue(this.getFixture().getSPointingRelations().containsAll(pointingRels));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#addSNode(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME) <em>Add SNode</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#addSNode(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME)
	 */
	public void testAddSNode__SNode_SNode_STYPE_NAME() {

		// test for SPOINTING_RELATION
		{
			SToken source = SaltCommonFactory.eINSTANCE.createSToken();
			SToken target = SaltCommonFactory.eINSTANCE.createSToken();
			//calling addSNode now should throw an SaltElementNotContainedInGraphException
			try { this.getFixture().addSNode(source, target, STYPE_NAME.SPOINTING_RELATION); fail(); } 
			catch (SaltElementNotContainedInGraphException e) {}
			this.getFixture().addSNode(source);
			SRelation sRelation = this.getFixture().addSNode(source, target, STYPE_NAME.SPOINTING_RELATION);
			assertTrue(sRelation instanceof SPointingRelation);
		}

		// test for STEXTUAL_RELATION
		{
			SToken     source = SaltCommonFactory.eINSTANCE.createSToken();
			STextualDS target = SaltCommonFactory.eINSTANCE.createSTextualDS();
			//calling addSNode now should throw an SaltElementNotContainedInGraphException
			try { this.getFixture().addSNode(source, target, STYPE_NAME.STEXTUAL_RELATION); fail(); } 
			catch (SaltElementNotContainedInGraphException e) {}
			this.getFixture().addSNode(source);
			SRelation sRelation = this.getFixture().addSNode(source, target, STYPE_NAME.STEXTUAL_RELATION);
			assertTrue(sRelation instanceof STextualRelation);
		}

		// test for SDOMINANCE_RELATION
		{
			SStructure source = SaltCommonFactory.eINSTANCE.createSStructure();
			SToken     target = SaltCommonFactory.eINSTANCE.createSToken();
			//calling addSNode now should throw an SaltElementNotContainedInGraphException
			try { this.getFixture().addSNode(source, target, STYPE_NAME.SDOMINANCE_RELATION); fail(); } 
			catch (SaltElementNotContainedInGraphException e) {}
			this.getFixture().addSNode(source);
			SRelation sRelation = this.getFixture().addSNode(source, target, STYPE_NAME.SDOMINANCE_RELATION);
			assertTrue(sRelation instanceof SDominanceRelation);
		}

		// test for SSPANNING_RELATION
		{
			SSpan  source = SaltCommonFactory.eINSTANCE.createSSpan();
			SToken target = SaltCommonFactory.eINSTANCE.createSToken();
			//calling addSNode now should throw an SaltElementNotContainedInGraphException
			try { this.getFixture().addSNode(source, target, STYPE_NAME.SSPANNING_RELATION); fail(); } 
			catch (SaltElementNotContainedInGraphException e) {}
			this.getFixture().addSNode(source);
			SRelation sRelation = this.getFixture().addSNode(source, target, STYPE_NAME.SSPANNING_RELATION);
			assertTrue(sRelation instanceof SSpanningRelation);
		}

	}

} //SDocumentGraphTest