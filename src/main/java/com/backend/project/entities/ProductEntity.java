package com.backend.project.entities;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author IvanDavidCarmona
 *
 */
@Entity
@Table(name = "product", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }), 
		@UniqueConstraint(columnNames = { "barCode" }) })
public class ProductEntity extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;


	@Column(nullable = false)
	private String name;

	@Column(nullable = true)
	private String description;

	@Column(nullable = false)
	private String preparesin;

	@Column(nullable = true)
	private String allergies;

	@Column(nullable = false)
	private double price;

	@Column(nullable = false)
	private boolean isValid;
	
	
	@Column(nullable = true)
	private String picture;
	
	@Column(nullable = true)
	private String barCode;
	
	
	@Column(nullable = false)
	private boolean isSpent;

	
	@ManyToOne
	private UserEntity user;

	public ProductEntity(LocalDateTime creation_date, String created_by, LocalDateTime update_date, String update_by,
			Boolean deleted, LocalDateTime deleted_date, String deleted_by, long id, String name, String description,
			String preparesin, String allergies, double price, boolean isValid, String picture, String barCode,
			boolean isSpent, UserEntity user) {
		super(creation_date, created_by, update_date, update_by, deleted, deleted_date, deleted_by);
		this.id = id;
		this.name = name;
		this.description = description;
		this.preparesin = preparesin;
		this.allergies = allergies;
		this.price = price;
		this.isValid = isValid;
		this.picture = picture;
		this.barCode = barCode;
		this.isSpent = isSpent;
		this.user = user;
	}

	public ProductEntity() {}

	
	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPreparesin() {
		return preparesin;
	}

	public void setPreparesin(String preparesin) {
		this.preparesin = preparesin;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public boolean isSpent() {
		return isSpent;
	}

	public void setSpent(boolean isSpent) {
		this.isSpent = isSpent;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
