<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="css/styles.css">
<script src="https://kit.fontawesome.com/0e449a2871.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
		<nav class="d-flex justify-content-between align-items-center">
			<h1>¡Bienvenid@ ${usuarioEnSesion.nombre}!</h1>
			<a href="/logout" class="btn btn-outline-dark">Cerrar Sesión <i class="fa-regular fa-face-frown"></i></a>
			<!--img src="/images/gatito_small.jpg" alt="gatito"-->
		</nav>
	</div>

</body>
</html>