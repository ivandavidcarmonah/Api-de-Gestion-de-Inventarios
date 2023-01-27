package com.backend.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "gender", uniqueConstraints = { @UniqueConstraint(columnNames = { "code" }),
		@UniqueConstraint(columnNames = { "name" }) })
public class GenderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 60)
	private String name;
	
	@Column(length = 60)
	private String code;

	
	public GenderEntity(long id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public GenderEntity() {
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
