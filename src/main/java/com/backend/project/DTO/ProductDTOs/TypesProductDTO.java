package com.backend.project.DTO.ProductDTOs;

import java.util.Date;

public class TypesProductDTO {

	private long idTypesProducts;
	
	private String name;

	private long idCompany;
	
	private Date creaDate;
	
	private Date modDate;	

	private long creaUser;
	
	private long modUser;
	
	public TypesProductDTO() {
		super();
	}

	public TypesProductDTO(long idTypesProducts, String name, long idCompany, Date creaDate, Date modDate,
			long creaUser, long modUser) {
		super();
		this.idTypesProducts = idTypesProducts;
		this.name = name;
		this.idCompany = idCompany;
		this.creaDate = creaDate;
		this.modDate = modDate;
		this.creaUser = creaUser;
		this.modUser = modUser;
	}

	public long getIdTypesProducts() {
		return idTypesProducts;
	}

	public void setIdTypesProducts(long idTypesProducts) {
		this.idTypesProducts = idTypesProducts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(long idCompany) {
		this.idCompany = idCompany;
	}

	public Date getCreaDate() {
		return creaDate;
	}

	public void setCreaDate(Date creaDate) {
		this.creaDate = creaDate;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public long getCreaUser() {
		return creaUser;
	}

	public void setCreaUser(long creaUser) {
		this.creaUser = creaUser;
	}

	public long getModUser() {
		return modUser;
	}

	public void setModUser(long modUser) {
		this.modUser = modUser;
	}
	
}
