package com.backend.project.services;

import com.backend.project.DTO.PublicationDTOs.PublicationDTO;
import com.backend.project.DTO.PublicationDTOs.PublicationResponseDTO;

public interface PublicationService {

	public PublicationDTO createPublication(PublicationDTO dto);

	public PublicationResponseDTO getPublications(int numberPage, int pageSize, String orderBy, String sortDir);

	public PublicationDTO getPublicationsById(long id);

	public PublicationDTO updatePublication(PublicationDTO reqDto, long id);

	public void deletePublication(long id);
}
