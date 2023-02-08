package com.backend.project.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "saleDetail")
public class SaleDetailEntity  extends AuditModel{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "amount", nullable = false)
	private String amount;
	
	@Column(name = "price", nullable = false)
	private float price;
	
	@Column(name = "total", nullable = false)
	private float total;
	
	@OneToOne
	private SaleEntity sale;
	

	@OneToOne
	private ProductEntity product;
	
	public SaleDetailEntity() {
		super();
	}



	public SaleDetailEntity(LocalDateTime creation_date, String created_by, LocalDateTime update_date, String update_by,
			Boolean deleted, LocalDateTime deleted_date, String deleted_by, long id, String name, String amount,
			float price, float total, SaleEntity sale, ProductEntity product) {
		super(creation_date, created_by, update_date, update_by, deleted, deleted_date, deleted_by);
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.price = price;
		this.total = total;
		this.sale = sale;
		this.product = product;
	}



	public SaleEntity getSale() {
		return sale;
	}



	public void setSale(SaleEntity sale) {
		this.sale = sale;
	}



	public ProductEntity getProduct() {
		return product;
	}



	public void setPruduct(ProductEntity pruduct) {
		this.product = pruduct;
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


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public float getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
	
}
