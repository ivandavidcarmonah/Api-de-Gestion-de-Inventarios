package com.backend.project.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.backend.project.DTO.MasterDataDTOs.GenderDTO;
import com.backend.project.DTO.MasterDataDTOs.LanguageDTO;
import com.backend.project.DTO.PublicationDTOs.PublicationDTO;
import com.backend.project.DTO.PublicationDTOs.PublicationResponseDTO;
import com.backend.project.entities.GenderEntity;
import com.backend.project.entities.LanguageEntity;
import com.backend.project.entities.PublicationsEntity;
import com.backend.project.exceptions.ResourceNotFoundException;
import com.backend.project.repositories.GenderRepository;
import com.backend.project.repositories.LanguageRepository;
import com.backend.project.repositories.PublicationsRepository;
import com.backend.project.services.PublicationService;

@Service
public class MasterDataServiceImp  {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private GenderRepository genderRepository;

	@Autowired
	private LanguageRepository languageRepository;
	
	
	public List<GenderDTO> getGenders() {

		List<GenderEntity> list= this.genderRepository.findAll();
		List<GenderDTO> listDto = new ArrayList<GenderDTO>();
		
		/**Convertir listado de enditad a listado de DTO*/
		for (GenderEntity element : list) {
			listDto.add(this.mapEntitie(element));
		}
		
		return listDto;
	}

	public List<LanguageDTO> getLanguages() {

		List<LanguageEntity> list= this.languageRepository.findAll();
		List<LanguageDTO> listDto = new ArrayList<LanguageDTO>();
		
		/**Convertir listado de enditad a listado de DTO*/
		for (LanguageEntity element : list) {
			listDto.add(this.mapEntitie(element));
		}
		
		return listDto;
	}


	/**
	 * Mapear desde un Entidad -> DTO
	 * 
	 * @param entity
	 * @return DTO
	 */
	private GenderDTO mapEntitie(GenderEntity entity) {
		GenderDTO dto = this.modelMapper.map(entity, GenderDTO.class);
		return dto;
	}

	/**
	 * Mapear desde un Entidad -> DTO
	 * 
	 * @param entity
	 * @return DTO
	 */
	private LanguageDTO mapEntitie(LanguageEntity entity) {
		LanguageDTO dto = this.modelMapper.map(entity, LanguageDTO.class);
		return dto;
	}


}
