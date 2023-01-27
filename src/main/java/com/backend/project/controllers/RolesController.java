package com.backend.project.controllers;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.project.DTO.UserDTOs.RolesUserDTO;
import com.backend.project.services.RolesService;



@RestController 
@RequestMapping( "/api/roles")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class RolesController {
	@Autowired
	private RolesService rolesService;
	
	
	@PreAuthorize("hasRole('ROLE_SUPER_ROOT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EDITOR')")
	@GetMapping("/list-roles")
	public List<RolesUserDTO> getRoles() {

		return this.rolesService.getList();
	}
	
	
	
	
	
	
	
}
