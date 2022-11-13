package com.backend.project.DTO.UserDTOs;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {

	private long id;
	private String name;
	private String email;
	private String username;
	
	private  Set<RolesUserDTO> roles = new HashSet<RolesUserDTO>();
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(long id, String name, String email, String username) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<RolesUserDTO> getRoles() {
		return roles;
	}

	public void setRoles(Set<RolesUserDTO> roles) {
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
