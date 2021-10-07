<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/menu.css" >

<link rel="shortcut icon" href="img/icons8-halcón-26.png">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="navbar">

	
		<div class="menu">
			<h3 class="logo">Falcon<span>Tech</span> 	</h3>
				
		<div id="menuu">
		<ul>
			<li><a href="menu.jsp">Home</a></li>
			<li><a href="Nosotros.jsp">Nosotros</a></li>
			<li><a href="#">Servicios</a></li>
			<li class="item-r"><a href="#">Contacto</a></li>
		</ul>
	</div>
			<div class="hamburger-menu">
				<div class="bar"></div>
			</div>
		</div>
		
	</div>
	
	<div class="main-container">
		<div class="main">
			<header>
				<div class="overlay">
					<h2 class="title">Gestión Ventas</h2><p class="description"></p>
				<form action="Servlet_Ventas" method="post">
				<input type ="text" placeholder="Cedula" name="cedula" value="${cliente.getDocumento()}">
				<input type="text" placeholder="Nombre" name="nombre" value="${cliente.getNombre()}">
				<input type="submit" name="confirmar">
				
				<table >
				<tr> 
				<th>Codigo Producto</th>
				<th> Seleccionar </th>
				<th>Nombre producto</th>
				<th>Cantidad producto</th>
				<th>Precio total producto</th>				
				</tr>
				<tr>
				<td><input type="text" name="codigo1" value="${producto1.getCodigo()}" ></td>
				<td><input type="submit" name="verificarproducto1" ></td>
				<td><input type="text" name="nombre1" value="${producto1.getNombre_producto()}"></td>
				<td><input type="text" name="cantidad1" ></td>
				<td><input type="text" name="precio1" value="${producto1.getPrecio_compra()}"></td>
				
				</tr>
				
				<tr>
				<td><input type="text" name="codigo2" value="${producto2.getCodigo()}" ></td>
				<td><input type="submit" name="verificarproducto2" ></td>
				<td><input type="text" name="nombre2" value="${producto2.getNombre_producto()}"></td>
				<td><input type="text" name="cantidad2" ></td>
				<td><input type="text" name="precio2" value="${producto2.getPrecio_compra()}"></td>
				
				</tr>
				<tr>
				<td><input type="text" name="codigo3" value="${producto3.getCodigo()}" ></td>
				<td><input type="submit" name="verificarproducto3" ></td>
				<td><input type="text" name="nombre3" value="${producto3.getNombre_producto()}"></td>
				<td><input type="text" name="cantidad3" ></td>
				<td><input type="text" name="precio3" value="${producto3.getPrecio_compra()}"></td>
				
				</tr>
				
				<tr>
				<td colspan="5"><input type="submit" name="total" value="Enviar venta"> </td>
				</tr>
				
				</table>
				
				<input type= "hidden" name= "usuario" value="${usuario.getDocumento()}"> 
				</form>	
					
				 	
	   
	  
				</div>
			</header>
		</div>
		<div class="shadow one"></div>
		<div class="shadow two"></div>
	</div>
	<div class="links">
		<ul>
			<li >
				<a href="menu.jsp" style="--i: 0.05s">Home <img src="img/home.png"></a></li>
			<li>
				<a href="Usuario.jsp" style="--i: 0.1s">Usuario <img src="img/usuario.png"></a>
			</li>
			<li>
				<a href="Cliente.jsp" style="--i: 0.15s">Cliente <img src="img/cliente.png"></a>
			</li>
			<li>
				<a href="Proveedores.jsp" style="--i: 0.2s">Proveedor <img src="img/proveedor.png"></a>
			</li>
			<li >
				<a href="Productos.jsp" style="--i: 0.2s">Producto <img src="img/pc.png"></a>
			</li>
			<li class="active">
				<a href="Ventas.jsp" style="--i: 0.2s">Ventas <img src="img/pc.png"></a>
			</li>
			<li  >
				<a href="Reportes.jsp" style="--i: 0.2s">Reportes <img src="img/pc.png"></a>
			</li>
		</ul>
	</div>
	<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/consultar.js"></script>
	<script type="text/javascript" src="js/menujs.js"></script>
</div>
</body>
</html>