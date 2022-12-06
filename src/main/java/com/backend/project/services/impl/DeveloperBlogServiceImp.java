package com.backend.project.services.impl;


import java.io.File;
import java.time.LocalDateTime;
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

import com.backend.project.DTO.DeveloperBlogDTOs.DeveloperBlogDTO;
import com.backend.project.DTO.DeveloperBlogDTOs.DeveloperBlogResponseDTO;
import com.backend.project.entities.DeveloperBlogEntity;
import com.backend.project.exceptions.ResourceNotFoundException;
import com.backend.project.repositories.DeveloperBlogRepository;
import com.backend.project.services.DeveloperBlogService;
import com.backend.project.utils.AppConstants;

@Service
public class DeveloperBlogServiceImp extends AuditModel implements DeveloperBlogService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private DeveloperBlogRepository developerBlogRepository;

	@Override
	public DeveloperBlogDTO createPublication(DeveloperBlogDTO dto) {
		// Convert DTO to Entities
		System.out.print(this.currentUser());
		
		DeveloperBlogEntity publication = this.mapEntitie(dto);
		
		
		publication.setCreation_date(LocalDateTime.now());
		publication.setUpdate_date(LocalDateTime.now());
		publication.setCreated_by("1");
		publication.setUpdate_by("1");
		DeveloperBlogEntity newPublication = this.developerBlogRepository.save(publication);
		
		// Convert entities to DTO
		DeveloperBlogDTO resDto = mapDTO(newPublication);
		return resDto;
	}

	private Object currentUser() {
		// TODO Auto-generated method stub
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	}


	@Override
	public DeveloperBlogResponseDTO getPublications(int numberPage, int pageSize, String orderBy, String sortDir) {
		// TODO Auto-generated method stub
		System.out.print(this.currentUser());
		Sort sort = sortDir.equalsIgnoreCase( Sort.Direction.ASC.name()) ? Sort.by(orderBy).ascending() : Sort.by(orderBy).descending(); 
		Pageable pageable = PageRequest.of(numberPage, pageSize, sort);
		Page<DeveloperBlogEntity> publications = this.developerBlogRepository.findAll(pageable);

		List<DeveloperBlogEntity> values = publications.getContent();
		List<DeveloperBlogDTO> publicacionDto = values.stream().map(publicacion -> mapDTO(publicacion))
				.collect(Collectors.toList());

		DeveloperBlogResponseDTO publicationResponseDTO = new DeveloperBlogResponseDTO();
		publicationResponseDTO.setDataList(publicacionDto);

		publicationResponseDTO.setNumberPage(publications.getNumber());
		publicationResponseDTO.setSizePage(publications.getSize());

		publicationResponseDTO.setDataLength(publications.getNumberOfElements());
		publicationResponseDTO.setTotalPages(publications.getTotalPages());
		publicationResponseDTO.setLastPage(publications.isLast());

		return publicationResponseDTO;
	}

	@Override
	public DeveloperBlogDTO getPublicationsById(long id) {
		// TODO Auto-generated method stub
		DeveloperBlogEntity publications = this.developerBlogRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("DeveloperBlog", "id", id));
		return mapDTO(publications);
	}

	@Override
	public DeveloperBlogDTO updatePublication(DeveloperBlogDTO reqDto, long id) {
		DeveloperBlogEntity publication = this.developerBlogRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Publications", "id", id));

		publication.setContent(reqDto.getContent());
		publication.setDescription(reqDto.getDescription());
		publication.setTitle(reqDto.getTitle());
		publication.setUpdate_date(LocalDateTime.now());
		//Falta Setear el user que actualizo
		DeveloperBlogEntity publicationSave = this.developerBlogRepository.save(publication);

		return mapDTO(publicationSave);
	}
	
	@Override
	public DeveloperBlogDTO updateImagenBlogBodyDTODto(String fileName, long id) {
		DeveloperBlogEntity element = this.developerBlogRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Publications", "id", id));

		/**
		 * Eliminar imagen si existe
		 */
		if (element.getImagenBody().length() > 0) {
			File fichero = new File(AppConstants.DEVELOPER_BLOG_DIR + element.getImagenBody());
			if (fichero.delete())
				   System.out.println("El fichero ha sido borrado satisfactoriamente");
				else
				   System.out.println("El fichero no puede ser borrado");
		}
		element.setUpdate_date(LocalDateTime.now());
		element.setImagenBody(fileName);
		DeveloperBlogEntity elementEntity = this.developerBlogRepository.save(element);

		return mapDTO(elementEntity);
	}
	
	@Override
	public DeveloperBlogDTO updateImagenBlogHeaderDTODto(String fileName, long id) {
		DeveloperBlogEntity element = this.developerBlogRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Publications", "id", id));
		/**
		 * Eliminar imagen si existe
		 */
		if (element.getImagenHeader().length() > 0) {
			File fichero = new File(AppConstants.DEVELOPER_BLOG_DIR + element.getImagenHeader());
			if (fichero.delete())
				   System.out.println("El fichero ha sido borrado satisfactoriamente");
				else
				   System.out.println("El fichero no puede ser borrado");
		}
		
		
		element.setUpdate_date(LocalDateTime.now());
		element.setImagenHeader(fileName);
		DeveloperBlogEntity elementEntity = this.developerBlogRepository.save(element);

		return mapDTO(elementEntity);
	}

	@Override
	public void deletePublication(long id) {

		DeveloperBlogEntity publications = this.developerBlogRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Publications", "id", id));
		this.developerBlogRepository.delete(publications);
	}
	
	
	/**
	 * Mapear desde un DTO -> Entidad
	 * 
	 * @param dto
	 * @return
	 */
	private DeveloperBlogDTO mapDTO(DeveloperBlogEntity entity) {
		DeveloperBlogDTO value = this.modelMapper.map(entity, DeveloperBlogDTO.class);
		return value;
	}

	/**
	 * Mapear desde Entidad -> DTO
	 * 
	 * @param dto
	 * @return
	 */
	private DeveloperBlogEntity mapEntitie(DeveloperBlogDTO dto) {
		DeveloperBlogEntity value = this.modelMapper.map(dto, DeveloperBlogEntity.class);
		return value;
	}



}
