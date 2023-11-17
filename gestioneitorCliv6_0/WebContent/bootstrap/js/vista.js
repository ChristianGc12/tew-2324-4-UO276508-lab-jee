function View(){
	this.list = function(lista) {
		$("#tblList").html("");
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
		}
	}


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
		// Pintamos los datos alumnos sobre el formularios de alta/edición
		$("#id").val(alumno.id);
		$("#iduser").val(alumno.iduser);
		$("#nombre").val(alumno.nombre);
		$("#apellidos").val(alumno.apellidos);
		$("#email").val(alumno.email);
		$("#iduser").focus(); // Ponemos el foco en el campo Nombre.
	}

	this.getIdAlumno = function (celda) {
		// Implementa la lógica para obtener el ID del alumno seleccionado
		var fila = $(celda).closest("tr");
		var idAlumno = fila.find("td:eq(1)").text();
		return idAlumno;
	}


};