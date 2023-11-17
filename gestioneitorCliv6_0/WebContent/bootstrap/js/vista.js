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

	This.getIdAlumno = function(celda) {
		// Accedemos a la fila que está por encima de esta celda
		// (closest('tr'))y despues obtenemos todas las celdas de esa fila
		// (find('tr')) y
		// nos quedamos con la segunda (get(1)) que es la contiene el "id" del
		// alumno.
		var id_alumno = parseInt(celda.closest('tr').find('td').get(1).innerHTML);
		return id_alumno;
		}

};