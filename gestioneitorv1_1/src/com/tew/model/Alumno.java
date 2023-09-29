package com.tew.model;

public class Alumno {
	private Long id;
	private String nombre;
	private String apellidos;
	private String iduser;
	private String email;
	private String Mensaje_error;
	
	public String getMensaje_error() {
		return Mensaje_error;
	}
	public void setNombre(String error) {
		this.Mensaje_error = error;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getIduser() {
		return iduser;
	}
	public void setIduser(String iduser) {
		this.iduser = iduser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
}
