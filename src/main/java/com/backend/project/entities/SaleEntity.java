package com.backend.project.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "sale")
public class SaleEntity  extends AuditModel{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "cliente_id", nullable = false)
	private long clienteId;

	@Column(name = "impuesto", nullable = false)
	private float impuesto;
	
	@Column(name = "total", nullable = false)
	private float total;
	
	@Column(name = "estado", nullable = false)
	private String estado;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private UserEntity user;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "sale_invoice_line", joinColumns = @JoinColumn(name = "sale_entity_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "invoice_line_id", referencedColumnName = "id"))
	private Set<InvoiceLineEntity> invoiceLine = new HashSet<InvoiceLineEntity>();
	
	
	public SaleEntity() {
		super();
	}


	public SaleEntity(LocalDateTime creation_date, String created_by, LocalDateTime update_date, String update_by,
			Boolean deleted, LocalDateTime deleted_date, String deleted_by, long id, long clienteId, float impuesto,
			float total, String estado, UserEntity user) {
		super(creation_date, created_by, update_date, update_by, deleted, deleted_date, deleted_by);
		this.id = id;
		this.clienteId = clienteId;
		this.impuesto = impuesto;
		this.total = total;
		this.estado = estado;
		this.user = user;
	}


	public Set<InvoiceLineEntity> getInvoiceLines() {
		return invoiceLine;
	}

	public void setInvoiceLines(Set<InvoiceLineEntity> invoiceLine) {
		this.invoiceLine = invoiceLine;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getClienteId() {
		return clienteId;
	}


	public void setClienteId(long clienteId) {
		this.clienteId = clienteId;
	}


	public float getImpuesto() {
		return impuesto;
	}


	public void setImpuesto(float impuesto) {
		this.impuesto = impuesto;
	}


	public float getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
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
