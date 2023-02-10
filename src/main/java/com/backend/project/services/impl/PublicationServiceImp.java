package com.backend.project.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.backend.project.DTO.PublicationDTOs.PublicationDTO;
import com.backend.project.DTO.PublicationDTOs.PublicationResponseDTO;
import com.backend.project.entities.PublicationsEntity;
import com.backend.project.exceptions.ResourceNotFoundException;
import com.backend.project.repositories.PublicationsRepository;
import com.backend.project.services.PublicationService;

@Service
public class PublicationServiceImp extends AuditModel implements PublicationService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PublicationsRepository publicationRepository;

	@Override
	public PublicationDTO createPublication(PublicationDTO dto) {
		// Convert DTO to Entities
		PublicationsEntity publication = this.mapEntitie(dto);
		PublicationsEntity newPublication = this.publicationRepository.save(publication);
		
		// Convert entities to DTO
		PublicationDTO resDto = mapDTO(newPublication);
		return resDto;
	}

	private Object currentUser() {
		// TODO Auto-generated method stub
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	}


	@Override
	public PublicationResponseDTO getPublications(int numberPage, int pageSize, String orderBy, String sortDir) {
		// TODO Auto-generated method stub
		System.out.print(this.currentUser());
		Sort sort = sortDir.equalsIgnoreCase( Sort.Direction.ASC.name()) ? Sort.by(orderBy).ascending() : Sort.by(orderBy).descending(); 
		Pageable pageable = PageRequest.of(numberPage, pageSize, sort);
		Page<PublicationsEntity> publications = this.publicationRepository.findAll(pageable);

		List<PublicationsEntity> values = publications.getContent();
		List<PublicationDTO> publicacionDto = values.stream().map(publicacion -> mapDTO(publicacion))
				.collect(Collectors.toList());

		PublicationResponseDTO publicationResponseDTO = new PublicationResponseDTO();
		publicationResponseDTO.setDataList(publicacionDto);

		publicationResponseDTO.setNumberPage(publications.getNumber());
		publicationResponseDTO.setSizePage(publications.getSize());

		publicationResponseDTO.setDataLength(publications.getNumberOfElements());
		publicationResponseDTO.setTotalPages(publications.getTotalPages());
		publicationResponseDTO.setLastPage(publications.isLast());

		return publicationResponseDTO;
	}

	@Override
	public PublicationDTO getPublicationsById(long id) {
		// TODO Auto-generated method stub
		PublicationsEntity publications = this.publicationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Publications", "id", id));
		return mapDTO(publications);
	}

	@Override
	public PublicationDTO updatePublication(PublicationDTO reqDto, long id) {
		PublicationsEntity publication = this.publicationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Publications", "id", id));

		publication.setContent(reqDto.getContent());
		publication.setDescription(reqDto.getDescription());
		publication.setTitle(reqDto.getTitle());

		PublicationsEntity publicationSave = this.publicationRepository.save(publication);

		return mapDTO(publicationSave);
	}

	@Override
	public void deletePublication(long id) {

		PublicationsEntity publications = this.publicationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Publications", "id", id));
		this.publicationRepository.delete(publications);
	}
	
	
	/**
	 * Mapear desde un DTO -> Entidad
	 * 
	 * @param dto
	 * @return
	 */
	private PublicationDTO mapDTO(PublicationsEntity publication) {
		PublicationDTO publicationDTO = this.modelMapper.map(publication, PublicationDTO.class);
		return publicationDTO;
	}

	/**
	 * Mapear desde Entidad -> DTO
	 * 
	 * @param dto
	 * @return
	 */
	private PublicationsEntity mapEntitie(PublicationDTO dto) {
		PublicationsEntity publication = this.modelMapper.map(dto, PublicationsEntity.class);
		return publication;
	}



}
