package com.cine.model.dto;

public class EstadoDto implements DtoEntity {

	private String descestado;

	public EstadoDto(String descestado) {
		super();
		this.descestado = descestado;
	}

	public EstadoDto() {

	}

	/**
	 * @return the descestado
	 */
	public String getDescestado() {
		return descestado;
	}

	/**
	 * @param descestado the descestado to set
	 */
	public void setDescestado(String descestado) {
		this.descestado = descestado;
	}

}
