package com.backend.project.services;


import com.backend.project.DTO.UserDTOs.UserDTO;
import com.backend.project.DTO.UserDTOs.UserDetailDTO;
import com.backend.project.DTO.UserDTOs.UserResponseDTO;
import com.backend.project.DTO.UserDTOs.UserUpdateDTO;

public interface UserService {

	
	public UserResponseDTO getUsers(int numberPage, int pageSize, String orderBy, String sortDir);

	public UserDetailDTO insertUser(UserUpdateDTO reqDto);
//
	public UserDetailDTO getUserById(long id);
//
	public UserDetailDTO updateUser(UserUpdateDTO reqDto, long id);
//
	public void deleteUser(long id);

	public UserDTO getUserId(long id);
}
