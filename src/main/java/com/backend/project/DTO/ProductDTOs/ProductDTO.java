package com.backend.project.DTO.ProductDTOs;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.backend.project.DTO.Company.CompanyDTO;
import com.backend.project.DTO.UserDTOs.RolesUserDTO;
import com.backend.project.DTO.UserDTOs.UserDTO;

public class ProductDTO {	
	

	
	private long id;

	@NotEmpty
	@Size(min = 3, message="PRODUCT.ERROR.TITULO_PRODUCT")
	private String name;

	private String description;

	
	private String preparesin;

	private String allergies;

	private String barCode;

	
	private double price;

	private boolean isValid;

	private boolean isSpent;
	
	private String picture;
	
	private TypesProductDTO typeProduct;

	private CompanyDTO company;
	
	private Date creaDate;
	
	private LocalDateTime update_date;	

	private long creaUser;
	
	private long modUser;
	
	private UserDTO user = new UserDTO();
 
	public ProductDTO() {
		super();
	}

	public ProductDTO(long id, @NotEmpty @Size(min = 3, message = "PRODUCT.ERROR.TITULO_PRODUCT") String name,
			String description, String preparesin, String allergies, String barCode, double price, boolean isValid,
			boolean isSpent, String picture, TypesProductDTO typeProduct, CompanyDTO company, Date creaDate,
			LocalDateTime update_date, long creaUser, long modUser, UserDTO user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.preparesin = preparesin;
		this.allergies = allergies;
		this.barCode = barCode;
		this.price = price;
		this.isValid = isValid;
		this.isSpent = isSpent;
		this.picture = picture;
		this.typeProduct = typeProduct;
		this.company = company;
		this.creaDate = creaDate;
		this.update_date = update_date;
		this.creaUser = creaUser;
		this.modUser = modUser;
		this.user = user;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}


	public long getIdProduct() {
		return id;
	}

	public void setId(long idProduct) {
		this.id = idProduct;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
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

	public LocalDateTime getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(LocalDateTime update_date) {
		this.update_date = update_date;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	
}
