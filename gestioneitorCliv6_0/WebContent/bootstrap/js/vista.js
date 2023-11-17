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

		
		this.loadAlumnoFromForm = function () {
			
	        var id = $("#id").val();
	        var iduser = $("#iduser").val();
	        var nombre = $("#nombre").val();
	        var apellidos = $("#apellidos").val();
	        var email = $("#email").val();

	        // Crea y retorna un objeto alumno con los datos obtenidos
	        var alumno = {
	            id: id,
	            iduser: iduser,
	            nombre: nombre,
	            apellidos: apellidos,
	            email: email
	        };

	        return alumno;
			
		} // PENDIENTE DE IMPLEMENTAR
		this.loadAlumnoInForm = function (alumno) {
	        // Implementa la lógica para cargar los datos del alumno en el formulario
	        $("#id").val(alumno.id);
	        $("#iduser").val(alumno.iduser);
	        $("#nombre").val(alumno.nombre);
	        $("#apellidos").val(alumno.apellidos);
	        $("#email").val(alumno.email);
			
		} // PENDIENTE DE IMPLEMENTAR
		
		this.getIdAlumno = function (celda) {
		        // Implementa la lógica para obtener el ID del alumno seleccionado
		        var fila = $(celda).closest("tr");
		        var idAlumno = fila.find("td:eq(1)").text();
		        return idAlumno;
		}
			
		
	};