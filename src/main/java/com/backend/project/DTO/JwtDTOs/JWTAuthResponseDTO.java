package com.backend.project.DTO.JwtDTOs;

import com.backend.project.DTO.UserDTOs.UserDTO;

public class JWTAuthResponseDTO {

	private String tokenType = "Bearer";
	private String tokenAcces;
	private UserDTO userDTO;
	private boolean ok;
	
	
	public String getTokenType() {
		return tokenType;
	}
	
	
	public JWTAuthResponseDTO(String tokenType, String tokenAcces) {
		super();
		this.tokenType = tokenType;
		this.tokenAcces = tokenAcces;
	}


	public UserDTO getUserDTO() {
		return userDTO;
	}


	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}


	public JWTAuthResponseDTO(String tokenAcces, UserDTO userDTO, boolean ok) {
		super();
		this.tokenAcces = tokenAcces;
		this.userDTO = userDTO;
		this.ok = ok;
	}
	
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	
	public String getTokenAcces() {
		return tokenAcces;
	}
	public void setTokenAcces(String tokenAcces) {
		this.tokenAcces = tokenAcces;
	}


	public boolean isOk() {
		return ok;
	}


	public void setOk(boolean ok) {
		this.ok = ok;
	}
	
	
}
