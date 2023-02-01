package com.backend.project.services.impl;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.project.DTO.UserDTOs.RolesUserDTO;
import com.backend.project.DTO.UserDTOs.UserDTO;
import com.backend.project.DTO.UserDTOs.UserDetailDTO;
import com.backend.project.DTO.UserDTOs.UserResponseDTO;
import com.backend.project.DTO.UserDTOs.UserUpdateDTO;
import com.backend.project.entities.RolesEntity;
import com.backend.project.entities.UserEntity;
import com.backend.project.exceptions.ResourceNotFoundException;
import com.backend.project.repositories.UserRepository;
import com.backend.project.services.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private ModelMapper modelMapper;
	

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetailDTO getUserById(long id) {
		UserEntity userEntity= this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Users", "id", id));

		UserDetailDTO detailDTO = new UserDetailDTO();
		detailDTO =  mapUserDetailDTO(userEntity);
		
		return detailDTO;
	}
	
	@Override
	public UserDTO getUserId(long id) {
		UserEntity userEntity= this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Users", "id", id));
		return mapUserDTO(userEntity);
	}

	/**
	 * Devolver el listado ordenada
	 */
	public UserResponseDTO getUsers(int numberPage, int pageSize, String orderBy, String sortDir) {
		// TODO Auto-generated method stub
		Sort sort = sortDir.equalsIgnoreCase( Sort.Direction.ASC.name()) ? Sort.by(orderBy).ascending() : Sort.by(orderBy).descending(); 
		Pageable pageable = PageRequest.of(numberPage, pageSize, sort);
		Page<UserEntity> users = this.userRepository.findAll(pageable);

		List<UserEntity> values = users.getContent();
		List<UserDTO> userDto = values.stream().map(publicacion -> mapDTO(publicacion))
				.collect(Collectors.toList());

		UserResponseDTO userResponseDTO = new UserResponseDTO();
		userResponseDTO.setDataList(userDto);

		userResponseDTO.setNumberPage(users.getNumber());
		userResponseDTO.setSizePage(users.getSize());

		userResponseDTO.setDataLength(users.getNumberOfElements());
		userResponseDTO.setTotalPages(users.getTotalPages());
		userResponseDTO.setLastPage(users.isLast());

		return userResponseDTO;
	}
	
	
	@Override
	public UserDetailDTO updateUser(UserUpdateDTO reqDto, long id) {
		UserEntity user = this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Users", "id", id));

		UserEntity userUpdate = new UserEntity();
		userUpdate = this.mapEntitie(reqDto);
		
		user.setName(userUpdate.getName());
		user.setEmail(userUpdate.getEmail());
		user.setName(userUpdate.getName());
		user.setUsername(userUpdate.getUsername());
		user.setNumberPhone(userUpdate.getNumberPhone());
		user.setBirthDate(userUpdate.getBirthDate());
		user.setRoles(userUpdate.getRoles());
		
		if (user.getLanguage().getId() != userUpdate.getLanguage().getId()) {
			user.setLanguage(userUpdate.getLanguage());
		}
		if (user.getGender().getId() != userUpdate.getGender().getId()) {
			user.setGender(userUpdate.getGender());
		}
		
		user.setUpdate_date(LocalDateTime.now());
		
        UserEntity update = this.userRepository.save(user);

		return mapUserDetailDTO(update);
	}
	
	
	@Override
	public UserDetailDTO insertUser(UserUpdateDTO reqDto) {
		
		UserEntity user = new UserEntity();
		user = this.mapEntitie(reqDto);
		user.setUpdate_date(LocalDateTime.now());
		user.setCreation_date(LocalDateTime.now());
		user.setPassword(this.passwordEncoder.encode(reqDto.getUsername()));
		
        UserEntity update = this.userRepository.save(user);

		return mapUserDetailDTO(update);
	}
	

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		UserEntity entitie = this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Publications", "id", id));
		this.userRepository.delete(entitie);
	}

	
	
	
	
	
	/**
	 * Mapear desde un DTO -> Entidad
	 * 
	 * @param UserEntity
	 * @return UserDTO
	 */
	private UserDTO mapDTO(UserEntity user) {
		UserDTO userDTO = this.modelMapper.map(user, UserDTO.class);
		return userDTO;
	}
	
	/**
	 * Mapear desde un DTO -> Entidad
	 * 
	 * @param UserEntity
	 * @return UserDetailDTO
	 */
	private UserDetailDTO mapUserDetailDTO(UserEntity user) {
		UserDetailDTO userDetailDTO = this.modelMapper.map(user, UserDetailDTO.class);
		return userDetailDTO;
	}
	
	private UserDTO mapUserDTO(UserEntity user) {
		UserDTO userDetailDTO = this.modelMapper.map(user, UserDTO.class);
		return userDetailDTO;
	}

	/**
	 * Mapear desde Entidad -> DTO
	 * 
	 * @param UserDTO
	 * @return UserEntity
	 */
	@SuppressWarnings("unused")
	private UserEntity mapEntitie(UserUpdateDTO dto) {
		UserEntity entity = this.modelMapper.map(dto, UserEntity.class);
		return entity;
	}

	
	/**
	 * Mapear desde Entidad -> DTO
	 * 
	 * @param UserDetailDTO
	 * @return UserEntity
	 */
	private UserEntity mapEntitie(UserDetailDTO dto) {
		UserEntity entity = this.modelMapper.map(dto, UserEntity.class);
		return entity;
	}
	
	private RolesUserDTO mapDTO(RolesEntity value) {
		RolesUserDTO rol = this.modelMapper.map(value, RolesUserDTO.class);
		return rol;
	}



}
