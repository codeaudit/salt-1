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
package org.corpus_tools.salt.common.impl;

import java.util.List;

import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.common.tokenizer.Tokenizer;
import org.corpus_tools.salt.core.impl.SLayerImpl;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Node;

@SuppressWarnings("serial")
public class STextualDSImpl extends SSequentialDSImpl<String, Integer> implements STextualDS {
	/** Initializes an object of type {@link SLayerImpl}. **/
	public STextualDSImpl() {
	}

	/**
	 * Initializes an object of type {@link SLayerImpl}. If {@link #delegate} is
	 * not null, all functions of this method are delegated to the delegate
	 * object. Setting {@link #delegate} makes this object to a container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public STextualDSImpl(Node delegate) {
		super(delegate);
	}

	/** {@inheritDoc} **/
	@Override
	public String getText() {
		String retVal = null;
		if (super.getData() instanceof String) {
			retVal = (String) super.getData();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public void setText(String newSText) {
		super.setData(newSText);
	}

	/** {@inheritDoc} **/
	@Override
	public SDocumentGraph getGraph() {
		return ((SDocumentGraph) super.getGraph());
	}

	/** {@inheritDoc} **/
	@Override
	public void setGraph(@SuppressWarnings("rawtypes") Graph graph) {
		if (!(graph instanceof SDocumentGraph)) {
			throw new SaltParameterException("graph", "setGrah", getClass(),
					"The parameter was not of type SDocumentGraph. ");
		}
		super.setGraph(graph);
	}

	/**
	 * {@inheritDoc SSequentialDS#getSStart()}. If a text was set returns 0,
	 * null otherwise
	 */
	@Override
	public Integer getStart() {
		if (getText() != null) {
			return (0);
		} else {
			return (null);
		}
	}

	/**
	 * {@inheritDoc SSequentialDS#getSEnd()}. If a text was set returns it's
	 * length, null otherwise
	 * 
	 */
	public Integer getEnd() {
		String sText = getText();
		if (sText != null) {
			return (sText.length());
		} else {
			return (null);
		}
	}

	/**
	 * Bug fix 69. Implements fast access to tokenization of a
	 * {@link STextualDS}. Simply duplicates the functionality of
	 * {@link SDocumentGraphImpl#tokenize()}, but only with respect to this
	 * object.
	 */
	@Override
	public List<SToken> tokenize() {
		Tokenizer tokenizer = new Tokenizer();
		tokenizer.setsDocumentGraph(getGraph());
		return tokenizer.tokenize(this);
	}
} // STextualDSImpl
