package com.backend.project.DTO.SaleDTOs;


import com.backend.project.DTO.ProductDTOs.ProductDTO;

public class SaleDetailDTO {

	private long id;
	private float total;
	private SaleProductRespDTO product;

	
	public SaleDetailDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SaleDetailDTO(long id, float total, SaleProductRespDTO product) {
		super();
		this.id = id;
		this.total = total;
		this.product = product;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public float getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}


	public SaleProductRespDTO getProduct() {
		return product;
	}


	public void setProduct(SaleProductRespDTO product) {
		this.product = product;
	}

}
