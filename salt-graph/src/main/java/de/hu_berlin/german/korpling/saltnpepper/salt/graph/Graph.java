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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph;

import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getIndexMgr <em>Index Mgr</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNodes <em>Nodes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getEdges <em>Edges</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNumOfNodes <em>Num Of Nodes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNumOfEdges <em>Num Of Edges</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getLayers <em>Layers</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNumOfLayers <em>Num Of Layers</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getGraph()
 * @model
 * @generated
 */
public interface Graph extends IdentifiableElement {
	/**
	 * Returns the value of the '<em><b>Index Mgr</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Mgr</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Mgr</em>' reference.
	 * @see #setIndexMgr(IndexMgr)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getGraph_IndexMgr()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#getGraph
	 * @model opposite="graph" transient="true" volatile="true"
	 * @generated
	 */
	IndexMgr getIndexMgr();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getIndexMgr <em>Index Mgr</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Mgr</em>' reference.
	 * @see #getIndexMgr()
	 * @generated
	 */
	void setIndexMgr(IndexMgr value);

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getGraph_Edges()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge#getGraph
	 * @model opposite="graph" containment="true"
	 * @generated
	 */
	EList<Edge> getEdges();

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getGraph_Nodes()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node#getGraph
	 * @model opposite="graph" containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Num Of Nodes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Of Nodes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Of Nodes</em>' attribute.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getGraph_NumOfNodes()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Long getNumOfNodes();

	/**
	 * Returns the value of the '<em><b>Num Of Edges</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Of Edges</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Of Edges</em>' attribute.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getGraph_NumOfEdges()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Long getNumOfEdges();

	/**
	 * Returns the value of the '<em><b>Layers</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layers</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getGraph_Layers()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getGraph
	 * @model opposite="graph" containment="true"
	 * @generated
	 */
	EList<Layer> getLayers();

	/**
	 * Returns the value of the '<em><b>Num Of Layers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Of Layers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Of Layers</em>' attribute.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getGraph_NumOfLayers()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Long getNumOfLayers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addNode(Node node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Node getNode(String nodeId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Boolean removeNodeById(String nodeId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Boolean removeNode(Node node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addEdge(Edge edge);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Edge getEdge(String edgeId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Edge> getEdges(String nodeId1, String nodeId2);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Edge> getInEdges(String nodeId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Edge> getOutEdges(String nodeId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Boolean removeEdgeById(String edgeId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Boolean removeEdges();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Boolean removeNodes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Boolean removeEdge(Edge edge);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void changeEdgeSource(String edgeId, String nodeId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void changeEdgeTarget(String edgeId, String nodeId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addNode(Node node, Layer layer);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addEdge(Edge edge, Layer layer);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addLayer(Layer layer);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Layer getLayer(String layerId);

} // Graph