package com.backend.project.DTO.UserDTOs;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class UserDetailDTO {

	private long id;
	
	@NotEmpty
	@Size(min = 3, max = 20, message="USERS.ERROR.NOMBRE_USUARIO")
	private String username;
	
	@NotEmpty
	@Size(min = 3, max = 20, message="USERS.ERROR.NAME")
	private String name;
	
	@NotEmpty
	@Size(min = 5, message="USERS.ERROR.EMAIL")
	private String email;
	
	private Date birthDate;
	
	@NotEmpty
	@Size(min = 6, message="USERS.ERROR.PHONE_NUMBER")
	private long numberPhone;
	
	
	@NotEmpty
	@Size(min = 6, message="USERS.ERROR.PASSWORD")
	private String password;
	
	
	private String pictureUser;
	
	private Date modification_date;
	

	private long idGender;
	
	private long idLanguage;

	private  Set<RolesUserDTO> roles = new HashSet<RolesUserDTO>();


	public UserDetailDTO(long id, String username, String name, String email, Date birthDate, long numberPhone,
			String pictureUser, Date modification_date, String password
			) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.numberPhone = numberPhone;
		this.pictureUser = pictureUser;
		this.modification_date = modification_date;
		
		this.password = password;
	}

	public UserDetailDTO() {
		super();
	}
 
	public Set<RolesUserDTO> getRoles() {
		return roles;
	}

	public void setRoles(Set<RolesUserDTO> roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public long getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(long numberPhone) {
		this.numberPhone = numberPhone;
	}

	public String getPictureUser() {
		return pictureUser;
	}

	public void setPictureUser(String pictureUser) {
		this.pictureUser = pictureUser;
	}

	public Date getModification_date() {
		return modification_date;
	}

	public void setModification_date(Date modification_date) {
		this.modification_date = modification_date;
	}

	public long getIdGender() {
		return idGender;
	}

	public void setIdGender(long idGender) {
		this.idGender = idGender;
	}

	public long getIdLanguage() {
		return idLanguage;
	}

	public void setIdLanguage(long idLanguage) {
		this.idLanguage = idLanguage;
	}


}
