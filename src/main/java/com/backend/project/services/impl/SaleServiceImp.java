package com.backend.project.services.impl;


import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.project.DTO.SaleDTOs.SaleDTO;
import com.backend.project.DTO.SaleDTOs.SaleResponseDTO;
import com.backend.project.entities.SaleEntity;
import com.backend.project.repositories.SaleRepository;
import com.backend.project.services.SaleService;

@Service
public class SaleServiceImp implements SaleService {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private SaleRepository repository;
	
	@Override
	public SaleResponseDTO createSale(SaleDTO saleDTO) {
		SaleEntity entity = new SaleEntity();
		entity.setCreation_date(LocalDateTime.now());

		entity = this.mapDTO(saleDTO);
		this.repository.save(entity);
		SaleEntity saleResponseEntity = this.repository.save(entity);
		SaleDTO saleDto = this.mapEntidad(saleResponseEntity);
		
		return new SaleResponseDTO(saleDto);
	}
	
	
	
	
	/**
	 * Mapear desde una Entidad -> DTO
	 * 
	 * @param SaleEntity
	 * @return SaleDTO
	 */
	private SaleDTO mapEntidad(SaleEntity entidad) {
		SaleDTO dto = this.modelMapper.map(entidad, SaleDTO.class);
		return dto;
	}
	
	
	/**
	 * Mapear desde una DTO -> Entidad
	 * 
	 * @param SaleDTO
	 * @return SaleEntity
	 */
	private SaleEntity mapDTO(SaleDTO dto) {
		SaleEntity entidad = this.modelMapper.map(dto, SaleEntity.class);
		return entidad;
	}
	
	
	

	


}
