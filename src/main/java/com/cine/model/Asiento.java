package com.cine.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "asiento")
public class Asiento implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idasiento;
	
	@Column(name = "nroasiento")
	private Integer nroasiento;

	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idsala")
	private Sala sala;
	
	
	
	
	/**
	 * @return the sala
	 */
	public Sala getSala() {
		return sala;
	}

	/**
	 * @param sala the sala to set
	 */
	public void setSala(Sala sala) {
		this.sala = sala;
	}

	/**
	 * @return the idasiento
	 */
	public Long getIdasiento() {
		return idasiento;
	}

	/**
	 * @param idasiento the idasiento to set
	 */
	public void setIdasiento(Long idasiento) {
		this.idasiento = idasiento;
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
