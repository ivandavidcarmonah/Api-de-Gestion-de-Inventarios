package com.backend.project.services;


import com.backend.project.DTO.UserDTOs.UserDTO;
import com.backend.project.DTO.UserDTOs.UserDetailDTO;
import com.backend.project.DTO.UserDTOs.UserResponseDTO;

public interface UserService {

	public UserDTO createUser(UserDTO dto);
	
	public UserResponseDTO getUsers(int numberPage, int pageSize, String orderBy, String sortDir);

//	public PublicationResponseDTO getPublications(int numberPage, int pageSize, String orderBy, String sortDir);
//
	public UserDetailDTO getUserById(long id);
//
	public UserDetailDTO updateUser(UserDetailDTO reqDto, long id);
//
	public void deleteUser(long id);

	public UserDTO getUserId(long id);
}
