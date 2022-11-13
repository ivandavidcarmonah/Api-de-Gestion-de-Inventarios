package com.backend.project.services;

import java.util.List;

import com.backend.project.DTO.PublicationDTOs.ComentsDTO;

public interface ComentPublicationService {

	
	
	public ComentsDTO newComent(long idPublication, ComentsDTO comentDTO);
	
	public List<ComentsDTO> getListComents(long idPublication);

	
}
