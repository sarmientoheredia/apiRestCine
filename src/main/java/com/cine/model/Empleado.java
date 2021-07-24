package com.cine.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Empleado implements Serializable {


	private static final long serialVersionUID = 1L;

	
	@Id
	private Long idempleado;
	private String nombre;
	private String apellido;
	
	private Date fechacontrat;
	
	
	
	
	public Empleado() {
	}
	public Empleado(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	/**
	 * @return the idempleado
	 */
	public Long getIdempleado() {
		return idempleado;
	}
	/**
	 * @param idempleado the idempleado to set
	 */
	public void setIdempleado(Long idempleado) {
		this.idempleado = idempleado;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * @return the fechacontrat
	 */
	public Date getFechacontrat() {
		return fechacontrat;
	}
	/**
	 * @param fechacontrat the fechacontrat to set
	 */
	public void setFechacontrat(Date fechacontrat) {
		this.fechacontrat = fechacontrat;
	}
	
	
	
	
	
}
