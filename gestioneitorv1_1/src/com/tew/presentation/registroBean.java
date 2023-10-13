package com.tew.presentation;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
@ManagedBean(name="registro")
@RequestScoped
public class registroBean implements Serializable{
	


	private static final long serialVersionUID = 2L;
	private String Usuario;
	private String password;
	private String password2;
	
	public registroBean() {
		this.Usuario="";
		this.password="";
		this.password2="";
		
	}
	
	public void inicia(ActionEvent event) {
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ResourceBundle bundle =
				facesContext.getApplication().getResourceBundle(facesContext, "msgs");
		setpassword("");
		setpassword2("");
		setUsuario("");

	}
	
	public String registrarse() {
        // Implementar la l�gica de registro aqu�
        if (password.equals(password2)) {
            // Registro exitoso
            return "exito"; // P�gina de �xito
        } else {
            // Mostrar mensaje de error
        	return "error"; // P�gina de error
        }
    }

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public String getpassword2() {
		return password2;
	}

	public void setpassword2(String password2) {
		this.password2 = password2;
	}



	
	

}
