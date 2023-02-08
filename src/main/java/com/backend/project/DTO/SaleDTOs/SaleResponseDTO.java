package com.backend.project.DTO.SaleDTOs;


public class SaleResponseDTO {

	private SaleDTO saleDTO;

	public SaleResponseDTO(SaleDTO saleDTO) {
		super();
		this.saleDTO = saleDTO;
	}

	public SaleDTO getSaleDTO() {
		return saleDTO;
	}

	public void setSaleDTO(SaleDTO saleDTO) {
		this.saleDTO = saleDTO;
	}
	
	
	

	
}
