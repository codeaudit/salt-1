/**
 * Copyright 2009 Humboldt-Universität zu Berlin.
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
package org.corpus_tools.salt.common;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.core.SFeature;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.util.SaltUtil;
import org.eclipse.emf.common.util.URI;

/**
 * In Salt a document is represented by this class. An object of this class can
 * contain an object of type {@link SDocumentGraph} which contains the 'real'
 * linguistic data. An object of type {@link SDocumentGraph} can be set and get
 * by calling {@link SDocument#setDocumentGraph(SDocumentGraph)} and
 * {@link SDocument#getDocumentGraph()}. A closer documentation of a document
 * graph, you can find in {@link SDocumentGraph}. A document must always be
 * contained in a corpus (object of type {@link SCorpus}). Such a containment
 * relation in Salt is represented by an object of type {@link SCorpusRelation}.
 * How to add a {@link SDocument} object to a {@link SCorpusGraph} object please
 * see the documentation of {@link SCorpusGraph}.
 * <p>
 * A document passes it's id to a document graph, when one is set.
 * </p>
 */
public interface SDocument extends SNode {
	/**
	 * Returns the document structure which belongs to this document.
	 * 
	 * @return document structure
	 */
	public SDocumentGraph getDocumentGraph();

	/**
	 * Returns the document structure which belongs to this document. If no
	 * document structure was created so far, a new one is created and returned
	 * .
	 * 
	 * @return document structure
	 */
	public SDocumentGraph createDocumentGraph();

	/**
	 * Sets the document structure which belongs to this document.
	 * 
	 * @param documentGraph
	 *            document structure which belongs to this document
	 */
	public void setDocumentGraph(SDocumentGraph documentGraph);

	/**
	 * Returns the location of the contained {@link SDocumentGraph} object, in
	 * case it is persisted. The location is stored via a {@link SFeature}
	 * object having the namespace {@value SaltFactory#NAMESPACE_SALT} and the
	 * name {@value SFEATURE_NAME#SDOCUMENT_GRAPH_LOCATION}.
	 * 
	 * @return location of persisted {@link SDocumentGraph} object as
	 *         {@link URI}
	 */
	public URI getDocumentGraphLocation();

	/**
	 * Sets the location as {@link URI}, of where the contained
	 * {@link SDocumentGraph} object is persisted. The location is stored as
	 * {@link SFeature} having the namespace {@value SaltFactory#NAMESPACE_SALT}
	 * and the name {@value SFEATURE_NAME#SDOCUMENT_GRAPH_LOCATION}.
	 * 
	 * @param newSDocumentGraphLocation
	 *            location as {@link URI}
	 */
	public void setDocumentGraphLocation(URI location);

	/**
	 * Persists the {@link SDocumentGraph} object contained by this object as
	 * SaltXML file at the location given by the passed {@link URI} object. The
	 * {@link URI} is stored as {@link SFeature} by calling
	 * {@link #setSDocumentGraphLocation(URI)}. The relation between
	 * {@link SDocument} and given {@link SDocumentGraph} will be removed.
	 * 
	 * @param documentGraphLocation
	 *            location of where to persist object as
	 *            {@value SaltUtil#FILE_ENDING_SALT_XML} file (must have the
	 *            ending {@value SaltUtil#FILE_ENDING_SALT}) in {@link URI}
	 *            syntax
	 * @generated
	 */
	public void saveDocumentGraph(URI documentGraphLocation);

	/**
	 * Loads a {@link SDocumentGraph} object and sets it to the contained
	 * {@link SDocumentGraph} object. The location of where to find the SaltXML
	 * containing the {@link SDocumentGraph} object must be given as
	 * {@link SFeature}. It will be read via calling
	 * {@link #getSDocumentGraphLocation()}. After loading, the feature
	 * accessible via {@link #getSDocumentGraphLocation()} will be removed.
	 */
	public void loadDocumentGraph();

	/**
	 * Loads a {@link SDocumentGraph} object and sets it to the contained
	 * {@link SDocumentGraph} object. The location of where to find the SaltXML
	 * containing the {@link SDocumentGraph} object is given by the passed
	 * {@link URI} object. After loading, the feature accessible via
	 * {@link #getSDocumentGraphLocation()} if exist will be removed.
	 * 
	 * @param documentGraphLocation
	 *            location of SaltXML to load {@link SDocumentGraph} object.
	 */
	void loadDocumentGraph(URI documentGraphLocation);

	/** {@inheritDoc} **/
	@Override
	public SCorpusGraph getGraph();

} // SDocument
