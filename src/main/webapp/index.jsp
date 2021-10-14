<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="shortcut icon" href="img/icons8-halcón-26.png">
<meta charset="ISO-8859-1">
<title>FALCON TECH</title>
</head>
<body>



	<div class="container" onclick="onclick">
		<div class="top"></div>
		<div class="bottom"></div>
		<div class="center">
			<h2>
				Falcon <span class="rojo">Tech</span>
			</h2>

			<form action="ControladorLogin" method="post">
				<input type="text" placeholder="Usuario" name="usuario" /> <input
					type="password" placeholder="Contraseña" name="pass" /> <input
					type="submit" name="btnLogin" value="Ingresar" />
			</form>

			<h2>&nbsp;</h2>
		</div>
	</div>
</body>
</html>