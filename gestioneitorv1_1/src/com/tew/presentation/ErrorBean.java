package com.tew.presentation;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.SessionScoped;

@RequestScoped
public class ErrorBean {
	
	private static final long serialVersionUID = 1L;
	
	private String mensaje;
	private String metodo;
	
	public ErrorBean() {
		this.mensaje="";
		this.metodo="";
	}

	public String getMensaje() {
		return "Mensaje de error: "+mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = "Error en el metodo: "+metodo;
	}
	
	
	

}
