package com.backend.project.controllers;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.MultipartFile;

import com.backend.project.DTO.ProductDTOs.ProductDTO;
import com.backend.project.DTO.ProductDTOs.ProductResponseDTO;
import com.backend.project.DTO.ProductDTOs.RegisterProductDTO;
import com.backend.project.DTO.SaleDTOs.SaleDTO;
import com.backend.project.DTO.SaleDTOs.SaleProductDTO;
import com.backend.project.repositories.ProductRepository;
import com.backend.project.services.ProductService;
import com.backend.project.services.SaleService;
import com.backend.project.utils.AppConstants;
import com.backend.project.utils.FileUploadUtil;


@RestController 
@RequestMapping( "/api/sale")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class SaleController {

	
	
	@Autowired
	private SaleService service ;

	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/new-sale")
	public ResponseEntity<?> newSale(@Valid @RequestBody SaleProductDTO products){
		return new ResponseEntity<>(this.service.createSale(products), HttpStatus.ACCEPTED);
	}

	@PreAuthorize("hasRole('ROLE_SUPER_ROOT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EDITOR') or hasRole('ROLE_VISITANTE')")
	@GetMapping("/list-products")
	public ProductResponseDTO getSales(@Valid
			@RequestParam(name = "numberPage", defaultValue = "0", required = false) int numberPage,
			@RequestParam(name = "pageSize", defaultValue = "10", required = false) int pageSize,
			@RequestParam(name = "orderBy", defaultValue = "id", required = false) String orderBy,
			@RequestParam(name = "sortDir", defaultValue = "des", required = false) String sortDir) {

		return null;
	}
	
}
