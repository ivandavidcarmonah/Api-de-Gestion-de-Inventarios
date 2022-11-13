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
@Table(name = "types_products")
public class TypesProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTypesProducts;
	
	@Column
	private String name;

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
	
	public TypesProductEntity() {
		super();
	}

	public TypesProductEntity(long idTypesProducts, String name, CompanyEntity company, Date creaDate, Date modDate,
			long creaUser, long modUser) {
		super();
		this.idTypesProducts = idTypesProducts;
		this.name = name;
		this.company = company;
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
