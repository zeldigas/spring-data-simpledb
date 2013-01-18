/*
 * Copyright 2011-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.simpledb.repository.support.entityinformation;

import org.springframework.data.simpledb.annotation.AnnotationParser;
import org.springframework.data.simpledb.repository.support.entityinformation.SimpleDbEntityInformationSupport;

import javax.persistence.metamodel.SingularAttribute;
import java.io.Serializable;
import java.util.Map;

/**
 * Implementation of {@link org.springframework.data.repository.core.EntityInformation} that uses JPA {@link javax.persistence.metamodel.Metamodel}
 * to find the domain class' id field.
 *
 * @author Oliver Gierke
 */
public class SimpleDbMetamodelEntityInformation<T, ID extends Serializable> extends SimpleDbEntityInformationSupport<T, ID> {

	/**
	 * Creates a new {@link org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation} for the given domain class and {@link javax.persistence.metamodel.Metamodel}.
	 *
	 * @param domainClass must not be {@literal null}.
	 */
	public SimpleDbMetamodelEntityInformation(Class<T> domainClass) {

		super(domainClass);

	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.core.EntityInformation#getId(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public ID getId(T entity) {
        return (ID) AnnotationParser.getItemName(entity);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.data.repository.support.EntityInformation#getIdType()
	 */
	@SuppressWarnings("unchecked")
	public Class<ID> getIdType() {
		return (Class<ID>) String.class;
	}


    @Override
    public String getDomain() {
        return AnnotationParser.getDomain(getJavaType());
    }

    @Override
    public String getItemName(T entity) {
        return AnnotationParser.getItemName(entity);
    }

    @Override
    public Map<String, String> getAttributes(T entity) {
        return AnnotationParser.getAttributes(entity);
    }
}