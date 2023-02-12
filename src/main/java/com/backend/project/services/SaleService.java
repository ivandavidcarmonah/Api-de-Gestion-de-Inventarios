package com.backend.project.services;


import com.backend.project.DTO.SaleDTOs.SaleDTO;
import com.backend.project.DTO.SaleDTOs.SaleProductDTO;
import com.backend.project.DTO.SaleDTOs.SaleResponseDTO;

public interface SaleService {

	
	public SaleDTO createSale(SaleProductDTO saleDTO);
	public SaleDTO getSaleById(Long  id);
	
	
}
