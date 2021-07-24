package com.cine.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado")
public class Estado implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long idestado;
	
	@Column(name="descestado")
	private String descestado;
	
	
	
	/**
	 * @return the idestado
	 */
	public Long getIdestado() {
		return idestado;
	}
	/**
	 * @param idestado the idestado to set
	 */
	public void setIdestado(Long idestado) {
		this.idestado = idestado;
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
