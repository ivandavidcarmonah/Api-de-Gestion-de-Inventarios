package com.backend.project.services.impl;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.backend.project.DTO.SaleDTOs.InvoceLineDTO;
import com.backend.project.DTO.SaleDTOs.SaleDTO;
import com.backend.project.DTO.SaleDTOs.SaleProductDTO;
import com.backend.project.DTO.SaleDTOs.SaleResponseDTO;
import com.backend.project.entities.InvoiceLineEntity;
import com.backend.project.entities.ProductEntity;
import com.backend.project.entities.SaleEntity;
import com.backend.project.entities.UserEntity;
import com.backend.project.exceptions.ResourceNotFoundException;
import com.backend.project.repositories.InvoiceLineRepository;
import com.backend.project.repositories.ProductRepository;
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
	private InvoiceLineRepository invoiceLineRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public SaleDTO createSale(SaleProductDTO saleDTO) {
		
		/**
		 * Obtener listado de productos seleccionados para la venta
		 */
		List<ProductEntity> products = this.buscarProducts(saleDTO.getProducts());
		
		Set<InvoiceLineEntity> invoiceLines = new HashSet<InvoiceLineEntity>();
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
		
		
		/**
		 * Generar el detalle de la venta SaleDetailEntity
		 */
		int i = 0;
		while (products.size() > 0) {
			InvoiceLineEntity lineEntity = new InvoiceLineEntity();
			int cantidad = 0;
			lineEntity.setPrice(products.get(i).getPrice());
			lineEntity.setProduct(products.get(i).getName());
			List<ProductEntity> element = new ArrayList<>();
			for (int j = 0; j < products.size(); j++) {
				if (products.get(i).getId() == products.get(j).getId()) {
					element.add(products.get(j));
					cantidad = cantidad+1;
				}
			}
			lineEntity.setQuantity(cantidad);
			
			invoiceLines.add(this.invoiceLineRepository.save(lineEntity)) ;
			products.removeAll(element);
			
		}
		saleEntity.setInvoiceLines(invoiceLines);
		SaleEntity entity = this.repository.save(saleEntity);
		
		SaleDTO saleResponseDTO = new SaleDTO();
		saleResponseDTO = this.mapEntidad(entity);

		Set<InvoceLineDTO> invoiceLine = new HashSet<InvoceLineDTO>();
		entity.getInvoiceLines().forEach(element -> {
			invoiceLine.add(this.mapEntidad(element));
		});
		saleResponseDTO.setInvoiceLine(invoiceLine);
		
		return saleResponseDTO;
	}
	
	public SaleDTO getSaleById(Long id) {
		
		SaleEntity entity = this.repository.findById(id)
	    		 .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		Set<InvoceLineDTO> invoiceLine = new HashSet<InvoceLineDTO>();
		entity.getInvoiceLines().forEach(element -> {
			invoiceLine.add(this.mapEntidad(element));
		});
		
		SaleDTO dto = new SaleDTO();
		dto =  this.mapEntidad(entity);
		dto.setInvoiceLine(invoiceLine);
		
		return dto;
	
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
	
	private InvoceLineDTO mapEntidad(InvoiceLineEntity entidad) {
		InvoceLineDTO dto = this.modelMapper.map(entidad, InvoceLineDTO.class);
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
