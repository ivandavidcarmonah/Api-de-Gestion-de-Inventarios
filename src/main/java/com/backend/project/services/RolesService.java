package com.backend.project.services;


import java.util.List;

import com.backend.project.DTO.UserDTOs.RolesUserDTO;
import com.backend.project.DTO.UserDTOs.UserDTO;
import com.backend.project.DTO.UserDTOs.UserDetailDTO;
import com.backend.project.DTO.UserDTOs.UserResponseDTO;

public interface RolesService {

	public RolesUserDTO create(RolesUserDTO dto);
	
	public List<RolesUserDTO> getList();
	
}
