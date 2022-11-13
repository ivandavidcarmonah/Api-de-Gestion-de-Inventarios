package com.backend.project.entities;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "publication", uniqueConstraints = { @UniqueConstraint(columnNames = { "title" }) })
public class PublicationsEntity extends AuditModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@JsonBackReference
	@OneToMany(mappedBy = "publication", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ComentsPublication> coments = new HashSet<>();
	
	public PublicationsEntity() {
		super();
	}

	
	public PublicationsEntity(LocalDateTime creation_date, String created_by, LocalDateTime update_date,
			String update_by, Boolean deleted, LocalDateTime deleted_date, String deleted_by, Long id, String title,
			String description, String content, String imagenHeader, String imagenBody,
			Set<ComentsPublication> coments) {
		super(creation_date, created_by, update_date, update_by, deleted, deleted_date, deleted_by);
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		this.imagenHeader = imagenHeader;
		this.imagenBody = imagenBody;
		this.coments = coments;
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

	public Set<ComentsPublication> getComents() {
		return coments;
	}

	public void setComents(Set<ComentsPublication> coments) {
		this.coments = coments;
	}

}
