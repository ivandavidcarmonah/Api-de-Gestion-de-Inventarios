package com.backend.project.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.project.DTO.ContactDTOs.SendContactDTO;
import com.backend.project.services.impl.ContactService;

@RestController 
@RequestMapping( "/api/contact")
@CrossOrigin(origins = "*", methods= {RequestMethod.POST})
public class ContactController {

	
	@Autowired
	private ContactService service;
	
	
	@PostMapping("/send")
	public boolean sendContact(@Valid @RequestBody SendContactDTO reqDto){
		return this.service.send( "ivandavidcarmonah@gmail.com", reqDto.getEmail() , reqDto.getSubject(), reqDto.getContent());
		
	}
	
}
