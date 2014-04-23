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
package de.hu_berlin.german.korpling.saltnpepper.salt.samples;

import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;

import com.google.common.collect.ImmutableList;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SLemmaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SPOSAnnotation;

/**
 * Creates samples of {@link SDocumentGraph} and {@link SCorpusGraph} instances.
 * @author Florian Zipser
 *
 */
public class SampleGenerator 
{
	/**
	 * Creates a complete {@link SaltProject} object having the complex structure
	 * @return
	 */
	public static SaltProject createCompleteSaltproject() 
	{
		//Creating a new salt project, this is the main object and contains all the others. 
		SaltProject saltProject= SaltFactory.eINSTANCE.createSaltProject();
	
		{//creating a corpus structure for salt project
			createCorpusStructure(saltProject);
		}//creating a corpus structure for salt project
	
		{//filling all of the documents in the corpus structure with document structure data
			//this works, because after createCorpusStructure() was called, only one graph exists in salt project
			SCorpusGraph sCorpusGraph= saltProject.getSCorpusGraphs().get(0);
			for (SDocument sDocument: sCorpusGraph.getSDocuments())
			{//filling all of the documents in the corpus structure with document structure data	
				createSDocumentStructure(sDocument);
			}//filling all of the documents in the corpus structure with document structure data
		}//filling all of the documents in the corpus structure with document structure data
		
		return(saltProject);
	}
	
	/**
	 * TODO: The original {@link SampleGenerator#createCompleteSaltproject()}
	 * method does not generate the intendet structure but can not be changed
	 * because of other modules depend on it
	 * 
	 * Creates a complete {@link SaltProject} object having the complex
	 * structure
	 * 
	 * @return
	 */
	public static SaltProject createCompleteSaltproject2() 
	{
		//Creating a new salt project, this is the main object and contains all the others. 
		SaltProject saltProject= SaltFactory.eINSTANCE.createSaltProject();
		saltProject.setSName("sampleSaltProject");
		//this works, because after createCorpusStructure() was called, only one graph exists in salt project
		SCorpusGraph sCorpGraph = SaltFactory.eINSTANCE.createSCorpusGraph();
//		SCorpusGraph sCorpusGraph= saltProject.getSCorpusGraphs().get(0);
		
		sCorpGraph= createCorpusStructure2(sCorpGraph);
		
		saltProject.getSCorpusGraphs().add(sCorpGraph);
		for (SDocument sDocument : sCorpGraph.getSDocuments()) {
			createSDocumentStructure(sDocument);
		}
		return(saltProject);
	}
	
	/**
	 * Tests following structure:
	 * 
	 * 	rootCorpus
	 * 		|
	 * 		doc1
	 * 	
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static SCorpusGraph createSimpleCorpusStructure(SaltProject saltProject) 
	{
		SCorpusGraph sCorpusGraph= createCorpusStructure();
		saltProject.getSCorpusGraphs().add(sCorpusGraph);
		return(sCorpusGraph);
	}
	

	/**
	 * Tests following structure:
	 * 
	 * 	rootCorpus
	 * 		|
	 * 		doc1
	 * 	
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static SCorpusGraph createCorpusStructure_simple() 
	{
		SCorpusGraph sCorpGraph= SaltFactory.eINSTANCE.createSCorpusGraph();
		sCorpGraph.setSId("corpusGraph1");
		SCorpus sCorpus1= SaltFactory.eINSTANCE.createSCorpus();
		sCorpus1.setSName("rootCorpus");
		sCorpGraph.addSNode(sCorpus1);
		
		SDocument sDoc= null;
		sDoc= SaltFactory.eINSTANCE.createSDocument();
		sDoc.setSName("doc1");
		sCorpGraph.addSDocument(sCorpus1, sDoc);
		
		return(sCorpGraph);
	}
	
	/**
	 * Tests following structure:
	 * <pre>
	 *            rootCorpus
	 *       /                    \
	 *   subCorp1               subCorp2
	 *  /       \              /        \
	 * doc1     doc2         doc3      doc4
	 * </pre>
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static SCorpusGraph createCorpusStructure(SaltProject saltProject) 
	{
		SCorpusGraph sCorpusGraph= createCorpusStructure();
		saltProject.getSCorpusGraphs().add(sCorpusGraph);
		return(sCorpusGraph);
	}
	
	/**
	 * Tests following structure:
	 * <pre>
	 *            rootCorpus
	 *       /                    \
	 *   subCorp1               subCorp2
	 *  /       \              /        \
	 * doc1     doc2         doc3      doc4
	 * </pre>
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static SCorpusGraph createCorpusStructure() 
	{
		SCorpusGraph sCorpGraph= SaltFactory.eINSTANCE.createSCorpusGraph();
		createCorpusStructure(sCorpGraph);
		return(sCorpGraph);
	}
	
	/**
	 * Tests following structure:
	 * <pre>
	 * 	             rootCorpus
	 * 		     /                 \
	 *       subCorp1		      subCorp2
	 * 	/	  /		\		\
	 * doc1	doc2	doc3	doc4
	 * </pre>
	 * @throws IOException 
	 * @throws SAXException 
	 */
	@Deprecated
	public static SCorpusGraph createCorpusStructure(SCorpusGraph sCorpGraph)
	{
		sCorpGraph.setSId("corpusGraph1");
		SCorpus sCorpus1= SaltFactory.eINSTANCE.createSCorpus();
		sCorpus1.setSName("rootCorpus");
		sCorpGraph.addSNode(sCorpus1);
		SCorpus sCorpus2= SaltFactory.eINSTANCE.createSCorpus();
		sCorpus2.setSName("subCorpus1");
		SCorpus sCorpus3= SaltFactory.eINSTANCE.createSCorpus();
		sCorpus3.setSName("subCorpus2");
		
		sCorpGraph.addSSubCorpus(sCorpus1, sCorpus2);
		sCorpGraph.addSSubCorpus(sCorpus1, sCorpus3);
		
		SDocument sDoc= null;
		
		sDoc= SaltFactory.eINSTANCE.createSDocument();
		sDoc.setSName("doc1");
		sCorpGraph.addSDocument(sCorpus2, sDoc);
		
		sDoc= SaltFactory.eINSTANCE.createSDocument();
		sDoc.setSName("doc2");
		sCorpGraph.addSDocument(sCorpus2, sDoc);
		
		sDoc= SaltFactory.eINSTANCE.createSDocument();
		sDoc.setSName("doc3");
		sCorpGraph.addSDocument(sCorpus2, sDoc);
		
		sDoc= SaltFactory.eINSTANCE.createSDocument();
		sDoc.setSName("doc4");
		sCorpGraph.addSDocument(sCorpus2, sDoc);
		
		return(sCorpGraph);
	}
	
	/**
	 * Tests following structure:
	 * 
	 * 				rootCorpus
	 * 		/					\
	 * 	subCorp1				subCorp2
	 * 	/		\				/		\
	 * doc1		doc2		doc3		doc4
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static SCorpusGraph createCorpusStructure2(SCorpusGraph sCorpGraph1)
	{
		sCorpGraph1.setSId("corpusGraph1");
		SCorpus sCorpusRoot= SaltFactory.eINSTANCE.createSCorpus();
		sCorpusRoot.setSName("rootCorpus");
		sCorpGraph1.addSNode(sCorpusRoot);
		SCorpus sCorpusSub1= SaltFactory.eINSTANCE.createSCorpus();
		sCorpusSub1.setSName("subCorpus1");
		SCorpus sCorpusSub2= SaltFactory.eINSTANCE.createSCorpus();
		sCorpusSub2.setSName("subCorpus2");
		
		sCorpGraph1.addSSubCorpus(sCorpusRoot, sCorpusSub1);
		sCorpGraph1.addSSubCorpus(sCorpusRoot, sCorpusSub2);
		
		SDocument sDoc= null;
		
		sDoc= SaltFactory.eINSTANCE.createSDocument();
		sDoc.setSName("doc1");
		sCorpGraph1.addSDocument(sCorpusSub1, sDoc);
		
		sDoc= SaltFactory.eINSTANCE.createSDocument();
		sDoc.setSName("doc2");
		sCorpGraph1.addSDocument(sCorpusSub1, sDoc);
		
		sDoc= SaltFactory.eINSTANCE.createSDocument();
		sDoc.setSName("doc3");
		sCorpGraph1.addSDocument(sCorpusSub2, sDoc);
		
		sDoc= SaltFactory.eINSTANCE.createSDocument();
		sDoc.setSName("doc4");
		sCorpGraph1.addSDocument(sCorpusSub2, sDoc);
		
		return(sCorpGraph1);
	}
	
	/**
	 * This method creates the content of a document (the primary text, the tokenization and all structures and annotations above them) for 
	 * the given SDocument object.
	 * 
	 * primary text: 		Is this example more complicated than it appears to be?
	 * tokens:				{"Is", "this", "example", "more", "complicated", "than", "it", "appears", "to", "be"}
	 * anaphoric relation:	{"it"} --> {"this", "example"}
	 * 
	 * @param sDocument the document for which the structure has to be created.
	 */
	public static void createSDocumentStructure(SDocument sDocument)
	{
		{//creating the document structure
			if (sDocument.getSDocumentGraph()== null)
				sDocument.setSDocumentGraph(SaltFactory.eINSTANCE.createSDocumentGraph());
			
			//an object for the primary text
			STextualDS sTextualDS= null;
			
			{//creating the primary text
				sTextualDS= SaltFactory.eINSTANCE.createSTextualDS();
				sTextualDS.setSText("Is this example more complicated than it appears to be?");
//				sTextualDS.setSText("This is a sample text, which is very short.");
				//adding the text to the document-graph
				sDocument.getSDocumentGraph().addSNode(sTextualDS);
			}//creating the primary text
			
			{//creating tokenization (token objects and relations between tokens and the primary data object)
				//placeholder object representing a token
				SToken sToken= null;
				//object to connect a token to a primary text
				STextualRelation sTextRel= null;
				
				//adding the created token to the document-graph
				sToken= SaltFactory.eINSTANCE.createSToken();
				sDocument.getSDocumentGraph().addSNode(sToken);
				
				sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
				//adding the token as source of this relation
				sTextRel.setSToken(sToken);
				//adding the primary text as target of this relation
				sTextRel.setSTextualDS(sTextualDS);
				//adding the start-position of the token in the primary text 
				sTextRel.setSStart(0);
				//adding the end-position of the token in the primary text (start-position of the token + length of the token) 
				sTextRel.setSEnd(2);
				//adding the textual relation between token and primary text to document graph
				sDocument.getSDocumentGraph().addSRelation(sTextRel);
				
				{//creating the rest of the tokenization, this can also be done automatically
					//creating tokenization for the token 'this'
					sToken= SaltFactory.eINSTANCE.createSToken();
					sDocument.getSDocumentGraph().addSNode(sToken);
					sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
					sTextRel.setSToken(sToken);
					sTextRel.setSTextualDS(sTextualDS);
					sTextRel.setSStart(3);
					sTextRel.setSEnd(7);	
					sDocument.getSDocumentGraph().addSRelation(sTextRel);
					
					//creating tokenization for the token 'example'
					sToken= SaltFactory.eINSTANCE.createSToken();
					sDocument.getSDocumentGraph().addSNode(sToken);
					sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
					sTextRel.setSToken(sToken);
					sTextRel.setSTextualDS(sTextualDS);
					sTextRel.setSStart(8);
					sTextRel.setSEnd(15);
					sDocument.getSDocumentGraph().addSRelation(sTextRel);
					
					//creating tokenization for the token 'more'
					sToken= SaltFactory.eINSTANCE.createSToken();
					sDocument.getSDocumentGraph().addSNode(sToken);
					sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
					sTextRel.setSToken(sToken);
					sTextRel.setSTextualDS(sTextualDS);
					sTextRel.setSStart(16);
					sTextRel.setSEnd(20);
					sDocument.getSDocumentGraph().addSRelation(sTextRel);
					
					//creating tokenization for the token 'complicated'
					sToken= SaltFactory.eINSTANCE.createSToken();
					sDocument.getSDocumentGraph().addSNode(sToken);
					sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
					sTextRel.setSToken(sToken);
					sTextRel.setSTextualDS(sTextualDS);
					sTextRel.setSStart(21);
					sTextRel.setSEnd(32);
					sDocument.getSDocumentGraph().addSRelation(sTextRel);
					
					//creating tokenization for the token 'than'
					sToken= SaltFactory.eINSTANCE.createSToken();
					sDocument.getSDocumentGraph().addSNode(sToken);
					sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
					sTextRel.setSToken(sToken);
					sTextRel.setSTextualDS(sTextualDS);
					sTextRel.setSStart(33);
					sTextRel.setSEnd(37);
					sDocument.getSDocumentGraph().addSRelation(sTextRel);
					
					//creating tokenization for the token 'it'
					sToken= SaltFactory.eINSTANCE.createSToken();
					sDocument.getSDocumentGraph().addSNode(sToken);
					sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
					sTextRel.setSToken(sToken);
					sTextRel.setSTextualDS(sTextualDS);
					sTextRel.setSStart(38);
					sTextRel.setSEnd(40);
					sDocument.getSDocumentGraph().addSRelation(sTextRel);
					
					//creating tokenization for the token 'appears'
					sToken= SaltFactory.eINSTANCE.createSToken();
					sDocument.getSDocumentGraph().addSNode(sToken);
					sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
					sTextRel.setSToken(sToken);
					sTextRel.setSTextualDS(sTextualDS);
					sTextRel.setSStart(41);
					sTextRel.setSEnd(48);
					sDocument.getSDocumentGraph().addSRelation(sTextRel);
					
					//creating tokenization for the token 'to'
					sToken= SaltFactory.eINSTANCE.createSToken();
					sDocument.getSDocumentGraph().addSNode(sToken);
					sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
					sTextRel.setSToken(sToken);
					sTextRel.setSTextualDS(sTextualDS);
					sTextRel.setSStart(49);
					sTextRel.setSEnd(51);
					sDocument.getSDocumentGraph().addSRelation(sTextRel);
					
					//creating tokenization for the token 'be'
					sToken= SaltFactory.eINSTANCE.createSToken();
					sDocument.getSDocumentGraph().addSNode(sToken);
					sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
					sTextRel.setSToken(sToken);
					sTextRel.setSTextualDS(sTextualDS);
					sTextRel.setSStart(52);
					sTextRel.setSEnd(54);
					sDocument.getSDocumentGraph().addSRelation(sTextRel);
				}//creating the rest of the tokenization, this can also be done automatically
			}//creating tokenization (token objects and relations between tokens and the primary data object)
			
			// a synchronized list of all tokens to walk through
			List<SToken> sTokens= ImmutableList.copyOf(sDocument.getSDocumentGraph().getSTokens());
			
			{//adding some annotations, part-of-speech and lemma (for part-of speech and lemma annotations a special annotation in Salt exists)
				{//adding part-of speech annotations
					SPOSAnnotation sPOSAnno= null;
					
					
					//a list of all part-of-speech annotations for the words Is (VBZ), this (DT) ... be (VB)
					String[] posAnnotations={"VBZ", "DT", "NN", "ABR", "JJ", "IN", "PRP", "VBZ", "TO", "VB"}; 
					for (int i= 0; i< sTokens.size();i++)
					{
						sPOSAnno= SaltFactory.eINSTANCE.createSPOSAnnotation();
						sPOSAnno.setSValue(posAnnotations[i]);
						sTokens.get(i).addSAnnotation(sPOSAnno);
					}
				}//adding part-of speech annotations
				
				{//adding lemma annotations
					SLemmaAnnotation sLemmaAnno= null;
					
					
					//a list of all lemma annotations for the words Is (be), this (this) ... be (be)
					String[] posAnnotations={"be", "this", "example", "more", "complicated", "than", "it", "appears", "to", "be"}; 
					for (int i= 0; i< sTokens.size();i++)
					{
						sLemmaAnno= SaltFactory.eINSTANCE.createSLemmaAnnotation();
						sLemmaAnno.setSValue(posAnnotations[i]);
						sTokens.get(i).addSAnnotation(sLemmaAnno);
					}
				}//adding lemma annotations
				
				{//creating annotations for information structure with the use of spans: "Is"= contrast-focus,"this example more complicated than it appears to be"= Topic 
					SSpan sSpan= null;
					SSpanningRelation sSpanRel= null;
					SAnnotation sAnno= null;
					
					//creating a span node as placeholder for information-structure annotation
					sSpan= SaltFactory.eINSTANCE.createSSpan();
					//adding the created span to the document-graph
					sDocument.getSDocumentGraph().addSNode(sSpan);
					//creating an annottaion for information-structure
					sAnno= SaltFactory.eINSTANCE.createSAnnotation();
					//setting the name of the annotation
					sAnno.setSName("Inf-Struct");
					//setting the value of the annotation
					sAnno.setSValue("contrast-focus");
					//adding the annotation to the placeholder span
					sSpan.addSAnnotation(sAnno);
					
					//creating a relation to connect a token with the span
					sSpanRel= SaltFactory.eINSTANCE.createSSpanningRelation();
					//setting the span as source of the relation
					sSpanRel.setSSpan(sSpan);
					//setting the first token as target of the relation
					sSpanRel.setSToken(sTokens.get(0));
					//adding the created relation to the document-graph
					sDocument.getSDocumentGraph().addSRelation(sSpanRel);
					
					{//creating the second span
						sSpan= SaltFactory.eINSTANCE.createSSpan();
						sDocument.getSDocumentGraph().addSNode(sSpan);
						sAnno= SaltFactory.eINSTANCE.createSAnnotation();
						sAnno.setSName("Inf-Struct");
						sAnno.setSValue("topic");
						sSpan.addSAnnotation(sAnno);
						for (int i= 1; i< sTokens.size(); i++)
						{
							sSpanRel= SaltFactory.eINSTANCE.createSSpanningRelation();
							sSpanRel.setSSpan(sSpan);
							sSpanRel.setSToken(sTokens.get(i));
							sDocument.getSDocumentGraph().addSRelation(sSpanRel);
						}
					}//creating the second span
					
				}//creating annotations for information structure with the use of spans
				
			}//adding some annotations, part-of-speech and lemma (for part-of speech and lemma annotations a special annotation in Salt exists)
			
			{//creating an anaphoric relation with the use of pointing relations between the Tokens {"it"} and {"this", "example"}
				//creating a span as placeholder, which contains the tokens for "this" and "example"
				SSpan sSpan= SaltFactory.eINSTANCE.createSSpan();
				//adding the created span to the document-graph
				sDocument.getSDocumentGraph().addSNode(sSpan);
				
				//creating a relation between the span and the tokens
				SSpanningRelation sSpanRel= null;
				sSpanRel= SaltFactory.eINSTANCE.createSSpanningRelation();
				sSpanRel.setSSpan(sSpan);
				sSpanRel.setSToken(sTokens.get(1));
				sDocument.getSDocumentGraph().addSRelation(sSpanRel);
				sSpanRel= SaltFactory.eINSTANCE.createSSpanningRelation();
				sSpanRel.setSSpan(sSpan);
				sSpanRel.setSToken(sTokens.get(2));
				sDocument.getSDocumentGraph().addSRelation(sSpanRel);
				
				//creating a pointing relations
				SPointingRelation sPointingRelation= SaltFactory.eINSTANCE.createSPointingRelation();
				//setting token "it" as source of this relation
				sPointingRelation.setSStructuredSource(sTokens.get(6));
				//setting span "this example" as target of this relation
				sPointingRelation.setSStructuredTarget(sSpan);
				//adding the created relation to the document-graph
				sDocument.getSDocumentGraph().addSRelation(sPointingRelation);
				//creating an annotation
				SAnnotation sAnno= SaltFactory.eINSTANCE.createSAnnotation();
				sAnno.setSName("anaphoric");
				sAnno.setSValue("antecedent");
				//adding the annotation to the relation
				sPointingRelation.addSAnnotation(sAnno);
			}//creating an anaphoric relation with the use of pointing relations between the Tokens {"it"} and {"this", "example"}
			//TODO more to do
		}//creating the document structure
	}
	/**
	 * creates a document with layers
	 * <pre>
	 * 
	 * </pre>
	 */
	public static SDocument createSDocumentSLayered(SDocument sDocument) {
		if (sDocument.getSDocumentGraph() == null){
			createSDocumentStructure(sDocument);
		}
		SLayer sLayer1 = SaltFactory.eINSTANCE.createSLayer();
		SLayer sLayer2 = SaltFactory.eINSTANCE.createSLayer();
		sLayer1.setSName("sLayer1 mit SRelations");
		sLayer2.setSName("sLayer2 mit STokens");
		sLayer1.setId("sLayer1 mit Annotations:id");
		sLayer2.setId("sLayer2 mit STokens:id");
		for (SRelation sAnno : sDocument.getSDocumentGraph().getSRelations()) {
			sLayer1.getSRelations().add(sAnno);
		}
		for (SToken sToken : sDocument.getSDocumentGraph().getSTokens()) {
			sLayer2.getSNodes().add(sToken);
		}
		sLayer2.setSSuperLayer(sLayer1);
		
		sDocument.getSDocumentGraph().addSLayer(sLayer1);
		sDocument.getSDocumentGraph().addSLayer(sLayer2);

		return sDocument;
	}
	
	/**
	 * Creates a document with 2 layers, 5 Tokens with no Layer
	 * 
	 * @param sDocument
	 * @return
	 */
	public static SDocument createSDocument_simpleLayeredDocument(SDocument sDocument) {
		sDocument.setSDocumentGraph(SaltFactory.eINSTANCE.createSDocumentGraph());
		SLayer sLayer1 = SaltFactory.eINSTANCE.createSLayer();
		SLayer sLayer2 = SaltFactory.eINSTANCE.createSLayer();
		sLayer1.setSName("sLayer1");
		sLayer2.setSName("sLayer2");
		sLayer1.setId("sLayer1:id");
		sLayer2.setId("sLayer2:id");

		for (int i = 0; i < 5; i++) {
			SToken sToken= SaltFactory.eINSTANCE.createSToken();
			sDocument.getSDocumentGraph().addSNode(sToken);
		}
		
		for (int i = 0; i < 5; i++) {
			SToken sToken= SaltFactory.eINSTANCE.createSToken();
			sDocument.getSDocumentGraph().addSNode(sToken);
			sToken.getSLayers().add(sLayer1);
		}
		
		sDocument.getSDocumentGraph().addSLayer(sLayer1);
		sDocument.getSDocumentGraph().addSLayer(sLayer2);

		return sDocument;
	}
	
	public static void addMetaAnnotation(final SMetaAnnotatableElement annotatable, final String name, final String value) {
		SMetaAnnotation sMetaAnno = SaltFactory.eINSTANCE.createSMetaAnnotation();
		sMetaAnno.setName(name);
//		sMetaAnno.setValueString("Hans Wurst");
		sMetaAnno.setSValue(value);
		annotatable.addSMetaAnnotation(sMetaAnno);
	}
}
