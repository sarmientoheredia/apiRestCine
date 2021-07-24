package com.cine.model.dto;

import java.util.List;

public class SalaDto implements DtoEntity{

	
	private String descsala;
	private Integer asientos;
	

	private EstadoDto estado;
	
	private List<AsientoDto> listAsiento;

	
	public SalaDto(String descsala, Integer asientos) {
		super();
		this.descsala = descsala;
		this.asientos = asientos;
	}
	public SalaDto() {
	}
	
	

	/**
	 * @return the listAsiento
	 */
	public List<AsientoDto> getListAsiento() {
		return listAsiento;
	}
	/**
	 * @param listAsiento the listAsiento to set
	 */
	public void setListAsiento(List<AsientoDto> listAsiento) {
		this.listAsiento = listAsiento;
	}
	/**
	 * @return the estado
	 */
	public EstadoDto getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoDto estado) {
		this.estado = estado;
	}
	/**
	 * @return the descsala
	 */
	public String getDescsala() {
		return descsala;
	}
	/**
	 * @param descsala the descsala to set
	 */
	public void setDescsala(String descsala) {
		this.descsala = descsala;
	}
	/**
	 * @return the asientos
	 */
	public Integer getAsientos() {
		return asientos;
	}
	/**
	 * @param asientos the asientos to set
	 */
	public void setAsientos(Integer asientos) {
		this.asientos = asientos;
	}
	
	
	
}
