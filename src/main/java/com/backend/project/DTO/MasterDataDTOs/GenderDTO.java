package com.backend.project.DTO.MasterDataDTOs;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class GenderDTO {
	
	private long id;
	
	
	private String name;
	
	
	private String code;


	public GenderDTO(long id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}


	public GenderDTO() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}
	
	
}
