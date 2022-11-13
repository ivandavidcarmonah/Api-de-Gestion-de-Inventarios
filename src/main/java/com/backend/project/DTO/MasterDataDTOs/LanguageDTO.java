package com.backend.project.DTO.MasterDataDTOs;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class LanguageDTO {
	
	private long id;
	
	private String name;
	
	private String code;


	
	
	public LanguageDTO() {
		super();
	}

	public LanguageDTO(long id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
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


	
}
