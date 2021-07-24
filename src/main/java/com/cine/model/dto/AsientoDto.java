package com.cine.model.dto;

public class AsientoDto implements DtoEntity{

	
	private Integer nroasiento;

	public AsientoDto() {
	}

	public AsientoDto(Integer nroasiento) {
		super();
		this.nroasiento = nroasiento;
	}

	/**
	 * @return the nroasiento
	 */
	public Integer getNroasiento() {
		return nroasiento;
	}

	/**
	 * @param nroasiento the nroasiento to set
	 */
	public void setNroasiento(Integer nroasiento) {
		this.nroasiento = nroasiento;
	}
	
	
	
}
