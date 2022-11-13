package com.backend.project.DTO.ProductDTOs;


import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.backend.project.DTO.Company.CompanyDTO;

public class ProductDTO {	
	
	private long idProduct;

	@NotEmpty
	@Size(min = 3, message="PRODUCT.ERROR.TITULO_PRODUCT")
	private String title;

	private String description;

	@NotEmpty
	private String preparesin;

	private String allergies;

	@NotEmpty
	@Size(min = 1, message="PRODUCT.ERROR.PRICE_PRODUCT")
	private String price;

	private boolean isValid;

	private boolean isSpent;
	
	private String picture;
	
	private TypesProductDTO typeProduct;

	private CompanyDTO company;
	
	private Date creaDate;
	
	private Date modDate;	

	private long creaUser;
	
	private long modUser;

	public ProductDTO() {
		super();
	}

	public ProductDTO(long idProduct, @NotEmpty @Size(min = 3, message = "PRODUCT.ERROR.TITULO_PRODUCT") String title,
			String description, @NotEmpty String preparesin, String allergies,
			@NotEmpty @Size(min = 1, message = "PRODUCT.ERROR.PRICE_PRODUCT") String price, boolean isValid,
			boolean isSpent, String picture, TypesProductDTO typeProduct, CompanyDTO company, Date creaDate,
			Date modDate, long creaUser, long modUser) {
		super();
		this.idProduct = idProduct;
		this.title = title;
		this.description = description;
		this.preparesin = preparesin;
		this.allergies = allergies;
		this.price = price;
		this.isValid = isValid;
		this.isSpent = isSpent;
		this.picture = picture;
		this.typeProduct = typeProduct;
		this.company = company;
		this.creaDate = creaDate;
		this.modDate = modDate;
		this.creaUser = creaUser;
		this.modUser = modUser;
	}

	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPreparesin() {
		return preparesin;
	}

	public void setPreparesin(String preparesin) {
		this.preparesin = preparesin;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public boolean isSpent() {
		return isSpent;
	}

	public void setSpent(boolean isSpent) {
		this.isSpent = isSpent;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public TypesProductDTO getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(TypesProductDTO typeProduct) {
		this.typeProduct = typeProduct;
	}

	public CompanyDTO getCompany() {
		return company;
	}

	public void setCompany(CompanyDTO company) {
		this.company = company;
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
