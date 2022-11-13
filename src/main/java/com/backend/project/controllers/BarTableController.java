package com.backend.project.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.project.DTO.BarTableDTOs.BarTableDTO;
import com.backend.project.DTO.BarTableDTOs.BarTableListDTO;
import com.backend.project.services.BarTableService;


@RestController 
@RequestMapping( "/api/bartable")
@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET})
public class BarTableController {

	
	@Autowired
	private BarTableService barTableService ;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create-update")
	public ResponseEntity <BarTableListDTO> newBartable(@Valid @RequestBody BarTableListDTO barTableDTO){
		return new ResponseEntity<>(this.barTableService.createUpdateBarTable(barTableDTO), HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/delete/{idBarTable}")
	public ResponseEntity<String> deleteBarTable(@Valid @PathVariable(name = "idBarTable") long idBarTable) {
		this.barTableService.deleteBarTable(idBarTable);
		return new ResponseEntity<>("BORRADO.CORRECTO", HttpStatus.OK);
	}
	
	/**
	 * Metodo para obtener todo el detalle de las mesas del bar
	 * @param idCompany
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/getbartablesbyidcompany/{idCompany}")
	public List<BarTableDTO> getBarTableByIdCompany(@Valid @PathVariable(name = "idCompany") long idCompany){
		return this.barTableService.getAllBarTableByIdcompany(idCompany);
	}
	
	/**
	 * Metodo para obtener todo el listado de las mesas con solo los datos necesarios
	 * @param idCompany
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/getlistbartablesbyidcompany/{idCompany}")
	public List<BarTableListDTO> getListBarTableByIdCompany(@Valid @PathVariable(name = "idCompany") long idCompany){
		return this.barTableService.getListBarTableByIdcompany(idCompany);
	}
	
}
