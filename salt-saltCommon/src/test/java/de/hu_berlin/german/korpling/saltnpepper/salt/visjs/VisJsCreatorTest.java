package de.hu_berlin.german.korpling.saltnpepper.salt.visjs;

//import  org.junit.Assert.*;
//import junit.framework.Assert;
import junit.framework.TestCase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.stream.XMLStreamException;

import org.eclipse.emf.common.util.URI;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;


import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltEmptyParameterException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceNotFoundException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.visjs.VisJsCreator;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;

public class VisJsCreatorTest {
	private final static String FSEP = System.getProperty("file.separator");
	private final static String inputFilePath = ".." + FSEP	+ "salt-saltCommon" + FSEP + "src"	+ FSEP + "test"	+ FSEP 
			+ "resources" + FSEP + "VisJsTest" + FSEP + "pcc2_salt_random_sentence" + FSEP 	+ "pcc2" + FSEP  + "match_0.salt";
	private final static String outputFolderPath =  ".." + FSEP + "visJsOutput";	    
	
	
	
	//@Rule
	//public ExpectedException exception = ExpectedException.none();
	
	
/*	 @Override public void setUp() throws Exception
	  {
		 inputFilePath = ".." + FSEP	+ "salt-saltCommon" + FSEP + "src"	+ FSEP + "test"	+ FSEP 
				+ "resources" + FSEP + "VisJsTest" + FSEP + "pcc2_salt_random_sentence" + FSEP 	+ "pcc2" + FSEP  + "match_0.salt";
		
		outputFolderPath = ".." + FSEP + "visJsOutput";	 
		
	  }*/

	@Test
	public void testHtmlWriter() {
		/*inputFilePath = ".." + FSEP	+ "salt-saltCommon" + FSEP + "src"	+ FSEP + "test"	+ FSEP 
				+ "resources" + FSEP + "VisJsTest" + FSEP + "pcc2_salt_random_sentence" + FSEP 	+ "pcc2" + FSEP  + "match_0.salt";
		
		outputFolderPath = ".." + FSEP + "visJsOutput";	    */
		
		URI uri = URI.createFileURI(inputFilePath);	
		VisJsCreator visJsCreator = new VisJsCreator(uri);
		
		try {
			 URI outputFileUri = URI.createFileURI(outputFolderPath);	
			 visJsCreator.writeHTML(outputFileUri);
		} catch (IOException | XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testJson(){
		URI uri = URI.createFileURI(inputFilePath);	
		VisJsCreator visJsCreator = new VisJsCreator(uri);
		
		visJsCreator.setNodeWriter(System.out);
		visJsCreator.setEdgeWriter(System.out);
		visJsCreator.setOptionsWriter(System.out);
		visJsCreator.buildJSON();
		try {
			visJsCreator.buildOptions();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedWriter ow;
				
		try {
			ow = visJsCreator.getJsonNodes();
			ow.newLine();
			ow.flush();	
			
			ow = visJsCreator.getJsonEdges();		
			ow.newLine();
			ow.flush();	
	
			ow = visJsCreator.getOptions();
			ow.flush();
			ow.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Test(expected = SaltEmptyParameterException.class)
	public void testInputUrlIsNull(){
		URI uri = null;
		VisJsCreator visJsCreator = new VisJsCreator(uri);
	}
	
	@Test(expected = SaltResourceException.class)
	public void testInvalideSaltFormat(){
		String inputFilePath = ".." + FSEP + "pcc2_salt_test" + FSEP + "pcc2_random_sentence_invalide_format" + FSEP + "pcc2" + FSEP + "match_0.salt";
		URI uri = URI.createFileURI(inputFilePath);	
		VisJsCreator visJsCreator = new VisJsCreator(uri);
	}
	
	@Test(expected = SaltResourceNotFoundException.class)
	public void testAbsentSaltResource(){
		String inputFilePath = ".." + FSEP + "pcc2_salt_test" + FSEP + "pcc2_random_sentence_absent_resource" + FSEP + "pcc2" + FSEP + "match_0.salt";
		URI uri = URI.createFileURI(inputFilePath);	
		VisJsCreator visJsCreator = new VisJsCreator(uri);
	}
	

	@Test(expected = SaltEmptyParameterException.class)
	public void testNodeWriterIsNull(){
		URI uri = URI.createFileURI(inputFilePath);	
		VisJsCreator visJsCreator = new VisJsCreator(uri);		
		visJsCreator.setEdgeWriter(System.out);
		visJsCreator.buildJSON();
	}
	
	@Test(expected = SaltEmptyParameterException.class)
	public void testEdgeWriterIsNull(){
		URI uri = URI.createFileURI(inputFilePath);	
		VisJsCreator visJsCreator = new VisJsCreator(uri);		
		visJsCreator.setNodeWriter(System.out);
		visJsCreator.buildJSON();
	}
	
	
	
	

}
