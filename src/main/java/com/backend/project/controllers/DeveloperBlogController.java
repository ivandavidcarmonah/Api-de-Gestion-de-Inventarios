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

import com.backend.project.DTO.DeveloperBlogDTOs.DeveloperBlogDTO;
import com.backend.project.DTO.DeveloperBlogDTOs.DeveloperBlogResponseDTO;
import com.backend.project.services.impl.DeveloperBlogServiceImp;
import com.backend.project.utils.AppConstants;
import com.backend.project.utils.FileUploadUtil;

@RestController
@RequestMapping("/api/developer-blog")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class DeveloperBlogController {

	@Autowired
	private DeveloperBlogServiceImp service;

	
	@GetMapping("/list")
	public DeveloperBlogResponseDTO getList(
			@RequestParam(value = AppConstants.NUMBER_PAGE, defaultValue = "0", required = false) int numberPage,
			@RequestParam(value = AppConstants.SIZE_PAGE, defaultValue = "10", required = false) int pageSize,
			@RequestParam(value = AppConstants.ORDER_BY, defaultValue = "id", required = false) String orderBy,
			@RequestParam(value = AppConstants.ORDER_DIR, defaultValue = "asc", required = false) String sortDir) {

		return this.service.getPublications(numberPage, pageSize, orderBy, sortDir);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DeveloperBlogDTO> getPublicationById(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(this.service.getPublicationsById(id));
	}


	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/new")
	public ResponseEntity<DeveloperBlogDTO> savePublication(@Valid @RequestBody DeveloperBlogDTO reqDto) {
		return new ResponseEntity<>(this.service.createPublication(reqDto), HttpStatus.CREATED);
	}



	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER_ROOT') or hasRole('ROLE_EDITOR')")
	@PutMapping("/update/{id}")
	public ResponseEntity<DeveloperBlogDTO> updatePublication( @RequestBody DeveloperBlogDTO reqDto,
			@PathVariable(name = "id") long id) {
		DeveloperBlogDTO res = this.service.updatePublication(reqDto, id);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}


	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER_ROOT') or hasRole('ROLE_EDITOR')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePublication(@PathVariable(name = "id") long id) {
		this.service.deletePublication(id);

		return new ResponseEntity<>("BORRADO.CORRECTO", HttpStatus.OK);

	}
	
	@GetMapping("/get-file/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable("filename") String filename) {
        byte[] image = new byte[0];
        try {
            image = FileUtils.readFileToByteArray(new File(AppConstants.DEVELOPER_BLOG_DIR + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }
    
	
    @PostMapping("/save-file/header/{id}")
    public ResponseEntity<byte[]> saveFile(@PathVariable("id") long id, @RequestParam("file") MultipartFile multipartFile) throws IOException {
    	String fileName = FileUploadUtil.cadenaAleatoria(30).toUpperCase().concat(".").concat(FilenameUtils.getExtension(StringUtils.cleanPath(multipartFile.getOriginalFilename())));
        String uploadDir = AppConstants.DEVELOPER_BLOG_DIR;
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        byte[] image = new byte[0];
        image = FileUtils.readFileToByteArray(new File(uploadDir + fileName));
        this.service.updateImagenBlogHeaderDTODto(fileName, id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }
    
	
    @PostMapping("/save-file/body/{id}")
    public ResponseEntity<byte[]> saveFileBody(@PathVariable("id") long id, @RequestParam("file") MultipartFile multipartFile) throws IOException {
    	String fileName = FileUploadUtil.cadenaAleatoria(30).toUpperCase().concat(".").concat(FilenameUtils.getExtension(StringUtils.cleanPath(multipartFile.getOriginalFilename())));
        String uploadDir = AppConstants.DEVELOPER_BLOG_DIR;
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        byte[] image = new byte[0];
        image = FileUtils.readFileToByteArray(new File(uploadDir + fileName));
        this.service.updateImagenBlogBodyDTODto(fileName, id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

}
