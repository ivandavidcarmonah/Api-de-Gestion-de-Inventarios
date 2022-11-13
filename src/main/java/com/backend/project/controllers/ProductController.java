package com.backend.project.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.project.DTO.ProductDTOs.ProductDTO;
import com.backend.project.DTO.ProductDTOs.ProductResponseDTO;
import com.backend.project.services.ProductService;
import com.backend.project.utils.AppConstants;


@RestController 
@RequestMapping( "/api/product")
@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET})
public class ProductController {

	
	@Autowired
	private ProductService productService ;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create-update")
	public ResponseEntity <ProductDTO> newProducto(@Valid @RequestBody ProductDTO productoDTO){
		return new ResponseEntity<>(this.productService.createUpdateProducto(productoDTO), HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/delete/{idProdcut}")
	public ResponseEntity<String> deleteProduct(@Valid @PathVariable(name = "idProdcut") long idProdcut) {
		this.productService.deleteProduct(idProdcut);
		return new ResponseEntity<>("BORRADO.CORRECTO", HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/getproductsbyidcompany/{idCompany}")
	public List<ProductDTO> getProductsByIdCompany(@Valid @PathVariable(name = "idCompany") long idCompany){
		return this.productService.getAllProductsByIdcompany(idCompany);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/list-products-byidcompany/{idCompany}")
	public ProductResponseDTO getUsers(@Valid
			@PathVariable(name = "idCompany") long idCompany,
			@RequestParam(value = AppConstants.NUMBER_PAGE, defaultValue = "0", required = false) int numberPage,
			@RequestParam(value = AppConstants.SIZE_PAGE, defaultValue = "10", required = false) int pageSize,
			@RequestParam(value = AppConstants.ORDER_BY, defaultValue = "idProduct", required = false) String orderBy,
			@RequestParam(value = AppConstants.ORDER_DIR, defaultValue = "asc", required = false) String sortDir) {
		return this.productService.getAllProductsByIdcompany(idCompany, numberPage, pageSize, orderBy, sortDir);
	}
	
}
