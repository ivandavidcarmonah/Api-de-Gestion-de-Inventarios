package com.backend.project.DTO.DeveloperBlogDTOs;

import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.backend.project.DTO.AuditDTOs.AuditCreate.AuditDTO;
import com.backend.project.DTO.UserDTOs.UserDTO;

public class DeveloperBlogDTO extends AuditDTO{

	private Long id;
	
	@NotEmpty
	@Size(min = 3, max = 250, message="DEVELOPER_BLOG.ERROR.TITULO")
	private String title;
	
	@NotEmpty
	@Size(min = 10, max = 300, message="DEVELOPER_BLOG.ERROR.DESCRIPTION")
	private String description;
	
	@NotEmpty
	@Size(min = 20, message="DEVELOPER_BLOG.ERROR.CONTENT")
	private String content;

	
	private String imagenHeader;
	
	private String imagenBody;
	
	private UserDTO user;

	


	public DeveloperBlogDTO() {
		super();
	}

	
	public DeveloperBlogDTO(LocalDateTime creation_date, long created_by, LocalDateTime update_date, long update_by,
			Boolean deleted, LocalDateTime deleted_date, long deleted_by, Long id,
			@NotEmpty @Size(min = 3, max = 10, message = "DEVELOPER_BLOG.ERROR.TITULO") String title,
			@NotEmpty @Size(min = 10, message = "DEVELOPER_BLOG.ERROR.DESCRIPTION") String description,
			@NotEmpty @Size(min = 20, message = "DEVELOPER_BLOG.ERROR.CONTENT") String content, String imagenHeader,
			String imagenBody) {
		super(creation_date, created_by, update_date, update_by, deleted, deleted_date, deleted_by);
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		this.imagenHeader = imagenHeader;
		this.imagenBody = imagenBody;
		
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImagenHeader() {
		return imagenHeader;
	}


	public void setImagenHeader(String imagenHeader) {
		this.imagenHeader = imagenHeader;
	}


	public String getImagenBody() {
		return imagenBody;
	}


	public void setImagenBody(String imagenBody) {
		this.imagenBody = imagenBody;
	}
	
	public UserDTO getUser() {
		return user;
	}


	public void setUser(UserDTO created_by) {
		this.user = created_by;
	}



}