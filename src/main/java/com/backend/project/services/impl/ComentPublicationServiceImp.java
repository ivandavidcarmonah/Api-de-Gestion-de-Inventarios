package com.backend.project.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.project.DTO.PublicationDTOs.ComentsDTO;
import com.backend.project.entities.ComentsPublication;
import com.backend.project.entities.PublicationsEntity;
import com.backend.project.exceptions.ResourceNotFoundException;
import com.backend.project.repositories.ComentsPublicationRepository;
import com.backend.project.repositories.PublicationsRepository;
import com.backend.project.services.ComentPublicationService;

@Service
public class ComentPublicationServiceImp implements ComentPublicationService{

	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PublicationsRepository publicationRepository;
	@Autowired
	private ComentsPublicationRepository comentsPublicationRepository;
	
	@Override
	public ComentsDTO newComent(long idPublication, ComentsDTO comentDTO) {
		// TODO Auto-generated method stub
		ComentsPublication comentsPublication = mappEntitie(comentDTO);
		PublicationsEntity publications = this.publicationRepository.findById(idPublication)
				.orElseThrow(() -> new ResourceNotFoundException("Publications", "id", idPublication));
		
		comentsPublication.setPublication(publications);
		
		ComentsPublication newComent = this.comentsPublicationRepository.save(comentsPublication);
		
		return mappDTO(newComent);
	}
	
	@Override
	public List<ComentsDTO> getListComents(long idPublication) {
		// TODO Auto-generated method stub
		List<ComentsPublication> comentsPublications  = this.comentsPublicationRepository.findByPublicationId(idPublication);
		
		return comentsPublications.stream().map( coment -> mappDTO(coment)).collect(Collectors.toList());
	}
	
	private ComentsDTO  mappDTO(ComentsPublication value) {
		ComentsDTO comentDTO = this.modelMapper.map(value, ComentsDTO.class);
		return comentDTO;
	}
	
	private ComentsPublication  mappEntitie(ComentsDTO  dto) {
		ComentsPublication comentsPublication = this.modelMapper.map(dto, ComentsPublication.class);
		return comentsPublication;
	}

}
