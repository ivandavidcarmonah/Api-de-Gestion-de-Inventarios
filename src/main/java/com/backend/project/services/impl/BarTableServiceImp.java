package com.backend.project.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.project.DTO.BarTableDTOs.BarTableDTO;
import com.backend.project.DTO.BarTableDTOs.BarTableListDTO;
import com.backend.project.DTO.Company.CompanyDTO;
import com.backend.project.entities.BarTableEntity;
import com.backend.project.entities.CompanyEntity;
import com.backend.project.repositories.BarTableRepository;
import com.backend.project.services.BarTableService;

@Service
public class BarTableServiceImp implements BarTableService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private BarTableRepository bartableRepository;

	/**
	 * Metodo para crear un producto si el idProduct es 0 o actualizarlo si es != de 0
	 */
	public BarTableListDTO createUpdateBarTable(BarTableListDTO dto) {
		if(dto.getIdBarTable() == 0)
			dto.setCreaDate(new Date());
		else
			dto.setModDate(new Date());
			
		return mapDTO1(this.bartableRepository.save(this.mapEntitie(this.mapDTO2(dto))));
	}

	/**
	 * Metodo para eliminar un producto por su idProduct
	 */
	public void deleteBarTable(long idBarTable) {
		this.bartableRepository.deleteById(idBarTable);
	}
	
	/**
	 * Metodo para obtener el objeto entero
	 */
	public List<BarTableDTO> getAllBarTableByIdcompany(long idCompany) {
		List<BarTableDTO> listBarTableDto = new ArrayList<BarTableDTO>();
		List<BarTableEntity> barTable = this.bartableRepository.findAllByCompany(new CompanyEntity(idCompany));

		if(!barTable.isEmpty()) {
			for (int i = 0; i < barTable.size(); i++) {
				listBarTableDto.add(this.mapDTO(barTable.get(i)));
			}
		}		
		return listBarTableDto;
	}
	
	/**
	 * Metodo para obtener el objeto simplificado para el usuario
	 */
	public List<BarTableListDTO> getListBarTableByIdcompany(long idCompany) {
		List<BarTableListDTO> listBarTableDto = new ArrayList<BarTableListDTO>();
		List<BarTableEntity> barTable = this.bartableRepository.findAllByCompany(new CompanyEntity(idCompany));

		//si hay mesas del bar, se setean para devolver solo lo necesario
		if(!barTable.isEmpty()) {
			for (int i = 0; i < barTable.size(); i++) {
				listBarTableDto.add(mapDTO1(barTable.get(i)));
			}
		}		
		return listBarTableDto;
	}

	/**
	 * Metodo para formatear y devolver solo lo necesario
	 * Mapear desde un Entidad -> DTO
	 * @param entity
	 * @return
	 */
	private BarTableListDTO mapDTO1(BarTableEntity entity) {
		BarTableListDTO dto = new BarTableListDTO();
		dto.setCodeQR(entity.getCodeQR());
		dto.setCreaDate(entity.getCreaDate());
		dto.setCreaUser(entity.getCreaUser());
		dto.setIdBarTable(entity.getIdBarTable());
		dto.setIdCompany(entity.getCompany().getIdCompany());
		dto.setModDate(entity.getModDate());
		dto.setModUser(entity.getModUser());
		dto.setNumTable(entity.getNumTable());
		dto.setPlace(entity.getPlace());
		return dto;
	}
	
	/**
	 * Mapear desde un DTO -> DTO
	 * @param item
	 * @return
	 */
	private BarTableDTO mapDTO2(BarTableListDTO item) {
		BarTableDTO obj = new BarTableDTO();
		obj.setCodeQR(item.getCodeQR());
		obj.setCreaDate(item.getCreaDate());
		obj.setCreaUser(item.getCreaUser());
		obj.setIdBarTable(item.getIdBarTable());
		obj.setCompany(new CompanyDTO(item.getIdCompany()));
		obj.setModDate(item.getModDate());
		obj.setModUser(item.getModUser());
		obj.setNumTable(item.getNumTable());
		obj.setPlace(item.getPlace());
		return obj;
	}
	
	/**
	 * Mapear desde un DTO -> Entidad
	 * 
	 * @param dto
	 * @return
	 */
	private BarTableDTO mapDTO(BarTableEntity productEntity) {
		return this.modelMapper.map(productEntity, BarTableDTO.class);
	}

	/**
	 * Mapear desde Entidad -> DTO
	 * 
	 * @param dto
	 * @return
	 */
	private BarTableEntity mapEntitie(BarTableDTO dto) {
		return this.modelMapper.map(dto, BarTableEntity.class);
	}

}
