package com.backend.project.services;


import com.backend.project.DTO.ProductDTOs.ProductDTO;
import com.backend.project.DTO.ProductDTOs.ProductResponseDTO;
import com.backend.project.DTO.ProductDTOs.RegisterProductDTO;
import com.backend.project.DTO.UserDTOs.UserResponseDTO;

public interface ProductService {

	public ProductDTO createUpdateProducto(RegisterProductDTO dto);
	public void deleteProduct(long idProdcut);
	public ProductResponseDTO getAllProducts();
	
	public ProductResponseDTO getAllProducts(int numberPage, int pageSize, String orderBy, String sortDir);

	
	public ProductDTO getProductId(long id);

}
