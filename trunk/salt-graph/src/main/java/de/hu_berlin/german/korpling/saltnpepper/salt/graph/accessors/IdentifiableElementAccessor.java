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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.accessors;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier;


public class IdentifiableElementAccessor 
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getId(IdentifiableElement identElem) 
	{
		if (identElem.getIdentifier()== null)
			return null;
		else
			return(identElem.getIdentifier().getId());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setId(IdentifiableElement identElem, String newId) 
	{
//		if (	(newId== null)||
//				(newId.equals("")))
//			throw new GraphException("Cannot not add an empty id to an element of type '"+identElem.getClass()+"'.");
		if (identElem.getIdentifier()== null)
		{
			Identifier identifier= GraphFactory.eINSTANCE.createIdentifier();
			identElem.setIdentifier(identifier);
		}
		identElem.getIdentifier().setId(newId);
	}
}
