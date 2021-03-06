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
package org.corpus_tools.salt.util.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * A result object which is returned when a Salt model is checked for validity.
 * 
 * @author florian
 *
 */
public class ValidationResult {
	final private Collection<Invalidity> invalidities = new LinkedList<>();

	/**
	 * Returns all invalidities which have been found while checking the model.
	 * 
	 * @return
	 */
	public Collection<Invalidity> getInvalidities() {
		return Collections.unmodifiableCollection(invalidities);
	}

	protected void add(Invalidity invalidity) {
		if (invalidity != null) {
			invalidities.add(invalidity);
		}
	}

	/**
	 * Returns whether the checked model is valid or not.
	 * 
	 * @return
	 */
	public boolean isValid() {
		if (invalidities.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invalidities == null) ? 0 : invalidities.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValidationResult other = (ValidationResult) obj;
		if (invalidities == null) {
			if (other.invalidities != null)
				return false;
		} else if (!invalidities.equals(other.invalidities))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ValidationResult [invalidities=" + invalidities + "]";
	}
}
