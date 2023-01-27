package com.backend.project.DTO.UserDTOs;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class RegisterUserDTO {
	

	
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

	private List<Integer> idRoles = new ArrayList<Integer>();

	public RegisterUserDTO(@NotEmpty @Size(min = 3, max = 20, message = "USERS.ERROR.NOMBRE_USUARIO") String username,
			@NotEmpty @Size(min = 3, max = 20, message = "USERS.ERROR.NAME") String name,
			@NotEmpty @Size(min = 5, message = "USERS.ERROR.EMAIL") String email, Date birthDate,
			@NotEmpty @Size(min = 6, message = "USERS.ERROR.PHONE_NUMBER") long numberPhone,
			@NotEmpty @Size(min = 6, message = "USERS.ERROR.PASSWORD") String password, String pictureUser,
			Date modification_date, int idGender, int idLanguage, List<Integer> idRoles) {
		super();
		this.username = username;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.numberPhone = numberPhone;
		this.password = password;
		this.pictureUser = pictureUser;
		this.modification_date = modification_date;
		this.idGender = idGender;
		this.idLanguage = idLanguage;
		this.idRoles = idRoles;
	}

	public RegisterUserDTO() {
		super();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<Integer> getIdRoles() {
		return idRoles;
	}

	public void setIdRoles(List<Integer> idRoles) {
		this.idRoles = idRoles;
	}
	
	
}
