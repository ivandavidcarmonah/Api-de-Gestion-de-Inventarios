package com.backend.project.services;

import java.util.List;

import com.backend.project.DTO.BarTableDTOs.BarTableDTO;
import com.backend.project.DTO.BarTableDTOs.BarTableListDTO;

public interface BarTableService {

	public BarTableListDTO createUpdateBarTable(BarTableListDTO dto);
	public void deleteBarTable(long idBarTable);
	public List<BarTableDTO> getAllBarTableByIdcompany(long idCompany);
	public List<BarTableListDTO> getListBarTableByIdcompany(long idCompany);
}
