package com.cine.exception;

import java.util.Date;

public class MensajeError {

	private int statusCode;
	private Date timeStamp;
	private String mensaje;
	private String descripcion;
	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}
	/**
	 * @return the timeStamp
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	public MensajeError(int statusCode, Date timeStamp, String mensaje, String descripcion) {
		super();
		this.statusCode = statusCode;
		this.timeStamp = timeStamp;
		this.mensaje = mensaje;
		this.descripcion = descripcion;
	}
	
	
	
}
