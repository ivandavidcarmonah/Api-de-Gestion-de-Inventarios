package com.backend.project.DTO.BarTableDTOs;

import java.util.Date;

import com.backend.project.DTO.Company.CompanyDTO;

public class BarTableDTO {

	private long idBarTable;

	private CompanyDTO company;

	private long numTable;

	private String place;

	private String codeQR;
	
	private Date creaDate;	

	private long creaUser;
	
	private Date modDate;	
	
	private long modUser;

	public BarTableDTO(long idBarTable, CompanyDTO company, long numTable, String place, String codeQR, Date creaDate,
			long creaUser) {
		super();
		this.idBarTable = idBarTable;
		this.company = company;
		this.numTable = numTable;
		this.place = place;
		this.codeQR = codeQR;
		this.creaDate = creaDate;
		this.creaUser = creaUser;
	}
	
	public BarTableDTO() {
		super();
	}

	public long getIdBarTable() {
		return idBarTable;
	}

	public void setIdBarTable(long idBarTable) {
		this.idBarTable = idBarTable;
	}

	public CompanyDTO getCompany() {
		return company;
	}

	public void setCompany(CompanyDTO company) {
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
