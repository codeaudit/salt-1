package de.hu_berlin.german.korpling.saltnpepper.salt.samples.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;
import de.hu_berlin.german.korpling.saltnpepper.salt.samples.SampleGenerator;

public class SampleGeneratorTest {
	
	@Test
	public void testCreateCorpusStructure_saltProject(){
		SaltProject fixture = SaltFactory.eINSTANCE.createSaltProject();
		
		try{
			SampleGenerator.createCorpusStructure(fixture);
		}
		catch (Exception e){
			fail(e.getMessage()+"\n"+e.getCause());
		}
	}
	
	@Test
	public void testCreateCorpusStructure_SCorpusGraph(){
		SCorpusGraph fixture = SaltFactory.eINSTANCE.createSCorpusGraph();
		
		try{
			SampleGenerator.createCorpusStructure(fixture);
		}
		catch (Exception e){
			fail(e.getMessage()+"\n"+e.getCause());
		}		
	}
	
	@Test
	public void testCreateCorpusStructure(){
		try{
			SampleGenerator.createCorpusStructure();
		}
		catch (Exception e){
			fail(e.getMessage()+"\n"+e.getCause());
		}		
	}
	
	@Test
	public void testCreateSaltProject(){
		try{
			SampleGenerator.createSaltProject();
		}
		catch (Exception e){
			fail(e.getMessage()+"\n"+e.getCause());
		}		
	}
	
	@Test
	public void testCreateCorpusStructure_simple(){		
		try{
			SampleGenerator.createCorpusStructure_simple();
		}
		catch (Exception e){
			fail(e.getMessage()+"\n"+e.getCause());
		}		
	}
	
	@Test
	public void testCreateDialogue_SDocument(){
		SDocument fixture = SaltFactory.eINSTANCE.createSDocument();
		
		try{
			SampleGenerator.createDialogue(fixture);
		}
		catch (Exception e){
			fail(e.getMessage()+"\n"+e.getCause());
		}		
	}
	
	@Test
	public void testCreatePrimaryData_SDocument(){
		SDocument fixture = SaltFactory.eINSTANCE.createSDocument();
		
		try{
			SampleGenerator.createPrimaryData(fixture);
		}
		catch (Exception e){
			fail(e.getMessage()+"\n"+e.getCause());
		}		
	}
	
	@Test
	public void testCreatePrimaryData__SDocument_String(){
		SDocument fixtureEN = SaltFactory.eINSTANCE.createSDocument();
		SDocument fixtureDE = SaltFactory.eINSTANCE.createSDocument();
		
		try{
			SampleGenerator.createPrimaryData(fixtureEN, "en");
			SampleGenerator.createPrimaryData(fixtureDE, "de");
		}
		catch (Exception e){			
			fail(e.getMessage()+"\n"+e.getCause());		
		}		
	}
	
	@Test
	public void testCreateTokens_SDocument(){
		SDocument fixture = SaltFactory.eINSTANCE.createSDocument();
		
		try{
			SampleGenerator.createTokens(fixture);
		}
		catch (Exception e){
			fail(e.getMessage()+"\n"+e.getCause());
		}		
	}
	
	@Test
	public void testCreateTokens__SDocument_STextualDS(){
		//TODO
	}
	
	@Test
	public void testCreateToken__int_int_STextualDS_SDocument_SLayer(){
		SDocument fixture = SaltFactory.eINSTANCE.createSDocument();
		
		try{
			SampleGenerator.createToken(0, 4, SaltFactory.eINSTANCE.createSTextualDS(), fixture, null);
		}
		catch (Exception e){			
			fail(e.getMessage()+"\n"+e.getCause());
		}
	}
	
	@Test
	public void testCreateParallelData__SDocument_boolean(){
		SDocument fixture = SaltFactory.eINSTANCE.createSDocument();
		
		try{
			SampleGenerator.createParallelData(fixture, true);
		}
		catch (Exception e){
			fail(e.getMessage()+"\n"+e.getCause());
		}
	}
	
	@Test
	public void testCreateMorphologyAnnotations_SDocument(){
		SDocument fixture = SaltFactory.eINSTANCE.createSDocument();
		
		try{
			SampleGenerator.createMorphologyAnnotations(fixture);
		}
		catch (Exception e){			
			fail(e.getMessage()+"\n"+e.getCause());
		}		
	}
	
	@Test
	public void testCreateInformationStructureSpan_SDocument(){
		SDocument fixture = SaltFactory.eINSTANCE.createSDocument();
		
		try{
			SampleGenerator.createInformationStructureSpan(fixture);
		}
		catch (Exception e){
			fail(e.getMessage()+"\n"+e.getCause());
		}
	}
	
	@Test
	public void testCreateInformationStructureAnnotations_SDocument(){
		SDocument fixture = SaltFactory.eINSTANCE.createSDocument();
		
		try{
			SampleGenerator.createInformationStructureAnnotations(fixture);
		}
		catch (Exception e){			
			fail(e.getMessage()+"\n"+e.getCause());
		}
	}
	
	@Test
	public void testCreateSyntaxStructure_SDocument(){
		SDocument fixture = SaltFactory.eINSTANCE.createSDocument();
		
		try{
			SampleGenerator.createSyntaxStructure(fixture);
		}
		catch (Exception e){
			fail(e.getMessage()+"\n"+e.getCause());
		}
	}
	
	@Test
	public void testCreateSyntaxAnnotations_SDocument(){
		SDocument fixture = SaltFactory.eINSTANCE.createSDocument();
		
		try{
			SampleGenerator.createSyntaxAnnotations(fixture);
		}
		catch (Exception e){
			e.printStackTrace();
			fail(e.getMessage()+"\n"+e.getCause());
		}
		
	}
	
	@Test
	public void testCreateDependencies_SDocument(){
		SDocument fixture = SaltFactory.eINSTANCE.createSDocument();
		
		try{
			SampleGenerator.createDependencies(fixture);
		}
		catch (Exception e){
			fail(e.getMessage()+"\n"+e.getCause());
		}		
	}
	
	@Test
	public void testCreateAnaphoricAnnotations_SDocument(){
		SDocument fixture = SaltFactory.eINSTANCE.createSDocument();
		
		try{
			SampleGenerator.createAnaphoricAnnotations(fixture);
		}
		catch (Exception e){
			fail(e.getMessage()+"\n"+e.getCause());
		}		
	}
	
	@Test
	public void testCreateSDocumentStructure_SDocument(){
		SDocument fixture = SaltFactory.eINSTANCE.createSDocument();
		
		try{
			SampleGenerator.createSDocumentStructure(fixture);
		}
		catch (Exception e){
			fail(e.getMessage()+"\n"+e.getCause());
		}		
	}
}
