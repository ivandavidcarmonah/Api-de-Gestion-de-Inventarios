package com.backend.project.DTO.Company;

public class TypesLicenseDTO {

	private long idTypeLicense;
	
	private String name;

	private String description;
	
	public TypesLicenseDTO() {
		super();
	}

	public TypesLicenseDTO(long idTypeLicense, String name, String description) {
		super();
		this.idTypeLicense = idTypeLicense;
		this.name = name;
		this.description = description;
	}

	public long getIdTypeLicense() {
		return idTypeLicense;
	}

	public void setIdTypeLicense(long idTypeLicense) {
		this.idTypeLicense = idTypeLicense;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
