package com.backend.project.services;


import com.backend.project.DTO.ProductDTOs.ProductDTO;
import com.backend.project.DTO.ProductDTOs.ProductResponseDTO;
import com.backend.project.DTO.ProductDTOs.RegisterProductDTO;
import com.backend.project.DTO.UserDTOs.UserResponseDTO;

public interface ProductService {

	public ProductDTO createUpdateProducto(RegisterProductDTO dto);
	
	public ProductDTO updateProduct(ProductDTO dto);

	public void deleteProduct(long idProdcut);
	public ProductResponseDTO getAllProducts();
	
	public ProductResponseDTO getAllProducts(int numberPage, int pageSize, String orderBy, String sortDir);

	
	public ProductDTO getProductId(long id);

	public void delete(long id);

	public ProductDTO getById(long id);

	public ProductDTO updateImagenProduct(String fileName, long id);

}
