package com.backend.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.project.DTO.MasterDataDTOs.GenderDTO;
import com.backend.project.DTO.MasterDataDTOs.LanguageDTO;
import com.backend.project.services.impl.MasterDataServiceImp;

@RestController
@RequestMapping("/api/master-data")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.OPTIONS})
public class MasterDataController {

	@Autowired
	private MasterDataServiceImp masterDataService;
	
	@GetMapping("/genders")
	public List<GenderDTO> getGenders() {
		return this.masterDataService.getGenders();
	}
	
	@GetMapping("/languages")
	public List<LanguageDTO> getLanguages() {
		return this.masterDataService.getLanguages();
	}

}
