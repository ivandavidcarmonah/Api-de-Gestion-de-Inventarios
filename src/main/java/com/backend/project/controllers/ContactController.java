package com.backend.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.project.services.impl.ContactService;

@RestController 
@RequestMapping( "/api/contact")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class ContactController {

	
	@Autowired
	private ContactService service;
	
	
	@GetMapping("/send")
	public String sendContact(
			
			){
		this.service.send("ivandavidcarmonah@gmail.com", "ivandavidcarmonah@gmail.com", "Hola quetal", "Cuerpo del mensaje");
		return "MAIL.CORRECTO";
		
	}
	
}
