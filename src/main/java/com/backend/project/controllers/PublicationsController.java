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

import com.backend.project.DTO.PublicationDTOs.PublicationDTO;
import com.backend.project.DTO.PublicationDTOs.PublicationResponseDTO;
import com.backend.project.services.PublicationService;
import com.backend.project.utils.AppConstants;

@RestController
@RequestMapping("/api/publication")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class PublicationsController {

	@Autowired
	private PublicationService publicationsService;

	
	@GetMapping("/list-publications")
	public PublicationResponseDTO getPublication(
			@RequestParam(value = AppConstants.NUMBER_PAGE, defaultValue = "0", required = false) int numberPage,
			@RequestParam(value = AppConstants.SIZE_PAGE, defaultValue = "10", required = false) int pageSize,
			@RequestParam(value = AppConstants.ORDER_BY, defaultValue = "id", required = false) String orderBy,
			@RequestParam(value = AppConstants.ORDER_DIR, defaultValue = "asc", required = false) String sortDir) {

		return this.publicationsService.getPublications(numberPage, pageSize, orderBy, sortDir);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PublicationDTO> getPublicationById(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(publicationsService.getPublicationsById(id));
	}


	
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/new-publications")
	public ResponseEntity<PublicationDTO> savePublication(@Valid @RequestBody PublicationDTO reqDto) {
		return new ResponseEntity<>(this.publicationsService.createPublication(reqDto), HttpStatus.CREATED);
	}


	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<PublicationDTO> updatePublication(@Valid @RequestBody PublicationDTO reqDto,
			@PathVariable(name = "id") long id) {
		PublicationDTO res = publicationsService.updatePublication(reqDto, id);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}


	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePublication(@PathVariable(name = "id") long id) {
		this.publicationsService.deletePublication(id);

		return new ResponseEntity<>("BORRADO.CORRECTO", HttpStatus.OK);

	}

}
