package com.backend.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String resourceName;
	private String nameColumn;
	private long valueColumn;
	private String valueColumnString;

	public ResourceNotFoundException(String resourceName, String nameColumn, long valueColumn) {
		super(String.format("Resourse not found.\n Entitie: '%s' \n Propertie: '%s' \n Value: '%s'", resourceName, nameColumn, valueColumn));
		this.resourceName = resourceName;
		this.nameColumn = nameColumn;
		this.valueColumn = valueColumn;
	}
	
	public ResourceNotFoundException(String resourceName, String nameColumn, String valueColumn) {
		super(String.format("Resourse not found.\n Entitie: '%s' \n Propertie: '%s' \n Value: '%s'", resourceName, nameColumn, valueColumn));
		this.resourceName = resourceName;
		this.nameColumn = nameColumn;
		this.valueColumnString = valueColumn;
	}

	
	
	public String getValueColumnString() {
		return valueColumnString;
	}

	public void setValueColumnString(String valueColumnString) {
		this.valueColumnString = valueColumnString;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getNameColumn() {
		return nameColumn;
	}

	public void setNameColumn(String nameColumn) {
		this.nameColumn = nameColumn;
	}

	public long getValueColumn() {
		return valueColumn;
	}

	public void setValueColumn(long valueColumn) {
		this.valueColumn = valueColumn;
	}
	


}
