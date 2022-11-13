package com.backend.project.DTO.ErrorsDTOs;

import java.util.Date;

public class ErrorDetailDTO {

	private Date time;
	private String mesage;
	private String detail;
	public ErrorDetailDTO(Date time, String mesage, String detail) {
		super();
		this.time = time;
		this.mesage = mesage;
		this.detail = detail;
	}
	public ErrorDetailDTO() {
		super();
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getMesage() {
		return mesage;
	}
	public void setMesage(String mesage) {
		this.mesage = mesage;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
