function Controller(varmodel, varview) {
//	Definimos una copia de this para evitar el conflicto con el this (del
//	objeto que recibe el evento)
//	en los manejadores de eventos
	var that = this;
//	referencia al modelo
	this.model = varmodel;
//	refefencia a la vista
	this.view = varview;

//	Funcion de inicialización para cargar modelo y vista, definición de manejadores
	this.init = function() {
//		Cargamos la lista de alumnos del servicio
		this.model.load();
//		Repintamos la lista de alumnos.
		this.view.list(this.model.tbAlumnos);
//		MANEJADORES DE EVENTOS

		// Manejador del botón submit del formulario de Alta y Edición
		$("#frmCRUDAlumnos").bind("submit",
				// Método que gestiona el evento de clickar el botón submit del
				// formulario
				function(event) {
			// Si el alumno cargado en el formulario tiene ID se invoca al
			// método de
			// edición
			// sino se invoca al método de alta.
			alumno = that.view.loadAlumnoFromForm();
			if ($("#id").val() == "") {
				that.model.add(alumno);
			} else {
				that.model.edit(alumno);
			}
			// Volvemos a listar los alumnos restantes para que aparezca el
			// nuevo
			// alumnos o el editado
			that.view.list(that.model.tbAlumnos);
		});



		// Manejador del enlace de edición de un alumno en la tabla
		$("#tblList").on("click", ".btnEdit",
				// Método que gestiona el evento de clickar en el evento
				function(event) {
			// Obtenemos el id del alumno seleccionado mediante el icono de
			// edición
			var id_alumno = that.view.getIdAlumno($(this));
			// Obtenemos el alumno con el id_alumno
			var alumno = that.model.find(id_alumno);
			// Cargamos el formulario con los datos del alumno seleccionado para
			// editar
			that.view.loadAlumnoInForm(alumno);
		});

		
		 // Manejador del enlace de borrado de un alumno en la tabla
        $("#tblList").on("click", ".btnDelete",
            // Método que gestiona el evento de clickar en el evento
            function (event) {
                // Obtenemos el id del alumno seleccionado mediante el icono de
                // borrado
                var id_alumno = that.view.getIdAlumno($(this));
                that.model.delete(id_alumno);
                that.view.list(that.model.tbAlumnos);
            });

	}




}