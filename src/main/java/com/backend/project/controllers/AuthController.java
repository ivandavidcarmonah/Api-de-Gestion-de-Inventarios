package com.backend.project.controllers;

import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.project.DTO.JwtDTOs.JWTAuthResponseDTO;
import com.backend.project.DTO.LoginDTOs.LoginDTO;
import com.backend.project.DTO.UserDTOs.RegisterUserDTO;
import com.backend.project.DTO.UserDTOs.UserDTO;
import com.backend.project.entities.RolesEntity;
import com.backend.project.entities.UserEntity;
import com.backend.project.exceptions.BackStandarAppException;
import com.backend.project.repositories.RolesRepository;
import com.backend.project.repositories.UserRepository;
import com.backend.project.security.JwtTokenProvider;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;



@RestController 
@RequestMapping( "/api/auth")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class AuthController {

	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Value("${app.jwt-secret}")
	private String jwtSecret;
	
	@Value("${app.jwt-expiration-milliseconds}")
	private int jwtExpiration;
	
	@PostMapping("/login")
	public ResponseEntity<JWTAuthResponseDTO> authenticateUser(@RequestBody LoginDTO loginDTO){
		Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));
	
		SecurityContextHolder.getContext().setAuthentication(authentication);
		//Obtener token
		String token = this.jwtTokenProvider.generateToken(authentication);
		
		UserEntity userEntity =  this.userRepository.findByUsernameOrEmail(loginDTO.getUsernameOrEmail(), loginDTO.getUsernameOrEmail())
				.orElseThrow(() -> new UsernameNotFoundException("USER.ERROR.NOTFOUND_USERNAME_OR_EMAIL : " + loginDTO.getUsernameOrEmail()));
		
		UserDTO userDTO = new UserDTO();
		userDTO = this.modelMapper.map(userEntity, UserDTO.class);
		return ResponseEntity.ok(new JWTAuthResponseDTO(token, userDTO, true));
	}
	
	
	@PostMapping("/register-user")
	public ResponseEntity<?> registerUser(@RequestBody RegisterUserDTO registerUserDTO){
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
		userEntity.setPassword(this.passwordEncoder.encode(registerUserDTO.getPassword()));
		this.userRepository.save(userEntity);

		RolesEntity rolesEntity = this.rolesRepository.findByName("ROLE_ADMIN").get();
		userEntity.setRoles(Collections.singleton(rolesEntity));
		
		
		return new ResponseEntity<>("AUTH.REGISTER.REGISTER_USER_OK", HttpStatus.CREATED);
		
	}
	
	@GetMapping("token-valid")
	public boolean validarToken(@RequestHeader("Authorization") String authorization){
		String token;
		if(StringUtils.hasText(authorization) && authorization.startsWith("Bearer") ) {
			token = authorization.substring(7, authorization.length());
			
			return this.tokenValid(token);
		}
		else {
			return false;
		}
		
	}
	
	private boolean tokenValid(String token) {
		
		try {
			
			Jwts.parser().setSigningKey(this.jwtSecret).parseClaimsJws(token);
			return true;
			
		} 
		catch (SignatureException e) {
			// TODO: handle exception
			throw new BackStandarAppException(HttpStatus.BAD_REQUEST, "JWT.FIRMA_NO_VALIDA");
		}
		catch (MalformedJwtException e) {
			// TODO: handle exception
			throw new BackStandarAppException(HttpStatus.BAD_REQUEST, "JWT.TOKEN_NO_VALIDO");
		}
		catch (ExpiredJwtException e) {
			// TODO: handle exception
			throw new BackStandarAppException(HttpStatus.BAD_REQUEST, "JWT.TOKEN_CADUCADO");
		}
		catch (UnsupportedJwtException e) {
			// TODO: handle exception
			throw new BackStandarAppException(HttpStatus.BAD_REQUEST, "JWT.TOKEN_NO_COMPATIBLE");
		}
		catch (IllegalArgumentException e) {
			// TODO: handle exception
			throw new BackStandarAppException(HttpStatus.BAD_REQUEST, "JWT.CADENA_CLAIMS_VACIA");
		}
	}
	
	
	
	
	
	
}
