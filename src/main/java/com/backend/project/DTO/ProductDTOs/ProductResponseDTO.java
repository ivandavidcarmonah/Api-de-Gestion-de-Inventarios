package com.backend.project.DTO.ProductDTOs;

import java.util.List;

public class ProductResponseDTO {

	private List<ProductDTO> dataList;
	private int numberPage;
	private int sizePage;
	private long dataLength;
	private long totalPages;
	private boolean lastPage;

	public ProductResponseDTO() {
		super();
	}

	public ProductResponseDTO(List<ProductDTO> dataList, int numberPage, int sizePage, long dataLength, long totalPages,
			boolean lastPage) {
		super();
		this.dataList = dataList;
		this.numberPage = numberPage;
		this.sizePage = sizePage;
		this.dataLength = dataLength;
		this.totalPages = totalPages;
		this.lastPage = lastPage;
	}

	public List<ProductDTO> getDataList() {
		return dataList;
	}

	public void setDataList(List<ProductDTO> dataList) {
		this.dataList = dataList;
	}

	public int getNumberPage() {
		return numberPage;
	}

	public void setNumberPage(int numberPage) {
		this.numberPage = numberPage;
	}

	public int getSizePage() {
		return sizePage;
	}

	public void setSizePage(int sizePage) {
		this.sizePage = sizePage;
	}

	public long getDataLength() {
		return dataLength;
	}

	public void setDataLength(long dataLength) {
		this.dataLength = dataLength;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

}
