package com.backend.project.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author idcarmona
 *
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
		value = {"creation_date","created_by","update_by","deleted","deleted_date","deleted_by"},
		allowGetters = true
		)
public class AuditModel implements Serializable {
	
	public static final long serialVersionUID = 1L;
	
	@Column(name ="creation_date", nullable = false, updatable = true, columnDefinition = "TIMESTAMP")
	@CreatedDate
	private LocalDateTime  creation_date;
	
	@Column(name ="created_by", nullable = false, updatable = true)
	@CreatedBy
	private String created_by;
	
	@Column(name ="update_date", nullable = false, columnDefinition = "TIMESTAMP")
	@LastModifiedDate
	private LocalDateTime update_date;
	
	@Column(name ="update_by", nullable = false)
	@LastModifiedBy
	private String  update_by;
	
	@Column(name ="deleted", nullable = true)
	private Boolean deleted;
	
	@Column(name ="deleted_date", nullable = true, columnDefinition = "TIMESTAMP")
	private LocalDateTime deleted_date;
	
	@Column(name ="deleted_by", nullable = true)
	private String deleted_by;
	
	

	public AuditModel(LocalDateTime creation_date, String created_by, LocalDateTime update_date, String update_by,
			Boolean deleted, LocalDateTime deleted_date, String deleted_by) {
		
		this.creation_date = creation_date;
		this.created_by = created_by;
		this.update_date = update_date;
		this.update_by = update_by;
		this.deleted = deleted;
		this.deleted_date = deleted_date;
		this.deleted_by = deleted_by;
	}
	
	public AuditModel() {
	}
	
	
	public LocalDateTime getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(LocalDateTime creation_date) {
		this.creation_date = creation_date;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public LocalDateTime getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(LocalDateTime update_date) {
		this.update_date = update_date;
	}

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}


	public Boolean getDeleted() {
		return deleted;
	}


	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}


	public LocalDateTime getDeleted_date() {
		return deleted_date;
	}


	public void setDeleted_date(LocalDateTime deleted_date) {
		this.deleted_date = deleted_date;
	}

	public String getDeleted_by() {
		return deleted_by;
	}


	public void setDeleted_by(String deleted_by) {
		this.deleted_by = deleted_by;
	}


}
