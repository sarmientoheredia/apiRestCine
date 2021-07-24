package com.cine.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcliente;
	
	@Column(name = "nomcliente")
	private String nomcliente;
	
	@Column(name = "apecliente")
	private String apecliente;
	
	@Column(name = "dnicliente")
	private String dnicliente;
	/**
	 * @return the idcliente
	 */
	public Long getIdcliente() {
		return idcliente;
	}
	/**
	 * @param idcliente the idcliente to set
	 */
	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}
	/**
	 * @return the nomcliente
	 */
	public String getNomcliente() {
		return nomcliente;
	}
	/**
	 * @param nomcliente the nomcliente to set
	 */
	public void setNomcliente(String nomcliente) {
		this.nomcliente = nomcliente;
	}
	/**
	 * @return the apecliente
	 */
	public String getApecliente() {
		return apecliente;
	}
	/**
	 * @param apecliente the apecliente to set
	 */
	public void setApecliente(String apecliente) {
		this.apecliente = apecliente;
	}
	/**
	 * @return the dnicliente
	 */
	public String getDnicliente() {
		return dnicliente;
	}
	/**
	 * @param dnicliente the dnicliente to set
	 */
	public void setDnicliente(String dnicliente) {
		this.dnicliente = dnicliente;
	}
	
	
}
