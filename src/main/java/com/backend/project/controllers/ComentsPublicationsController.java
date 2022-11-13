package com.backend.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.project.DTO.PublicationDTOs.ComentsDTO;
import com.backend.project.services.ComentPublicationService;
@RestController
@RequestMapping("/api/publication-coments")
public class ComentsPublicationsController {

	@Autowired
	private ComentPublicationService comentsPublicationsService;
	
	@GetMapping("{publicationId}/coments")
	public List<ComentsDTO> listComentByPublicationId(
			@PathVariable(value ="publicationId") long publicationId
			){
		
		return this.comentsPublicationsService.getListComents(publicationId);
		
	}
	
	@PostMapping("{publicationId}/coments")
	public ResponseEntity<ComentsDTO> saveComent(
			@PathVariable(value ="publicationId") long publicationId,
			@RequestBody ComentsDTO comentDTO
			){
		
		return new ResponseEntity<>(this.comentsPublicationsService.newComent(publicationId, comentDTO), HttpStatus.CREATED);
		
	}

}
