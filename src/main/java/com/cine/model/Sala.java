package com.cine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "sala")
public class Sala implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idsala;
	
	@Column(name = "descsala")
	private String descsala;
	
	@Column(name = "asientos")
	private Integer asientos;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idestado")
	private Estado estado;
	
	
	
	//evita la recursividad 
	@JsonManagedReference
	@OneToMany(mappedBy="sala", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Asiento> listAsiento=new ArrayList<Asiento>();
	
	
	
	
	
	
	
	
	
	/**
	 * @return the listAsiento
	 */
	public List<Asiento> getListAsiento() {
		return listAsiento;
	}
	/**
	 * @param listAsiento the listAsiento to set
	 */
	public void setListAsiento(List<Asiento> listAsiento) {
		this.listAsiento = listAsiento;
	}
	/**
	 * @return the estado
	 */
	public Estado getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	/**
	 * @return the idsala
	 */
	public Long getIdsala() {
		return idsala;
	}
	/**
	 * @param idsala the idsala to set
	 */
	public void setIdsala(Long idsala) {
		this.idsala = idsala;
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
