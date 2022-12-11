package com.backend.project.DTO.AuditDTOs.AuditCreate;

import java.time.LocalDateTime;



public class AuditDTO {
	
	
	private LocalDateTime  creation_date;
	
	
	private long  created_by;
	
	private LocalDateTime update_date;
	
	
	private long   update_by;
	
	private Boolean deleted;
	
	private LocalDateTime deleted_date;

	
	private long deleted_by;

	
	public AuditDTO(LocalDateTime creation_date, long created_by, LocalDateTime update_date, long update_by,
			Boolean deleted, LocalDateTime deleted_date, long deleted_by) {
		super();
		this.creation_date = creation_date;
		this.update_date = update_date;
		this.update_by = update_by;
		this.deleted = deleted;
		this.deleted_date = deleted_date;
		this.deleted_by = deleted_by;
	}

	
	
	public AuditDTO() {
		// TODO Auto-generated constructor stub
	}

	
	
	public long getCreated_by() {
		return created_by;
	}

	public void setCreated_by(long created_by) {
		this.created_by = created_by;
	}



	public LocalDateTime getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(LocalDateTime creation_date) {
		this.creation_date = creation_date;
	}



	public LocalDateTime getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(LocalDateTime update_date) {
		this.update_date = update_date;
	}

	public long getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(long update_by) {
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

	public long getDeleted_by() {
		return deleted_by;
	}

	public void setDeleted_by(long deleted_by) {
		this.deleted_by = deleted_by;
	}
	
	
}
