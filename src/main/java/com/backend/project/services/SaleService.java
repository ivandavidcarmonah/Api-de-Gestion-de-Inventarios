package com.backend.project.services;


import com.backend.project.DTO.SaleDTOs.SaleDTO;
import com.backend.project.DTO.SaleDTOs.SaleResponseDTO;
import com.backend.project.DTO.UserDTOs.UserDTO;
import com.backend.project.DTO.UserDTOs.UserDetailDTO;
import com.backend.project.DTO.UserDTOs.UserResponseDTO;
import com.backend.project.DTO.UserDTOs.UserUpdateDTO;

public interface SaleService {

	
	public SaleResponseDTO createSale(SaleDTO saleDTO);
	
	
}
