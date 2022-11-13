package com.backend.project.services;

import java.util.List;

import com.backend.project.DTO.ProductDTOs.ProductDTO;
import com.backend.project.DTO.ProductDTOs.ProductResponseDTO;

public interface ProductService {

	public ProductDTO createUpdateProducto(ProductDTO dto);
	public void deleteProduct(long idProdcut);
	public List<ProductDTO> getAllProducts();
	public List<ProductDTO> getAllProductsByIdcompany(long idCompany);
	public ProductResponseDTO getAllProductsByIdcompany(long idCompany, int numberPage, int pageSize, String orderBy, String sortDir);
}
