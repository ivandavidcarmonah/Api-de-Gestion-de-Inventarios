package com.backend.project.entities;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "saleDetail")
public class SaleDetailEntity  extends AuditModel{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "total", nullable = false)
	private double total;
	
	@OneToOne
	private SaleEntity sale;
	

	@OneToMany
	private List<ProductEntity> product;
	

	public void generarTotal(List<ProductEntity> product) {
		double total = 0; //Iniciamos el total a 0
		for (int i = 0; i < product.size(); i++) {
			total = product.get(i).getPrice() + total; 
		}
		
		this.setTotal(total); //Asignamos el total a la venta actual
	}

	
	public SaleDetailEntity() {
		super();
	}


	public SaleDetailEntity(LocalDateTime creation_date, String created_by, LocalDateTime update_date, String update_by,
			Boolean deleted, LocalDateTime deleted_date, String deleted_by, long id, double total, SaleEntity sale,
			List<ProductEntity> product) {
		super(creation_date, created_by, update_date, update_by, deleted, deleted_date, deleted_by);
		this.id = id;
		this.total = total;
		this.sale = sale;
		this.product = product;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public SaleEntity getSale() {
		return sale;
	}


	public void setSale(SaleEntity sale) {
		this.sale = sale;
	}


	public List<ProductEntity> getProduct() {
		return product;
	}


	public void setProduct(List<ProductEntity> product) {
		this.product = product;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
