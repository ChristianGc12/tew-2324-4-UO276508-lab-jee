package com.tew.presentation;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="beanError")
@RequestScoped
public class ErrorBean {
	
	private static final long serialVersionUID = 1L;
	
	private String mensaje;
	private String metodo;
	private String clase;
	private String vista;
	
	public ErrorBean() {
		this.mensaje="";
		this.metodo="";
		this.clase="";
		this.vista="";
	}

	
	
	
	public String getClase() {
		return clase;
	}


	public void setClase(String clase) {
		this.clase = clase;
	}


	public String getVista() {
		return vista;
	}




	public void setVista(String vista) {
		this.vista = vista;
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
