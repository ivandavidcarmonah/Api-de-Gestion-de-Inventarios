package com.backend.project.services;


import com.backend.project.DTO.SaleDTOs.SaleProductDTO;
import com.backend.project.DTO.SaleDTOs.SaleResponseDTO;

public interface SaleService {

	
	public SaleResponseDTO createSale(SaleProductDTO saleDTO);
	
	
}
