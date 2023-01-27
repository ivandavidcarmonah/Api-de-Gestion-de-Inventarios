package com.backend.project.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "developer_blog", uniqueConstraints = { @UniqueConstraint(columnNames = { "title" }) })
public class DeveloperBlogEntity extends AuditModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "content", nullable = false)
	private String content;

	@Column(name = "imagen_header", nullable = true)
	private String imagenHeader;
	
	@Column(name = "imagen_body", nullable = true)
	private String imagenBody;
	

	public DeveloperBlogEntity() {
		super();
	}

	
	public DeveloperBlogEntity(LocalDateTime creation_date, String created_by, LocalDateTime update_date,
			String update_by, Boolean deleted, LocalDateTime deleted_date, String deleted_by, Long id, String title,
			String description, String content, String imagenHeader, String imagenBody
			) {
		super(creation_date, created_by, update_date, update_by, deleted, deleted_date, deleted_by);
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		this.imagenHeader = imagenHeader;
		this.imagenBody = imagenBody;
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
}
