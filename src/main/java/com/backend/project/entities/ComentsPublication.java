package com.backend.project.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comentsPublication")
public class ComentsPublication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String email;
	private String body;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publication_id", nullable = false)
	private PublicationsEntity publication;

	public ComentsPublication(long id, String name, String email, String body, PublicationsEntity publication) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.body = body;
		this.publication = publication;
	}

	public ComentsPublication() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public PublicationsEntity getPublication() {
		return publication;
	}

	public void setPublication(PublicationsEntity publication) {
		this.publication = publication;
	}

}
