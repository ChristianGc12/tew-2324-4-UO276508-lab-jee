package com.tew.presentation;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.tew.business.AlumnosService;
import com.tew.infrastructure.Factories;
import com.tew.model.Alumno;


@ManagedBean
@SessionScoped
public class BeanAlumnos implements Serializable{
	private static final long serialVersionUID = 55555L;
	// Se añade este atributo de entidad para recibir el alumno concreto seleccionado 
	// de la tabla o de un formulario. 
	// Es necesario inicializarlo para que al entrar desde el formulario de 
	// AltaForm.xhtml se puedan dejar los valores en un objeto existente.

	private Alumno[] alumnos = null;
	
	@ManagedProperty(value="#{bgError}")
	private BGError bgError;

	@ManagedProperty(value="#{alumno}")
	private BeanAlumno alumno;
	

	
	public BGError getBgError() {
		return bgError;
	}
	public void setBgError(BGError bgError) {
		this.bgError = bgError;
	}

	//Para los errores reutilizando el bean
	private String mensaje;
	private String metodo;

	public BeanAlumno getAlumno() {
		return alumno;
	}
	public void setAlumno(BeanAlumno alumno) {
		this.alumno = alumno;
	}
	public String getMensaje() {
		return mensaje;
	}
	public String getMetodo() {
		return metodo;
	}
	public void setMensaje(String men) {
		this.mensaje=men;
	}
	public void setMetodo(String met) {
		this.metodo= "Error en el metodo: "+met;
	}



/*	public BeanAlumnos(){
		iniciaAlumno(null);
	}*/
	
	public void iniciaAlumno(ActionEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		//Obtenemos el archivo de propiedades correspondiente al idioma que
		//esta seleccionado y que viene envuelto en facesContext
		ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, "msgs");
		alumno.setId(null);
		alumno.setIduser(bundle.getString("valorDefectoUserId"));
		alumno.setNombre(bundle.getString("valorDefectoNombre"));
		alumno.setApellidos(bundle.getString("valorDefectoApellidos"));
		alumno.setEmail(bundle.getString("valorDefectoCorreo")); 
	}

	public Alumno[] getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(Alumno[] alumnos) {
		this.alumnos = alumnos;
	}


	//Se inicia correctamente el MBean inyectado si JSF lo hubiera crea
	//y en caso contrario se crea. (hay que tener en cuenta que es un Bean de sesión)
	//Se usa @PostConstruct, ya que en el contructor no se sabe todavía si el Managed Bean
	//ya estaba construido y en @PostConstruct SI.
	@PostConstruct
	public void init() {
		System.out.println("BeanAlumnos - PostConstruct");
		//Buscamos el alumno en la sesión. Esto es un patrón factoría claramente.
		alumno = Factories.beanAlumnoFactory;
		bgError = Factories.beanErrorFactori;
	}
	@PreDestroy
	public void end() {
		System.out.println("BeanAlumnos - PreDestroy");
	}




	public String listado() {
		AlumnosService service;
		try {
			// Acceso a la implementacion de la capa de negocio 
			// a través de la factoría
			service = Factories.services.createAlumnosService();
			// Asi le damos información a toArray para poder hacer el casting a Alumno[]
			alumnos = (Alumno [])service.getAlumnos().toArray(new Alumno[0]);
			return "exito";
		} catch (Exception e) {
			ErrorBean localError = (ErrorBean)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(new String("errores"));
			if(localError==null) {
				localError= new ErrorBean();
			}

			FacesContext facesContext = FacesContext.getCurrentInstance();
			String currentPageViewId = facesContext.getViewRoot().getViewId();
			String vista = currentPageViewId.substring(currentPageViewId.lastIndexOf("/") + 1);
			
			bgError.setVista_Error(vista);
		    bgError.setMetodo_Error("listado");
		    bgError.setClase_Error("BeanAlumnos");
		    bgError.setError_Error(e.getMessage()); // O cualquier otra forma de obtener el mensaje de error

			return "error";
		}
	}
	public String edit() {
		AlumnosService service;
		try {
			// Acceso a la implementacion de la capa de negocio 
			// a través de la factoría
			service = Factories.services.createAlumnosService();
			//Recargamos el alumno en la tabla de la base de datos por si hubiera cambios.
			alumno = (BeanAlumno) service.findById(alumno.getId());
			return "exito";
		} catch (Exception e) {
	
			FacesContext facesContext = FacesContext.getCurrentInstance();
			String currentPageViewId = facesContext.getViewRoot().getViewId();
			String vista = currentPageViewId.substring(currentPageViewId.lastIndexOf("/") + 1);
			
			bgError.setVista_Error(vista);
		    bgError.setMetodo_Error("edit");
		    bgError.setClase_Error("BeanAlumnos");
		    bgError.setError_Error(e.getMessage()); // O cualquier otra forma de obtener el mensaje de error
			
			return "error";
		}
	}
	public String salva() {
		AlumnosService service;
		try {
			// Acceso a la implementacion de la capa de negocio 
			// a través de la factoría
			service = Factories.services.createAlumnosService();
			//Salvamos o actualizamos el alumno segun sea una operacion de alta o de edición
			if (alumno.getId() == null) {
				service.saveAlumno(alumno);
			}
			else {
				service.updateAlumno(alumno); 
			}
			//Actualizamos el javabean de alumnos inyectado en la tabla
			alumnos = (Alumno [])service.getAlumnos().toArray(new Alumno[0]);
			return "exito";
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			String currentPageViewId = facesContext.getViewRoot().getViewId();
			String vista = currentPageViewId.substring(currentPageViewId.lastIndexOf("/") + 1);
			
			bgError.setVista_Error(vista);
		    bgError.setMetodo_Error("salva");
		    bgError.setClase_Error("BeanAlumnos");
		    bgError.setError_Error(e.getMessage()); // O cualquier otra forma de obtener el mensaje de error
			
			
			
			return "error";
		}
	}

	public String baja(Alumno alumno) {
		AlumnosService service;
		try {
			// Acceso a la implementacion de la capa de negocio 
			// a través de la factoría
			service = Factories.services.createAlumnosService();
			//Borramos  el alumno
			if (alumno.getId() != null) {
				service.deleteAlumno(alumno.getId());
			}
			//Actualizamos el javabean de alumnos inyectado en la tabla
			alumnos = (Alumno [])service.getAlumnos().toArray(new Alumno[0]);
			return "exito";
		} catch (Exception e) {

			FacesContext facesContext = FacesContext.getCurrentInstance();
			String currentPageViewId = facesContext.getViewRoot().getViewId();
			String vista = currentPageViewId.substring(currentPageViewId.lastIndexOf("/") + 1);
			
			bgError.setVista_Error(vista);
		    bgError.setMetodo_Error("baja");
		    bgError.setClase_Error("BeanAlumnos");
		    bgError.setError_Error(e.getMessage()); // O cualquier otra forma de obtener el mensaje de error
			
			return "error";
		}
	}

}
