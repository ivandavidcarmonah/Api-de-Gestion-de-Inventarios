package com.backend.project.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.backend.project.DTO.ProductDTOs.ProductDTO;
import com.backend.project.DTO.ProductDTOs.ProductResponseDTO;
import com.backend.project.entities.CompanyEntity;
import com.backend.project.entities.ProductEntity;
import com.backend.project.repositories.ProductRepository;
import com.backend.project.services.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProductRepository productRepository;

	/**
	 * Metodo para crear un producto si el idProduct es 0 o actualizarlo si es != de 0
	 */
	public ProductDTO createUpdateProducto(ProductDTO dto) {
		if(dto.getIdProduct() != 0)
			dto.setModDate(new Date());
		else
			dto.setCreaDate(new Date());
			
		return mapDTO(this.productRepository.save(this.mapEntitie(dto)));
	}

	/**
	 * Metodo para eliminar un producto por su idProduct
	 */
	public void deleteProduct(long idProdcut) {
		this.productRepository.deleteById(idProdcut);
	}
	
	public List<ProductDTO> getAllProducts(){
		List<ProductDTO> listProductsDto = new ArrayList<ProductDTO>();
		List<ProductEntity> products = this.productRepository.findAll();
		if(!products.isEmpty()) {
			for (int i = 0; i < products.size(); i++) {
				listProductsDto.add(this.mapDTO(products.get(i)));
			}
		}		
		return listProductsDto;		
	}
	
	public List<ProductDTO> getAllProductsByIdcompany(long idCompany) {
		List<ProductDTO> listProductsDto = new ArrayList<ProductDTO>();
		List<ProductEntity> products = this.productRepository.findAllByCompany(idCompany);

		if(!products.isEmpty()) {
			for (int i = 0; i < products.size(); i++) {
				listProductsDto.add(this.mapDTO(products.get(i)));
			}
		}		
		return listProductsDto;
	}
	
	/**
	 * Devolver el listado ordenada
	 */
	public ProductResponseDTO getAllProductsByIdcompany(long idCompany, int numberPage, int pageSize, String orderBy, String sortDir) {
		// TODO Auto-generated method stub
		Sort sort = sortDir.equalsIgnoreCase( Sort.Direction.ASC.name()) ? Sort.by(orderBy).ascending() : Sort.by(orderBy).descending(); 
		Pageable pageable = PageRequest.of(numberPage, pageSize, sort);
		Page<ProductEntity> products = this.productRepository.findAllByCompany(new CompanyEntity(idCompany), pageable);
		List<ProductEntity> values = products.getContent();
		List<ProductDTO> productDto = values.stream().map(element -> mapDTO(element))
				.collect(Collectors.toList());

		ProductResponseDTO productResponseDTO = new ProductResponseDTO();
		productResponseDTO.setDataList(productDto);

		productResponseDTO.setNumberPage(products.getNumber());
		productResponseDTO.setSizePage(products.getSize());

		productResponseDTO.setDataLength(products.getNumberOfElements());
		productResponseDTO.setTotalPages(products.getTotalPages());
		productResponseDTO.setLastPage(products.isLast());

		return productResponseDTO;
	}

	/**
	 * Mapear desde un Entity -> DTO
	 * 
	 * @param dto
	 * @return
	 */
	@SuppressWarnings("unused")
	private ProductDTO mapVistaDTOV(ProductEntity productEntity) {
		return this.modelMapper.map(productEntity, ProductDTO.class);
	}
	
	/**
	 * Mapear desde un DTO -> Entidad
	 * 
	 * @param dto
	 * @return
	 */
	private ProductDTO mapDTO(ProductEntity productEntity) {
		return this.modelMapper.map(productEntity, ProductDTO.class);
	}

	/**
	 * Mapear desde Entidad -> DTO
	 * 
	 * @param dto
	 * @return
	 */
	private ProductEntity mapEntitie(ProductDTO dto) {
		return this.modelMapper.map(dto, ProductEntity.class);
	}

}
