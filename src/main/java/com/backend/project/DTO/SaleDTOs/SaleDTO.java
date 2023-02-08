package com.backend.project.DTO.SaleDTOs;

import java.util.HashSet;
import java.util.Set;

public class SaleDTO {

	private long id;
	private long clienteId;
	private long usuarioId;
	private String checkType;
	private String checkNum;
	private String checkSerie;
	private float impuesto;
	private float total;
	private String estado;
	public SaleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SaleDTO(long id, long clienteId, long usuarioId, String checkType, String checkNum, String checkSerie,
			float impuesto, float total, String estado) {
		super();
		this.id = id;
		this.clienteId = clienteId;
		this.usuarioId = usuarioId;
		this.checkType = checkType;
		this.checkNum = checkNum;
		this.checkSerie = checkSerie;
		this.impuesto = impuesto;
		this.total = total;
		this.estado = estado;
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
	public long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getCheckType() {
		return checkType;
	}
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}
	public String getCheckNum() {
		return checkNum;
	}
	public void setCheckNum(String checkNum) {
		this.checkNum = checkNum;
	}
	public String getCheckSerie() {
		return checkSerie;
	}
	public void setCheckSerie(String checkSerie) {
		this.checkSerie = checkSerie;
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