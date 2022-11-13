package com.backend.project.DTO.BarTableDTOs;

import java.util.Date;

public class BarTableListDTO {

	private long idBarTable;

	private long idCompany;

	private long numTable;

	private String place;

	private String codeQR;
	
	private Date creaDate;	

	private long creaUser;
	
	private Date modDate;	
	
	private long modUser;
	
	public BarTableListDTO(long idBarTable, long idCompany, long numTable, String place, String codeQR, Date creaDate,
			long creaUser, Date modDate, long modUser) {
		super();
		this.idBarTable = idBarTable;
		this.idCompany = idCompany;
		this.numTable = numTable;
		this.place = place;
		this.codeQR = codeQR;
		this.creaDate = creaDate;
		this.creaUser = creaUser;
		this.modDate = modDate;
		this.modUser = modUser;
	}

	public BarTableListDTO() {
		super();
	}

	public long getIdBarTable() {
		return idBarTable;
	}

	public void setIdBarTable(long idBarTable) {
		this.idBarTable = idBarTable;
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

	public long getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(long idCompany) {
		this.idCompany = idCompany;
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
