package com.backend.project.controllers;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.project.DTO.ProductDTOs.ProductDTO;
import com.backend.project.DTO.ProductDTOs.ProductResponseDTO;
import com.backend.project.DTO.ProductDTOs.RegisterProductDTO;
import com.backend.project.repositories.ProductRepository;
import com.backend.project.services.ProductService;
import com.backend.project.utils.AppConstants;
import com.backend.project.utils.FileUploadUtil;


@RestController 
@RequestMapping( "/api/product")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class ProductController {

	
	
	@Autowired
	private ProductService productService ;

	@Autowired
	private ProductRepository productRepository;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/new-product")
	public ResponseEntity<?> newProducto(@Valid @RequestBody RegisterProductDTO productoDTO){
		if(this.productRepository.existsByName(productoDTO.getName())) {
			return new ResponseEntity<>("PRODUCT.ERROR.REGISTER_NAME_EXISTS", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(this.productService.createUpdateProducto(productoDTO), HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('ROLE_SUPER_ROOT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EDITOR') or hasRole('ROLE_VISITANTE')")
	@GetMapping("/list-products")
	public ProductResponseDTO getUsers(@Valid
			@RequestParam(name = "numberPage", defaultValue = "0", required = false) int numberPage,
			@RequestParam(name = "pageSize", defaultValue = "10", required = false) int pageSize,
			@RequestParam(name = "orderBy", defaultValue = "id", required = false) String orderBy,
			@RequestParam(name = "sortDir", defaultValue = "des", required = false) String sortDir) {

		return this.productService.getAllProducts(numberPage, pageSize, orderBy, sortDir);
	}
	
	@PreAuthorize("hasRole('ROLE_SUPER_ROOT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EDITOR')")
	@PutMapping("/update-product")
	public ResponseEntity<ProductDTO> updateUser(@Valid @RequestBody ProductDTO dto){
		
		ProductDTO resDto = this.productService.updateProduct(dto);

		return new ResponseEntity<>(resDto, HttpStatus.OK);
		
	}
	
	@PreAuthorize("hasRole('ROLE_SUPER_ROOT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EDITOR') or hasRole('ROLE_VISITANTE')")
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDTO> getById(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok( this.productService.getById(id));
	}
	
	
	@PreAuthorize("hasRole('ROLE_SUPER_ROOT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EDITOR')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(name = "id") long id) {
		this.productService.delete(id);
		return new ResponseEntity<>("BORRADO.CORRECTO", HttpStatus.OK);

	}
	
	@GetMapping("/get-file/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable("filename") String filename) {
        byte[] image = new byte[0];
        try {
            image = FileUtils.readFileToByteArray(new File(AppConstants.PRODUCT_IMAGE_DIR + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }
    
	@PreAuthorize("hasRole('ROLE_SUPER_ROOT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EDITOR')")
    @PostMapping("/save-file/{id}")
    public ResponseEntity<byte[]> saveFile(@PathVariable("id") long id, @RequestParam("file") MultipartFile multipartFile) throws IOException {
    	String fileName = FileUploadUtil.cadenaAleatoria(30).toUpperCase().concat(".").concat(FilenameUtils.getExtension(StringUtils.cleanPath(multipartFile.getOriginalFilename())));
        String uploadDir = AppConstants.PRODUCT_IMAGE_DIR;
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        byte[] image = new byte[0];
        image = FileUtils.readFileToByteArray(new File(uploadDir + fileName));
        this.productService.updateImagenProduct(fileName, id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }
	


	
}
