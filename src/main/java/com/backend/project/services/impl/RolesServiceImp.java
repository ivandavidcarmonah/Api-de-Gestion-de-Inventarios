package com.backend.project.services.impl;

import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.backend.project.DTO.UserDTOs.RolesUserDTO;
import com.backend.project.DTO.UserDTOs.UserDTO;
import com.backend.project.DTO.UserDTOs.UserDetailDTO;
import com.backend.project.DTO.UserDTOs.UserResponseDTO;
import com.backend.project.entities.RolesEntity;
import com.backend.project.entities.UserEntity;
import com.backend.project.exceptions.ResourceNotFoundException;
import com.backend.project.repositories.RolesRepository;
import com.backend.project.repositories.UserRepository;
import com.backend.project.services.RolesService;
import com.backend.project.services.UserService;

@Service
public class RolesServiceImp implements RolesService {

	@Autowired
	private ModelMapper modelMapper;
	

	@Autowired
	private RolesRepository rolesRepository;

	@Override
	public RolesUserDTO create(RolesUserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RolesUserDTO> getList() {
		List<RolesEntity> rolesEntity = this.rolesRepository.findAll();
		List<RolesUserDTO> rolesDTO = rolesEntity.stream().map(element -> mapDTO(element))
				.collect(Collectors.toList());

		return rolesDTO;
	}

	
	private RolesEntity mapEntitie(RolesUserDTO dto) {
		RolesEntity entity = this.modelMapper.map(dto, RolesEntity.class);
		return entity;
	}
	
	private RolesUserDTO mapDTO(RolesEntity value) {
		RolesUserDTO rol = this.modelMapper.map(value, RolesUserDTO.class);
		return rol;
	}





}
