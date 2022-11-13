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
@Table(name = "bar_tables")
public class BarTableEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idBarTable;

	@ManyToOne
	@JoinColumn(name = "idCompany")
	private CompanyEntity company;

	@Column(nullable = false)
	private long numTable;

	@Column(nullable = false)
	private String place;

	@Column(nullable = false)
	private String codeQR;
	
	@Column(name = "crea_date", nullable = false)
	private Date creaDate;	

	@Column(name = "crea_user", nullable = false)
	private long creaUser;	
	
	@Column(name = "mod_date", nullable = true)	
	private Date modDate;	
	
	@Column(name = "mod_user", nullable = true)
	private long modUser;

	public BarTableEntity(long idBarTable, CompanyEntity company, long numTable, String place, String codeQR,
			Date creaDate, long creaUser, Date modDate, long modUser) {
		super();
		this.idBarTable = idBarTable;
		this.company = company;
		this.numTable = numTable;
		this.place = place;
		this.codeQR = codeQR;
		this.creaDate = creaDate;
		this.creaUser = creaUser;
		this.modDate = modDate;
		this.modUser = modUser;
	}

	public BarTableEntity() {
		super();
	}

	public long getIdBarTable() {
		return idBarTable;
	}

	public void setIdBarTable(long idBarTable) {
		this.idBarTable = idBarTable;
	}

	public CompanyEntity getCompany() {
		return company;
	}

	public void setCompany(CompanyEntity company) {
		this.company = company;
	}

	public long getNumTable() {
		return numTable;
	}

	public void setNumTable(long numTable) {
		this.numTable = numTable;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCodeQR() {
		return codeQR;
	}

	public void setCodeQR(String codeQR) {
		this.codeQR = codeQR;
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

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public long getModUser() {
		return modUser;
	}

	public void setModUser(long modUser) {
		this.modUser = modUser;
	}
}
