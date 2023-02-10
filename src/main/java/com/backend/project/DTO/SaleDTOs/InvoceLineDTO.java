package com.backend.project.DTO.SaleDTOs;


import com.backend.project.entities.SaleEntity;

public class InvoceLineDTO {
    private Long id;
    
    private String product;
    
    private double price;
    
    private double quantity;
    
    private SaleEntity sale;
    
    
	public InvoceLineDTO() {
		super();
	}

	public InvoceLineDTO(Long id, String product, double price, double quantity, SaleEntity sale) {
		super();
		this.id = id;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.sale = sale;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public SaleEntity getSale() {
		return sale;
	}

	public void setSale(SaleEntity sale) {
		this.sale = sale;
	}
}
