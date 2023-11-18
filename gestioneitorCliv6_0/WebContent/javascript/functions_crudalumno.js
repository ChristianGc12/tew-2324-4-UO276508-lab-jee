/**
 * 
 */

//Clase que contiene el Modelo de la aplicaciÃ³n. 
function Model(){
	//Lista de alumnos.
	this.tbAlumnos = null;

	//Carga los datos del servicio sobreescribiendo el dato this.tbAlumnos.
	this.load = function() {
		this.tbAlumnos = AlumnosServicesRs.getAlumnos();
	}
	//Llamamos al servicio de alta de alumno
	this.add = function(alumno) {
//		Llamamos al servicio de alta de alumno
		AlumnosServicesRs.saveAlumno({
			$entity : alumno,
			$contentType : "application/json"
		});
//		Recargamos la lista de alumnos.
		this.load();
	}
	//ActualizaciÃ³n de un alumno existente: PENDIENTE DE IMPLEMENTAR
	this.edit = function(alumno) {
		//Llamar al servicio de ediciÃ³n de un alumno
		AlumnosServicesRs.updateAlumno({
			$entity : alumno,
			$contentType : "application/json"
		});
//		Recargamos la lista de alumnos.
		this.load();
	}

	//EliminaciÃ³n un alumno existente
	this.remove = function(id_alumno) {
//		Llamamos al servicio de borrado de alumno
		AlumnosServicesRs.deleteAlumno({
			id : id_alumno
		});
//		Recargamos la lista de alumnos.
		this.load();
	}
	this.find = function(id_alumno) {
		function checkAlumno(obj) {
			return obj.id == id_alumno;
		}
//		Buscamos los datos del alumno cuyo id_alumno sea el mismo que el
//		seleccionado
		var alumno = this.tbAlumnos.find(checkAlumno);
		return alumno;
	}
};



$(function() {
	//Creamos el modelo con los datos y la conexiÃ³n al servicio web.
	var model = new Model();
	model.load();
});
//Clase que contiene la gestiÃ³n de la capa Vista
function View(){
	this.list = function (lista) {$("#tblList").html("");
	$("#tblList").html( "<thead>" + "<tr>" + "<th></th>" 
			+ "<th>ID</th>" + "<th>IDUser</th>" + "<th>Nombre</th>"
			+ "<th>Apellidos</th>" + "<th>Email</th>" + "</tr>"
			+ "</thead>" + "<tbody>" + "</tbody>");
	for ( var i in lista) {
		var alumno = lista[i];
		$("#tblList tbody").append("<tr> <td>" 
				+ "<img src='icons/edit.png' class='btnEdit'/>"
				+ "<img src='icons/delete.png' class='btnDelete'/> </td>"
				+ "<td>" + alumno.id + "</td>" + "<td>" + alumno.iduser + "</td>" 
				+ "<td>" + alumno.nombre + "</td>" + "<td>" + alumno.apellidos + "</td>" 
				+ "<td>" + alumno.email + "</td></tr>");
	}}
	this.loadAlumnoFromForm = function() {
		// Cogemos el alumno nuevo del formulario.
		var alumno = {
				id : $("#id").val(),
				iduser : $("#iduser").val(),
				nombre : $("#nombre").val(),
				apellidos : $("#apellidos").val(),
				email : $("#email").val()
		};
		return alumno;
	}

	this.loadAlumnoInForm = function(alumno) {
		// Pintamos los datos alumnos sobre el formularios de alta/ediciÃ³n
		$("#id").val(alumno.id);
		$("#iduser").val(alumno.iduser);
		$("#nombre").val(alumno.nombre);
		$("#apellidos").val(alumno.apellidos);
		$("#email").val(alumno.email);
		$("#iduser").focus(); // Ponemos el foco en el campo Nombre.
	}
	this.getIdAlumno = function(celda) {
		// Accedemos a la fila que estÃ¡ por encima de esta celda
		// (closest('tr'))y despues obtenemos todas las celdas de esa fila
		// (find('tr')) y
		// nos quedamos con la segunda (get(1)) que es la contiene el "id" del
		// alumno.
		var id_alumno = parseInt(celda.closest('tr').find('td').get(1).innerHTML);
		return id_alumno;
	}
};
//Clase que encapsula al controlador
function Controller(varmodel, varview) {
	// Definimos una copia de this para evitar el conflicto con el this (del
	// objeto que recibe el evento)
	// en los manejadores de eventos 
	var that = this;
	// referencia al modelo
	this.model = varmodel;
	// refefencia a la vista
	this.view = varview;
	// Funcion de inicializaciÃ³n para cargar modelo y vista, definiciÃ³n de manejadores
	this.init = function() {
		// Cargamos la lista de alumnos del servicio
		this.model.load();
		// Repintamos la lista de alumnos.
		this.view.list(this.model.tbAlumnos);
		
	}
// MANEJADORES DE EVENTOS
		//Manejador del botÃ³n submit del formulario de Alta y EdiciÃ³n
		$("#frmCRUDAlumnos").bind("submit",
//				MÃ©todo que gestiona el evento de clickar el botÃ³n submit del
//				formulario
				function(event) {
//			Si el alumno cargado en el formulario tiene ID se invoca al
//			mÃ©todo de
//			ediciÃ³n
//			sino se invoca al mÃ©todo de alta.
			alumno = that.view.loadAlumnoFromForm();
			if ($("#id").val() == "") {
				that.model.add(alumno);
			} else {
				that.model.edit(alumno);
			}
//			Volvemos a listar los alumnos restantes para que aparezca el
//			nuevo
//			alumnos o el editado
			that.view.list(that.model.tbAlumnos);
		});

		//Manejador del enlace de ediciÃ³n de un alumno en la tabla
		$("#tblList").on("click", ".btnEdit",
				// MÃ©todo que gestiona el evento de clickar en el evento
				function(event) {
			
			// Obtenemos el id del alumno seleccionado mediante el icono de
			// ediciÃ³n
			var id_alumno = that.view.getIdAlumno($(this));
			// Obtenemos el alumno con el id_alumno
			var alumno = that.model.find(id_alumno);
			// Cargamos el formulario con los datos del alumno seleccionado para
			// editar
			that.view.loadAlumnoInForm(alumno);
		});
		
		$("#tblList").on("click", ".btnDelete",
				// MÃ©todo que gestiona el evento de clickar en el evento
				function(event) {

			// Obtenemos el id del alumno seleccionado mediante el icono de
			// ediciÃ³n
			var id_alumno = that.view.getIdAlumno($(this));
			// Obtenemos el alumno con el id_alumno
			that.model.remove(id_alumno);
			// Cargamos el formulario con los datos del alumno seleccionado para
			// editar
			that.view.list(that.model.tbAlumnos);
		});
		
		
		
		
};

$(function() {
	// Creamos el modelo con los datos y la conexiÃ³n al servicio web.
	var model = new Model();
	// Creamos la vista que incluye acceso al modelo.
	var view = new View();
	// Creamos el controlador
	var control = new Controller(model, view);
	// Iniciamos la aplicaciÃ³n
	control.init();
	});

