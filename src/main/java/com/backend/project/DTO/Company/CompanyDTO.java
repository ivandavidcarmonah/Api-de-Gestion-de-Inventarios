package com.backend.project.DTO.Company;

import java.util.Date;

public class CompanyDTO {

	private long idCompany;

	private String name;

	private String cif;

	private String address;

	private String mailCompany;

	private String phoneCompany;

	private String schedule;

	private String nameOwner;

	private String phoneOwner;

	private String mailOwner;

	private String otherData;

	private String pictureLogo;
	
	private Date licenseDate;
	
	private TypesLicenseDTO typeLicense;
	
	private Date creaDate;
	
	private Date modDate;	
	
	private long modUser;

	public CompanyDTO(long idCompany, String name, String cif, String address, String mailCompany, String phoneCompany,
			String schedule, String nameOwner, String phoneOwner, String mailOwner, String otherData,
			String pictureLogo, Date licenseDate, TypesLicenseDTO typeLicense, Date creaDate, Date modDate,
			long modUser) {
		super();
		this.idCompany = idCompany;
		this.name = name;
		this.cif = cif;
		this.address = address;
		this.mailCompany = mailCompany;
		this.phoneCompany = phoneCompany;
		this.schedule = schedule;
		this.nameOwner = nameOwner;
		this.phoneOwner = phoneOwner;
		this.mailOwner = mailOwner;
		this.otherData = otherData;
		this.pictureLogo = pictureLogo;
		this.licenseDate = licenseDate;
		this.typeLicense = typeLicense;
		this.creaDate = creaDate;
		this.modDate = modDate;
		this.modUser = modUser;
	}

	public CompanyDTO() {
		super();
	}
	
	public CompanyDTO(long idCompany) {
		super();
		this.idCompany = idCompany;
	}

	public long getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(long idCompany) {
		this.idCompany = idCompany;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMailCompany() {
		return mailCompany;
	}

	public void setMailCompany(String mailCompany) {
		this.mailCompany = mailCompany;
	}

	public String getPhoneCompany() {
		return phoneCompany;
	}

	public void setPhoneCompany(String phoneCompany) {
		this.phoneCompany = phoneCompany;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getNameOwner() {
		return nameOwner;
	}

	public void setNameOwner(String nameOwner) {
		this.nameOwner = nameOwner;
	}

	public String getPhoneOwner() {
		return phoneOwner;
	}

	public void setPhoneOwner(String phoneOwner) {
		this.phoneOwner = phoneOwner;
	}

	public String getMailOwner() {
		return mailOwner;
	}

	public void setMailOwner(String mailOwner) {
		this.mailOwner = mailOwner;
	}

	public String getOtherData() {
		return otherData;
	}

	public void setOtherData(String otherData) {
		this.otherData = otherData;
	}

	public String getPictureLogo() {
		return pictureLogo;
	}

	public void setPictureLogo(String pictureLogo) {
		this.pictureLogo = pictureLogo;
	}

	public Date getLicenseDate() {
		return licenseDate;
	}

	public void setLicenseDate(Date licenseDate) {
		this.licenseDate = licenseDate;
	}

	public TypesLicenseDTO getTypeLicense() {
		return typeLicense;
	}

	public void setTypeLicense(TypesLicenseDTO typeLicense) {
		this.typeLicense = typeLicense;
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

	public long getModUser() {
		return modUser;
	}

	public void setModUser(long modUser) {
		this.modUser = modUser;
	}
	
}
