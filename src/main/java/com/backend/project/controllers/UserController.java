package com.backend.project.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.backend.project.DTO.UserDTOs.UserDetailDTO;
import com.backend.project.DTO.UserDTOs.UserResponseDTO;
import com.backend.project.DTO.UserDTOs.UserUpdateDTO;
import com.backend.project.repositories.UserRepository;
import com.backend.project.services.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@PreAuthorize("hasRole('ROLE_SUPER_ROOT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EDITOR') or hasRole('ROLE_VISITANTE')")
	@GetMapping("/list-users")
	public UserResponseDTO getUsers(@Valid
			@RequestParam(name = "numberPage", defaultValue = "0", required = false) int numberPage,
			@RequestParam(name = "pageSize", defaultValue = "10", required = false) int pageSize,
			@RequestParam(name = "orderBy", defaultValue = "id", required = false) String orderBy,
			@RequestParam(name = "sortDir", defaultValue = "asc", required = false) String sortDir) {

		return this.userService.getUsers(numberPage, pageSize, orderBy, sortDir);
	}

	@PreAuthorize("hasRole('ROLE_SUPER_ROOT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EDITOR') or hasRole('ROLE_VISITANTE')")
	@GetMapping("/edit-user/{id}")
	public ResponseEntity<UserDetailDTO> getUserById(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok( this.userService.getUserById(id));
	}

	@PreAuthorize("hasRole('ROLE_SUPER_ROOT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EDITOR')")
	@PostMapping("/new-user")
	public ResponseEntity<?> insert(@Valid @RequestBody UserUpdateDTO registerUserDTO){
		if(this.userRepository.existsByUsername(registerUserDTO.getUsername())) {
			return new ResponseEntity<>("AUTH.ERROR.REGISTER_USERNAME_EXISTS", HttpStatus.BAD_REQUEST);
		}
		if(this.userRepository.existsByEmail(registerUserDTO.getEmail())) {
			return new ResponseEntity<>("AUTH.ERROR.REGISTER_EMAIL_EXISTS", HttpStatus.BAD_REQUEST);
		}
		
		UserDetailDTO userNew =  this.userService.insertUser(registerUserDTO);
		
		return new ResponseEntity<>(userNew, HttpStatus.CREATED);
		
	}
	
	@PreAuthorize("hasRole('ROLE_SUPER_ROOT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EDITOR')")
	@PutMapping("/update-user")
	public ResponseEntity<UserDetailDTO> updateUser(@Valid @RequestBody UserUpdateDTO updateUserDto){
		UserDetailDTO detailDTO = this.userService.updateUser(updateUserDto, updateUserDto.getId());

		return new ResponseEntity<>(detailDTO, HttpStatus.OK);
		
	}
	
	
	@PreAuthorize("hasRole('ROLE_SUPER_ROOT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EDITOR')")
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
