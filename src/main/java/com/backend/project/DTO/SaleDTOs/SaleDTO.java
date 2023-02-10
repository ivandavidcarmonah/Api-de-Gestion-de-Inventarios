package com.backend.project.DTO.SaleDTOs;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.backend.project.DTO.UserDTOs.RolesUserDTO;
import com.backend.project.DTO.UserDTOs.UserDTO;

public class SaleDTO {

	private long id;
	private long clienteId;
	private float impuesto;
	private float total;
	private String estado;
	private UserDTO user;
	private  Set<InvoceLineDTO> invoiceLine = new HashSet<InvoceLineDTO>();

	public SaleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SaleDTO(long id, long clienteId, float impuesto, float total, String estado, UserDTO user
			) {
		super();
		this.id = id;
		this.clienteId = clienteId;
		this.impuesto = impuesto;
		this.total = total;
		this.estado = estado;
		this.user = user;
	}


	public Set<InvoceLineDTO> getInvoiceLine() {
		return invoiceLine;
	}

	public void setInvoiceLine(Set<InvoceLineDTO> invoiceLine) {
		this.invoiceLine = invoiceLine;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
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



}
