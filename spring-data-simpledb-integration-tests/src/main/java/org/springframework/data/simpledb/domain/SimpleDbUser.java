package org.springframework.data.simpledb.domain;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.annotation.Transient;

/**
 * TODO: extend with other types to be tested as other type handlers are
 * implemented. One sample for each supported type. Each particular instance and
 * other tests should be included as Regular Junit Tests
 */
public class SimpleDbUser {

	@Id
	private String itemName;

	private float primitiveField;

	private String coreField;

	private NestedEntity nestedEntity;

	private Object objectField;

	private List<Integer> coreTypeList;

	private List<JSONCompatibleClass> objectList;

	private long[] primitiveArrayField;

	private Map<String, JSONCompatibleClass> mapOfStringAndObject;

	@SuppressWarnings("unused")
	@Persistent
	private String persistedField;

	@Transient
	private String transientField;

	public SimpleDbUser() {
		super();
	}

	public SimpleDbUser(String persistedField) {
		this();
		this.persistedField = persistedField;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemName() {
		return itemName;
	}

	public float getPrimitiveField() {
		return primitiveField;
	}

	public void setPrimitiveField(float primitiveField) {
		this.primitiveField = primitiveField;
	}

	public String getCoreField() {
		return coreField;
	}

	public void setCoreField(String coreField) {
		this.coreField = coreField;
	}

	public NestedEntity getNestedEntity() {
		return nestedEntity;
	}

	public void setNestedEntity(NestedEntity nestedEntity) {
		this.nestedEntity = nestedEntity;
	}

	public Object getObjectField() {
		return objectField;
	}

	public void setObjectField(Object objectField) {
		this.objectField = objectField;
	}

	public List<Integer> getCoreTypeList() {
		return coreTypeList;
	}

	public long[] getPrimitiveArrayField() {
		return (primitiveArrayField != null ? primitiveArrayField.clone()
				: null);
	}

	public void setCoreTypeList(List<Integer> coreTypeList) {
		this.coreTypeList = coreTypeList;
	}

	public void setPrimitiveArrayField(long[] primitiveArrayField) {
		this.primitiveArrayField = primitiveArrayField.clone();
	}

	public List<JSONCompatibleClass> getObjectList() {
		return objectList;
	}

	public void setObjectList(List<JSONCompatibleClass> objectList) {
		this.objectList = objectList;
	}

	public Map<String, JSONCompatibleClass> getMapOfStringAndObject() {
		return mapOfStringAndObject;
	}

	public void setMapOfStringAndObject(
			Map<String, JSONCompatibleClass> mapOfStringAndObject) {
		this.mapOfStringAndObject = mapOfStringAndObject;
	}

	public String getTransientField() {
		return transientField;
	}

	public void setTransientField(String transientField) {
		this.transientField = transientField;
	}

	public static class NestedEntity {

		private int nestedPrimitiveField;
		private InnerNestedEntity innerNestedEntity;

		public int getNestedPrimitiveField() {
			return nestedPrimitiveField;
		}

		public void setNestedPrimitiveField(int nestedPrimitiveField) {
			this.nestedPrimitiveField = nestedPrimitiveField;
		}

		public InnerNestedEntity getInnerNestedEntity() {
			return innerNestedEntity;
		}

		public void setInnerNestedEntity(InnerNestedEntity innerNestedEntity) {
			this.innerNestedEntity = innerNestedEntity;
		}

		/**
		 * Auto-generated
		 */
		@Override
		public int hashCode() {
			return HashCodeBuilder.reflectionHashCode(NestedEntity.this);
		}

		@Override
		public boolean equals(Object obj) {
			return EqualsBuilder.reflectionEquals(NestedEntity.this, obj);
		}

		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}

		public static class InnerNestedEntity {
			private String innerNestedField;

			public String getInnerNestedField() {
				return innerNestedField;
			}

			public void setInnerNestedField(String innerNestedField) {
				this.innerNestedField = innerNestedField;
			}

			@Override
			public int hashCode() {
				return HashCodeBuilder
						.reflectionHashCode(InnerNestedEntity.this);
			}

			@Override
			public boolean equals(Object obj) {
				return EqualsBuilder.reflectionEquals(InnerNestedEntity.this,
						obj);
			}

			@Override
			public String toString() {
				return ToStringBuilder.reflectionToString(this);
			}

		}
	}

	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
