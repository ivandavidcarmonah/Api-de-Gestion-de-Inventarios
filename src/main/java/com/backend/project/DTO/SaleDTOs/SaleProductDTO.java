package com.backend.project.DTO.SaleDTOs;


import java.util.List;

import javax.validation.constraints.NotEmpty;

public class SaleProductDTO {

	@NotEmpty
	private List<Integer> products;
	
	public SaleProductDTO() {
		super();
	}

	public List<Integer> getProducts() {
		return products;
	}

	public void setProducts(List<Integer> products) {
		this.products = products;
	}
	
}
