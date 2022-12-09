package com.backend.project.controllers;



import java.sql.Date;
import java.util.Collections;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.project.DTO.UserDTOs.RegisterUserDTO;
import com.backend.project.DTO.UserDTOs.UserDTO;
import com.backend.project.DTO.UserDTOs.UserDetailDTO;
import com.backend.project.DTO.UserDTOs.UserResponseDTO;
import com.backend.project.entities.RolesEntity;
import com.backend.project.entities.UserEntity;
import com.backend.project.repositories.GenderRepository;
import com.backend.project.repositories.LanguageRepository;
import com.backend.project.repositories.RolesRepository;
import com.backend.project.repositories.UserRepository;
import com.backend.project.services.UserService;
import com.backend.project.utils.AppConstants;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RolesRepository rolesRepository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private GenderRepository genderRepository;

	@Autowired
	private LanguageRepository languageRepository;
	

//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/list-users")
	public UserResponseDTO getUsers(@Valid
			@RequestParam(value = AppConstants.NUMBER_PAGE, defaultValue = "0", required = false) int numberPage,
			@RequestParam(value = AppConstants.SIZE_PAGE, defaultValue = "10", required = false) int pageSize,
			@RequestParam(value = AppConstants.ORDER_BY, defaultValue = "id", required = false) String orderBy,
			@RequestParam(value = AppConstants.ORDER_DIR, defaultValue = "asc", required = false) String sortDir) {

		return this.userService.getUsers(numberPage, pageSize, orderBy, sortDir);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/edit-user/{id}")
	public ResponseEntity<UserDetailDTO> getUserById(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok( this.userService.getUserById(id));
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/new-user")
	public ResponseEntity<?> editUser(@RequestBody RegisterUserDTO registerUserDTO){
		if(this.userRepository.existsByUsername(registerUserDTO.getUsername())) {
			return new ResponseEntity<>("AUTH.ERROR.REGISTER_USERNAME_EXISTS", HttpStatus.BAD_REQUEST);
		}
		if(this.userRepository.existsByEmail(registerUserDTO.getEmail())) {
			return new ResponseEntity<>("AUTH.ERROR.REGISTER_EMAIL_EXISTS", HttpStatus.BAD_REQUEST);
		}
		
		UserEntity userEntity = new UserEntity();
		userEntity.setEmail(registerUserDTO.getEmail());
		userEntity.setName(registerUserDTO.getName());
		userEntity.setUsername(registerUserDTO.getUsername());
		userEntity.setNumberPhone(registerUserDTO.getNumberPhone());

		userEntity.setLanguage(this.languageRepository.getById(registerUserDTO.getIdLanguage()));
		userEntity.setGender(this.genderRepository.getById(registerUserDTO.getIdGender()));

		//Para almacenar la fecha en BD se necesitan en milisegundos
		long miliseconds = System.currentTimeMillis(); //Fecha en milisegundos Actual del sistema
        Date date = new Date(miliseconds);
        
		userEntity.setPassword(this.passwordEncoder.encode(registerUserDTO.getUsername()));
		this.userRepository.save(userEntity);


		RolesEntity rolesEntity = this.rolesRepository.findByName("ROLE_ADMIN").get();
		userEntity.setRoles(Collections.singleton(rolesEntity));
		
		return new ResponseEntity<>("AUTH.REGISTER.REGISTER_USER_OK", HttpStatus.CREATED);
		
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/update-user")
	public ResponseEntity<UserDetailDTO> updateUser(@RequestBody UserDetailDTO updateUserDto){
		UserDetailDTO detailDTO = this.userService.updateUser(updateUserDto, updateUserDto.getId());

		return new ResponseEntity<>(detailDTO, HttpStatus.OK);
		
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(name = "id") long id) {
		this.userService.deleteUser(id);
		return new ResponseEntity<>("BORRADO.CORRECTO", HttpStatus.OK);

	}
	//
//
//	
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
//	@PostMapping("/new-publications")
//	public ResponseEntity<PublicationDTO> savePublication(@Valid @RequestBody PublicationDTO reqDto) {
//		return new ResponseEntity<>(this.publicationsService.createPublication(reqDto), HttpStatus.CREATED);
//	}
//
//
//	
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
//	@PutMapping("/update/{id}")
//	public ResponseEntity<PublicationDTO> updatePublication(@Valid @RequestBody PublicationDTO reqDto,
//			@PathVariable(name = "id") long id) {
//		PublicationDTO res = publicationsService.updatePublication(reqDto, id);
//		return new ResponseEntity<>(res, HttpStatus.OK);
//	}
//
//
//	
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<String> deletePublication(@PathVariable(name = "id") long id) {
//		this.publicationsService.deletePublication(id);
//
//		return new ResponseEntity<>("BORRADO.CORRECTO", HttpStatus.OK);
//
//	}

}
