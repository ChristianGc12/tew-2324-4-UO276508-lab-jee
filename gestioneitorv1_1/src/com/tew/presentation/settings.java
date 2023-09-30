package com.tew.presentation;
import java.io.Serializable;
import java.util.Locale;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.tew.model.Alumno;
@ManagedBean
@SessionScoped
public class settings implements Serializable{
	
	@ManagedProperty(value="#{alumno}")
	private BeanAlumno alumno;

	private static final long serialVersionUID = 2L;
	private static final Locale ENGLISH = new Locale("en");
	private static final Locale SPANISH = new Locale("es");
	private Locale locale = new Locale("es");
	public Locale getLocale() { /*Habria que cambiar algo de c�digo para coger locale
del navegador la primera vez que se accede a getLocale(), de momento el idioma de
partida �es�*/
		return(locale);
	}

	public void setAlumno(Alumno alumno) {
		 this.alumno = (BeanAlumno) alumno;
		}
		public BeanAlumno getAlumno(){
		 return this.alumno;
		}
	
	public void setSpanish(ActionEvent event) {
		locale = SPANISH;
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}
	public void setEnglish(ActionEvent event) {
		locale = ENGLISH;
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}
}
