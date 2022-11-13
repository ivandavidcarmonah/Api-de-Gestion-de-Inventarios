package com.backend.project.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProduct;

	@Column(nullable = false)
	private String title;

	@Column(nullable = true)
	private String description;

	@Column(nullable = false)
	private String preparesin;

	@Column(nullable = true)
	private String allergies;

	@Column(nullable = false)
	private String price;

	@Column(nullable = false)
	private boolean isValid;
	
	@ManyToOne
	@JoinColumn(name = "idTypesProducts")
	private TypesProductEntity typeProduct;
	
	@Column(nullable = true)
	private String picture;
	
	@Column(nullable = false)
	private boolean isSpent;

	@ManyToOne
	@JoinColumn(name = "idCompany")
	private CompanyEntity company;
	
	@Column(name = "crea_date")
	private Date creaDate;
	
	@Column(name = "mod_date", nullable = true)
	private Date modDate;	

	@Column(name = "crea_user")
	private long creaUser;
	
	@Column(name = "mod_user", nullable = true)
	private long modUser;

	public ProductEntity(long idProduct, String title, String description, String preparesin, String allergies,
			String price, boolean isValid, TypesProductEntity typeProduct, String picture, boolean isSpent,
			CompanyEntity company, Date creaDate, Date modDate, long creaUser, long modUser) {
		super();
		this.idProduct = idProduct;
		this.title = title;
		this.description = description;
		this.preparesin = preparesin;
		this.allergies = allergies;
		this.price = price;
		this.isValid = isValid;
		this.typeProduct = typeProduct;
		this.picture = picture;
		this.isSpent = isSpent;
		this.company = company;
		this.creaDate = creaDate;
		this.modDate = modDate;
		this.creaUser = creaUser;
		this.modUser = modUser;
	}

	public ProductEntity() {
		super();
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

	public TypesProductEntity getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(TypesProductEntity typeProduct) {
		this.typeProduct = typeProduct;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public boolean isSpent() {
		return isSpent;
	}

	public void setSpent(boolean isSpent) {
		this.isSpent = isSpent;
	}

	public CompanyEntity getCompany() {
		return company;
	}

	public void setCompany(CompanyEntity company) {
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
