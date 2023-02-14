package com.backend.project.services.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.backend.project.DTO.ProductDTOs.ProductDTO;
import com.backend.project.DTO.ProductDTOs.ProductResponseDTO;
import com.backend.project.DTO.ProductDTOs.RegisterProductDTO;
import com.backend.project.DTO.UserDTOs.UserDetailDTO;
import com.backend.project.entities.DeveloperBlogEntity;
import com.backend.project.entities.ProductEntity;
import com.backend.project.entities.UserEntity;
import com.backend.project.exceptions.ResourceNotFoundException;
import com.backend.project.repositories.ProductRepository;
import com.backend.project.repositories.UserRepository;
import com.backend.project.services.ProductService;
import com.backend.project.utils.AppConstants;
import com.backend.project.utils.BarCode;
import com.backend.project.utils.FileUploadUtil;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public ProductResponseDTO getAllProducts(int numberPage, int pageSize, String orderBy, String sortDir) {
				Sort sort = sortDir.equalsIgnoreCase( Sort.Direction.ASC.name()) ? Sort.by(orderBy).ascending() : Sort.by(orderBy).descending(); 
				Pageable pageable = PageRequest.of(numberPage, pageSize, sort);
				Page<ProductEntity> products = this.productRepository.findAll(pageable);

				List<ProductEntity> values = products.getContent();
				List<ProductDTO> listDto = values.stream().map(element -> mapEntitie(element))
						.collect(Collectors.toList());

				ProductResponseDTO respDto = new ProductResponseDTO();
				respDto.setDataList(listDto);

				respDto.setNumberPage(products.getNumber());
				respDto.setSizePage(products.getSize());

				respDto.setDataLength(products.getNumberOfElements());
				respDto.setTotalPages(products.getTotalPages());
				respDto.setLastPage(products.isLast());

				return respDto;
	}
	
	
	/**
	 * Metodo para crear un producto si el idProduct es 0 o actualizarlo si es != de 0
	 */
	public ProductDTO createUpdateProducto(RegisterProductDTO dto) {
		dto.setCreaDate(new Date());
		dto.setModDate(new Date());
		String principal = SecurityContextHolder.getContext().getAuthentication().getName();
		UserEntity user = this.userRepository.findByEmail(principal).orElseThrow(() -> new ResourceNotFoundException("Users", "email", principal));
		ProductEntity entity = new ProductEntity();
		
		String uploadDir = AppConstants.PRODUCT_IMAGE__BARCODE;
		
		try {
			BufferedImage bufferedImage = BarCode.generateCode128BarCodeImage(dto.getBarCode());
			String fileName = dto.getBarCode()+"_"+ dto.getName();
			File outputfile = new File(dto.getName());
		    ImageIO.write(bufferedImage, "png", outputfile);
		    Path uploadPath = Paths.get(uploadDir);
		    if (!Files.exists(uploadPath)) {
	            Files.createDirectories(uploadPath);
	        }
		    InputStream targetStream = new FileInputStream(outputfile);
		    try (InputStream inputStream = targetStream) {
	            Path filePath = uploadPath.resolve(fileName+".png");
	            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
	        } catch (IOException ioe) {        
	            throw new IOException("Could not save image file: " + fileName, ioe);
	        }     
		    
		    
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
//		FileUploadUtil.saveFile(uploadDir, "BAR_CODE" + dto.getName(), BarCode.generateCode128BarCodeImage("22225"));
//		
		
		entity = this.mapDTO(dto);
		entity.setUser(user);
		ProductDTO resDtp = this.mapEntitie(this.productRepository.save(entity)); 
			
		return resDtp;
	}

	/**
	 * Metodo para eliminar un producto por su idProduct
	 */
	public void deleteProduct(long idProdcut) {
		this.productRepository.deleteById(idProdcut);
	}
	
	public ProductResponseDTO getAllProducts(){
		List<ProductDTO> listProductsDto = new ArrayList<ProductDTO>();
		List<ProductEntity> products = this.productRepository.findAll();

		if(!products.isEmpty()) {
			for (int i = 0; i < products.size(); i++) {
				listProductsDto.add(this.mapEntity(products.get(i)));
			}
		}		
		ProductResponseDTO respDto = new ProductResponseDTO();
		respDto.setDataList(listProductsDto);
		
		return respDto;		
	}
	

	@Override
	public ProductDTO getProductId(long id) {
		 
		ProductEntity productEntity = this.productRepository.findById(id)
	    		 .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		ProductDTO dto = new ProductDTO();
		dto =  mapEntity(productEntity);
		
		return dto;
	}


	@Override
	public ProductDTO updateProduct(ProductDTO dto) {
		ProductEntity productEntity = this.productRepository.findById(dto.getIdProduct())
	    		 .orElseThrow(() -> new ResourceNotFoundException("Product", "id", dto.getIdProduct()));
		
		productEntity.setAllergies(dto.getAllergies());
		productEntity.setName(dto.getName());
		productEntity.setPrice(dto.getPrice());
		productEntity.setValid(dto.isValid());
		productEntity.setDescription(dto.getDescription());

		String principal = SecurityContextHolder.getContext().getAuthentication().getName();
		
		productEntity.setUpdate_by(principal);
		productEntity.setUpdate_date(LocalDateTime.now());

		ProductEntity update = this.productRepository.save(productEntity);

		
		return this.mapEntitie(update);
	}


	@Override
	public ProductDTO getById(long id) {
		ProductEntity entity = this.productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

		ProductDTO detailDTO = new ProductDTO();
		detailDTO =  mapEntitie(entity);
		
		return detailDTO;
	}

	
	@Override
	public void delete(long id) {
		ProductEntity entitie = this.productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		this.productRepository.delete(entitie);		
	}


	@Override
	public ProductDTO updateImagenProduct(String fileName, long id) {
		ProductEntity element = this.productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Publications", "id", id));

		/**
		 * Eliminar imagen si existe
		 */
		if (element.getPicture() != null) {
			File fichero = new File(AppConstants.PRODUCT_IMAGE_DIR + element.getPicture());
			if (fichero.delete())
				   System.out.println("El fichero ha sido borrado satisfactoriamente");
				else
				   System.out.println("El fichero no puede ser borrado");
		}
		element.setUpdate_date(LocalDateTime.now());
		element.setPicture(fileName);
		ProductEntity elementEntity = this.productRepository.save(element);

		return mapEntitie(elementEntity);
		
	}

	
	/**
	 * Mapear desde un Entity -> DTO
	 * 
	 * @param dto
	 * @return
	 */
	private ProductDTO mapEntity(ProductEntity entity) {
		return this.modelMapper.map(entity, ProductDTO.class);
	}
	
	
	/**
	 * Mapear desde Entidad -> DTO
	 * 
	 * @param dto
	 * @return
	 */
	private ProductDTO mapEntitie(ProductEntity productEntity) {
		return this.modelMapper.map(productEntity, ProductDTO.class);
	}

	/**
	 * Mapear desde un DTO -> Entidad
	 * 
	 * @param dto
	 * @return
	 */
	private ProductEntity mapDTO(ProductDTO dto) {
		return this.modelMapper.map(dto, ProductEntity.class);
	}
	
	private ProductEntity mapDTO(RegisterProductDTO dto) {
		return this.modelMapper.map(dto, ProductEntity.class);
	}

}
