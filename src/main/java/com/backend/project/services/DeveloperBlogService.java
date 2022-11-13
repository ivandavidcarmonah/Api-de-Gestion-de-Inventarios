package com.backend.project.services;

import com.backend.project.DTO.DeveloperBlogDTOs.DeveloperBlogDTO;
import com.backend.project.DTO.DeveloperBlogDTOs.DeveloperBlogResponseDTO;

public interface DeveloperBlogService {

	public DeveloperBlogDTO createPublication(DeveloperBlogDTO dto);

	public DeveloperBlogResponseDTO getPublications(int numberPage, int pageSize, String orderBy, String sortDir);

	public DeveloperBlogDTO getPublicationsById(long id);

	public DeveloperBlogDTO updatePublication(DeveloperBlogDTO reqDto, long id);

	public void deletePublication(long id);

	DeveloperBlogDTO updateImagenBlogHeaderDTODto(String fileName, long id);

	DeveloperBlogDTO updateImagenBlogBodyDTODto(String fileName, long id);
}
