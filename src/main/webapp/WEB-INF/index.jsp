<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro e Inicio de Sesión</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="css/login.css">
<script src="https://kit.fontawesome.com/0e449a2871.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="container " id="container">
		<div class="form-container register-container overflow-auto">
				<form:form action="/registro" method="post" modelAttribute="nuevoUsuario">
				<h2>Registrarte</h2>
					<div>
						<form:label path="nombre">Nombre</form:label>
						<form:input path="nombre" class="form-control"  required="required" />  <!--  el required coloca una nota de "Completa este campo"  para ello se elimina en el models User los Menssages y los @NotNull-->
						<form:errors path="nombre" class="text-danger" />
					</div>
					<div>
						<form:label path="email">E-mail</form:label>
						<form:input path="email" class="form-control"  required="required" />
						<form:errors path="email" class="text-danger" />
					</div>
					<div>
						<form:label path="contrasena">Contraseña</form:label>
						<form:password path="contrasena" class="form-control" />
						<form:errors path="contrasena" class="text-danger" />
					</div>
					<div>
						<form:label path="confirmacion">Confirmación</form:label>
						<form:password path="confirmacion" class="form-control" />
						<form:errors path="confirmacion" class="text-danger" />
					</div>
					<button>Registrarse</button>
				</form:form>
		</div>
		
		<div class="form-container login-container">
				<p class="text-danger">${error_login}</p>
				<form action="/login" method="post">
				<h2>Inicia Sesión</h2>
					<div>
						<label>E-mail</label>
						<input type="text" class="form-control" name="email"  required="required"/>
					</div>
					<div>
						<label>Contraseña</label>
						<input type="password" class="form-control" name="contrasena"  required="required" />
					</div>
					<button>Iniciar Sesión</button>
				</form>
		</div>
			
		<div class="overlay-container">
			<div class="overlay">
		        <div class="overlay-panel overlay-left">
			          <h1 class="title">Hola <br> amigos/as</h1>
			          <p>Si tienes una cuenta, inicia sesión aquí.</p>
		          <button class="ghost" id="loginButton">Iniciar Sesión
		          </button>
		        </div>
		        <div class="overlay-panel overlay-right">
		          <h1 class="title">Empieza <br> ahora</h1>
		          <p>Regístrate y gestiona tareas, toma notas y encuentra motivación para alcanzar tus metas.</p>
		          <button class="ghost" id="registerButton">Registrarse
		          </button>
		        </div>
			</div>
	    </div>
			
</div>
<script src="../js/script.js"></script>
</body>
</html>