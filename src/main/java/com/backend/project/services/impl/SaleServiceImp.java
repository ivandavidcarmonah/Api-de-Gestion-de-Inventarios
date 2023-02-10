package com.backend.project.services.impl;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.backend.project.DTO.SaleDTOs.SaleDTO;
import com.backend.project.DTO.SaleDTOs.SaleProductDTO;
import com.backend.project.DTO.SaleDTOs.SaleResponseDTO;
import com.backend.project.entities.ProductEntity;
import com.backend.project.entities.SaleDetailEntity;
import com.backend.project.entities.SaleEntity;
import com.backend.project.entities.UserEntity;
import com.backend.project.exceptions.ResourceNotFoundException;
import com.backend.project.repositories.ProductRepository;
import com.backend.project.repositories.SaleDetailRepository;
import com.backend.project.repositories.SaleRepository;
import com.backend.project.repositories.UserRepository;
import com.backend.project.services.SaleService;

@Service
public class SaleServiceImp implements SaleService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SaleDetailRepository saleDetailRepository; 
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public SaleResponseDTO createSale(SaleProductDTO saleDTO) {
		
		/**
		 * Obtener listado de productos seleccionados para la venta
		 */
		List<ProductEntity> products = this.buscarProducts(saleDTO.getProducts());
		
		/**
		 * Generar el detalle de la venta SaleDetailEntity
		 */
		SaleDetailEntity detailEntity = new SaleDetailEntity();
		detailEntity.setProduct(products);
		detailEntity.generarTotal(products);
		this.saleDetailRepository.save(detailEntity);
		/**
		 * Generar la cabecera de la venta SaleEntity
		 */
		SaleEntity saleEntity = new SaleEntity();
		saleEntity.setClienteId(2);
		saleEntity.setEstado("Terminado");
		saleEntity.setTotal(0);
		
		String principal = SecurityContextHolder.getContext().getAuthentication().getName();
		UserEntity user = this.userRepository.findByEmail(principal).orElseThrow(() -> new ResourceNotFoundException("Users", "email", principal));
		saleEntity.setUser(user);
		
		saleEntity.setSaleDetail(detailEntity);
		
		SaleResponseDTO saleResponseDTO = new SaleResponseDTO();
		saleResponseDTO.setSaleDTO(this.mapEntidad(this.repository.save(saleEntity)));
		
		
		return saleResponseDTO;
	}
	
	private List<ProductEntity> buscarProducts(List<Integer> Ids) {
		List<ProductEntity> products = new ArrayList<>();
		for (int i = 0; i < Ids.size(); i++) {
			ProductEntity element = this.productRepository.findById((long) Ids.get(i))
					.orElseThrow(() -> new ResourceNotFoundException("Product", "id", "i"));
			
			if (element != null) {
				products.add(element);
			}
		}
		
		return products;
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
