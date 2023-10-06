package com.tew.presentation;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import com.tew.model.Alumno;
@ManagedBean(name = "BGError")
@SessionScoped
public class BGError extends Alumno implements Serializable {

	private static final long serialVersionUID = 1L;
	private String vista_Error;
	private String metodo_Error;
	private String clase_Error;
	private String error_Error;
	
	
	public BGError() {
		this.vista_Error = "vista_Error";
		this.metodo_Error = "metodo_Error";
		this.clase_Error = "clase_Error";
		this.error_Error = "error_Error";
	}
	public String getVista_Error() {
		return vista_Error;
	}
	public void setVista_Error(String vista_Error) {
		this.vista_Error = vista_Error;
	}
	public String getMetodo_Error() {
		return metodo_Error;
	}
	public void setMetodo_Error(String metodo_Error) {
		this.metodo_Error = metodo_Error;
	}
	public String getClase_Error() {
		return clase_Error;
	}
	public void setClase_Error(String clase_Error) {
		this.clase_Error = clase_Error;
	}
	public String getError_Error() {
		return error_Error;
	}
	public void setError_Error(String error_Error) {
		this.error_Error = error_Error;
	}

	
	
}
