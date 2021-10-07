<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/menu.css" >
<link rel="stylesheet" type="text/css" href="css/Animacion.css" >
<link rel="shortcut icon" href="img/icons8-halcón-26.png">
<link rel="stylesheet" href="css/icomoon/font.css">

<title>Reportes</title>
</head>
<body>
<div class="container">

	<div class="navbar">
<div class="social-bar">
	
	<a href ="https://www.facebook.com/" class="icon icon-facebook" target= "_blank"><img src="https://img.icons8.com/ios-glyphs/30/000000/facebook-circled--v2.png"/></a>
	<a href ="https://twitter.com/" class="icon icon-twitter" target= "_blank"><img src="img/twitter.png"></a>
	<a href ="https://www.youtube.com/" class="icon icon-youtobe" target= "_blank"><img src="img/youtube.png"></a>
	<a href ="https://www.instagram.com/?hl=es" class="icon icon-instagram" target= "_blank"><img src="img/instagram.png"></a>
</div>

	
		<div class="menu">
			<div class="logo">Falcon<span>Tech</span> 	</div>
		
			<div id="menuu">
		<ul>
			<li><a href="menu.jsp">Home</a></li>
			<li><a href="Nosotros.jsp">Nosotros</a></li>
			<li><a href="#">Servicios</a></li>
			<li class="item-r"><a href="#">Contacto</a></li>
		</ul>
	</div>
			<div class="hamburger-menu">
			
			
							<div class="bar"> </div>
				
			</div>
			
		</div>
		
	</div>
	
	<div class="main-container">
	
		<div class="main">
			<header>
			
				<div class="overlay">
				<input class="listado" type="button" name="listadousuarios" value="Listado de usuarios" onclick="location.href='ListadoUsuarios.jsp'">
				<input class="listado" type="button" name="listadoclientes" value="Listado de clientes" onclick="location.href='ListadoClientes.jsp'">
				<input class="listado" type="button" name="listadoventas" value="Ventas por cliente" onclick="location.href='VentasCliente.jsp'">
				
				
						
				</div>
	
			</header>

		</div>
		<div class="shadow one"></div>
		<div class="shadow two"></div>
	</div>
		
	<div class="links">
	
		<ul>
			<li >
				<a href="menu.jsp" style="--i: 0.05s">Home <img src="img/home.png"></a>
				</li>
			<li>
				<a href="Usuario.jsp" style="--i: 0.1s">Usuario <img src="img/usuario.png"></a>
			</li>
			<li>
				<a href="Cliente.jsp" style="--i: 0.15s">Cliente <img src="img/cliente.png"></a>
			</li>
			<li>
				<a href="Proveedores.jsp" style="--i: 0.2s">Proveedor <img src="img/proveedor.png"></a>
			</li>
			<li>
				<a href="Productos.jsp" style="--i: 0.2s">Producto <img src="img/pc.png"></a>
			</li>
			<li >
				<a href="Ventas.jsp" style="--i: 0.2s">Ventas <img src="img/pc.png"></a>
			</li>
			<li class="active" >
				<a href="Reportes.jsp" style="--i: 0.2s">Reportes <img src="img/pc.png"></a>
			</li>
						
		</ul>
	</div>




	<script type="text/javascript" src="js/menujs.js"></script>
</div>
<div class="pie">© FalconTech.co by Equipo 1 MisionTic2022 2021</div>

</body>
</html>