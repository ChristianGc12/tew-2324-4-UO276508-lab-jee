function Model() {

	this.login = function(user) {
		return LoginServiceRs.login({
			$entity : user,
			$contentType : "application/json"});
	}
	
	this.setToken = function(token) {
		sessionStorage.setItem("token", token);
	}
};
function View() {
	this.loadUserFromForm = function() {
		var user = {
				login : $("#username").val(),
				password : $("#passwd").val()
		};
		return user;
	}
	this.loadUserInForm = function(user) {
		$("#username").val(user.login);
		$("#passwd").val(user.password);
	}
};
function Controller(varmodel, varview) {
	var that = this;
	this.model = varmodel;
	this.view = varview;
	this.init = function() {
		$("#login").bind("submit",
				function(event) {
			user = that.view.loadUserFromForm();
			var token = that.model.login(user)
			console.log(token);
			if (token == "") {
//				TODO: Mostrar mensaje de login incorrecto
				console.log("Login incorrecto");
			} else {
				that.model.setToken(token);
				$("#formulario").attr("data", "crudAlumno.html")
			}
		});
	}
}


$(function() {
	var model = new Model();
	var view = new View();
	var control = new Controller(model, view);
	control.init();
});


