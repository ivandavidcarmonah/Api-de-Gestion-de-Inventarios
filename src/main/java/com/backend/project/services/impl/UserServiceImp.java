package com.backend.project.services.impl;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.backend.project.DTO.UserDTOs.UserDTO;
import com.backend.project.DTO.UserDTOs.UserDetailDTO;
import com.backend.project.DTO.UserDTOs.UserResponseDTO;
import com.backend.project.entities.UserEntity;
import com.backend.project.exceptions.ResourceNotFoundException;
import com.backend.project.repositories.GenderRepository;
import com.backend.project.repositories.LanguageRepository;
import com.backend.project.repositories.UserRepository;
import com.backend.project.services.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private ModelMapper modelMapper;
	

	@Autowired
	private GenderRepository genderRepository;

	@Autowired
	private LanguageRepository languageRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDTO createUser(UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public UserDetailDTO getUserById(long id) {
		UserEntity userEntity= this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Users", "id", id));
		return mapUserDetailDTO(userEntity);
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
	public UserDetailDTO updateUser(UserDetailDTO reqDto, long id) {
		UserEntity user = this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Users", "id", id));

		UserEntity userUpdate = new UserEntity();
		userUpdate = this.mapEntitie(reqDto);
		
		user.setName(reqDto.getName());
		user.setEmail(reqDto.getEmail());
		user.setName(reqDto.getName());
		user.setUsername(reqDto.getUsername());
		user.setNumberPhone(reqDto.getNumberPhone());
		user.setBirthDate(reqDto.getBirthDate());

//		if (user.getLanguage().getId() != reqDto.getIdLanguage()) {
//			user.setLanguage(this.languageRepository.getById(reqDto.getIdLanguage()));
//		}
//		if (user.getGender().getId() != userUpdate.getGender().getId()) {
//			user.setGender(this.genderRepository.getById(reqDto.getIdGender()));
//		}
	
		//Para almacenar la fecha en BD se necesitan en milisegundos
		long miliseconds = System.currentTimeMillis(); //Fecha en milisegundos Actual del sistema
        Date date = new Date(miliseconds);
		
		
        UserEntity update = this.userRepository.save(user);

		return mapUserDetailDTO(update);
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
	private UserEntity mapEntitie(UserDTO dto) {
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



	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		UserEntity entitie = this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Publications", "id", id));
		this.userRepository.delete(entitie);
	}


}
