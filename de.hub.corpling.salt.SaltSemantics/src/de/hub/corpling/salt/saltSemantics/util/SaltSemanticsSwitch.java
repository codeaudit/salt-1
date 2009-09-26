/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltSemantics.util;

import de.hub.corpling.graph.Label;
import de.hub.corpling.graph.LabelableElement;

import de.hub.corpling.salt.saltCore.SAnnotation;

import de.hub.corpling.salt.saltSemantics.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.hub.corpling.salt.saltSemantics.SaltSemanticsPackage
 * @generated
 */
public class SaltSemanticsSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SaltSemanticsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltSemanticsSwitch() {
		if (modelPackage == null) {
			modelPackage = SaltSemanticsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SaltSemanticsPackage.SPOS_ANNOTATION: {
				SPOSAnnotation sposAnnotation = (SPOSAnnotation)theEObject;
				T result = caseSPOSAnnotation(sposAnnotation);
				if (result == null) result = caseSAnnotation(sposAnnotation);
				if (result == null) result = caseLabel(sposAnnotation);
				if (result == null) result = caseLabelableElement(sposAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltSemanticsPackage.SLEMMA_ANNOTATION: {
				SLemmaAnnotation sLemmaAnnotation = (SLemmaAnnotation)theEObject;
				T result = caseSLemmaAnnotation(sLemmaAnnotation);
				if (result == null) result = caseSAnnotation(sLemmaAnnotation);
				if (result == null) result = caseLabel(sLemmaAnnotation);
				if (result == null) result = caseLabelableElement(sLemmaAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltSemanticsPackage.SCAT_ANNOTATION: {
				SCatAnnotation sCatAnnotation = (SCatAnnotation)theEObject;
				T result = caseSCatAnnotation(sCatAnnotation);
				if (result == null) result = caseSAnnotation(sCatAnnotation);
				if (result == null) result = caseLabel(sCatAnnotation);
				if (result == null) result = caseLabelableElement(sCatAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltSemanticsPackage.STYPE_ANNOTATION: {
				STypeAnnotation sTypeAnnotation = (STypeAnnotation)theEObject;
				T result = caseSTypeAnnotation(sTypeAnnotation);
				if (result == null) result = caseSAnnotation(sTypeAnnotation);
				if (result == null) result = caseLabel(sTypeAnnotation);
				if (result == null) result = caseLabelableElement(sTypeAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltSemanticsPackage.SWORD_ANNOTATION: {
				SWordAnnotation sWordAnnotation = (SWordAnnotation)theEObject;
				T result = caseSWordAnnotation(sWordAnnotation);
				if (result == null) result = caseSAnnotation(sWordAnnotation);
				if (result == null) result = caseLabel(sWordAnnotation);
				if (result == null) result = caseLabelableElement(sWordAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltSemanticsPackage.SSENTENCE_ANNOTATION: {
				SSentenceAnnotation sSentenceAnnotation = (SSentenceAnnotation)theEObject;
				T result = caseSSentenceAnnotation(sSentenceAnnotation);
				if (result == null) result = caseSAnnotation(sSentenceAnnotation);
				if (result == null) result = caseLabel(sSentenceAnnotation);
				if (result == null) result = caseLabelableElement(sSentenceAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SPOS Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SPOS Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSPOSAnnotation(SPOSAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SLemma Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SLemma Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSLemmaAnnotation(SLemmaAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCat Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCat Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSCatAnnotation(SCatAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SType Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SType Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSTypeAnnotation(STypeAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SWord Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SWord Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSWordAnnotation(SWordAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SSentence Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SSentence Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSSentenceAnnotation(SSentenceAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Labelable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Labelable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabelableElement(LabelableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabel(Label object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SAnnotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SAnnotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSAnnotation(SAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //SaltSemanticsSwitch