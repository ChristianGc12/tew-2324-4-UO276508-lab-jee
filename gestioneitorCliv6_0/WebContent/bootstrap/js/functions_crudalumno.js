//Carga los datos del servicio sobreescribiendo el dato this.tbAlumnos.
this.load = function() {
	this.tbAlumnos = AlumnosServicesRs.getAlumnos();
}
//Llamamos al servicio de alta de alumno
this.add = function(alumno) {
//	Llamamos al servicio de alta de alumno
	AlumnosServicesRs.saveAlumno({
		$entity : alumno,
		$contentType : "application/json"
	});
//	Recargamos la lista de alumnos.
	this.load();
}
//Actualización de un alumno existente: PENDIENTE DE IMPLEMENTAR
this.edit = function(alumno) {
	  // Llamamos al servicio de actualización de alumno
	  AlumnosServicesRs.updateAlumno({
	    id: alumno.id,
	    $entity: alumno,
	    $contentType: "application/json"
	  });

	  // Buscamos el índice del alumno a editar en el array tbAlumnos
	  var index = this.tbAlumnos.findIndex(function (obj) {
	    return obj.id === alumno.id;
	  });

	  if (index !== -1) {
	    // Actualizamos el array con el alumno editado
	    this.tbAlumnos[index] = alumno;
	  }

	  // Recargamos la lista de alumnos.
	  this.load();
}

//Eliminación un alumno existente
this.remove = function(id_alumno) {
//	Llamamos al servicio de borrado de alumno
	AlumnosServicesRs.deleteAlumno({
		id : id_alumno
	});
//	Recargamos la lista de alumnos.
	this.load();
}
this.find = function(id_alumno) {
	function checkAlumno(obj) {
		return obj.id == id_alumno;
	}
//	Buscamos los datos del alumno cuyo id_alumno sea el mismo que el
//	seleccionado
	var alumno = this.tbAlumnos.find(checkAlumno);
	return alumno;
} 