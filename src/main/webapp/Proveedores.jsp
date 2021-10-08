<%@page import="javax.swing.JOptionPane"%>
<%@page import="modelo.Usuario_DTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/menu.css">

<link rel="shortcut icon" href="img/icons8-halcón-26.png">
<meta charset="UTF-8">
<title>Proveedor</title>
</head>
<body>
<%
HttpSession varsesion=request.getSession();
Usuario_DTO us=(Usuario_DTO)varsesion.getAttribute("usuario");
 if (us==null){
	JOptionPane.showMessageDialog(null, "Usted no se ha logueado");
	response.sendRedirect("index.jsp");
	 }

%>
	<%
	String doc = "", nom = "", dir = "", tel = "", ciu = "";
	if (request.getParameter("do") != null) {
		doc = request.getParameter("do");
		nom = request.getParameter("n");
		dir = request.getParameter("d");
		tel = request.getParameter("t");
		ciu = request.getParameter("c");
	}
	%>
	<div class="container">
		<div class="navbar">


			<div class="menu">
				<h3 class="logo">
					Falcon<span>Tech</span>
				</h3>
				<div id="menuu">
					<ul>
						<li style="font-size: 19px"><a href="menu.jsp">Home</a></li>
						<li style="font-size: 19px"><a href="Nosotros.jsp">Nosotros</a></li>
						<li style="font-size: 19px"><a href="#">Productos y Servicios</a></li>
						<li style="font-size: 19px" class="item-r"><a href="#">Contacto</a></li>
						<HR WIDTH=700PX SIZE=10 COLOR= #E20F2F>
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
					<div class="overlay" style="background-color: black;">
						<h2 class="title">Proveedores</h2>
						<p class="description"></p>
						<form action="Servlet_Proveedor" method="post">


							<table>
								<tr>
									<td>NIT</td>
									<th><input type="text" placeholder="NIT" name="NIT"
										Value="<%=doc%>" required /></th>
								</tr>
								<tr>
									<td>Nombre</td>
									<th><input type="text" placeholder="Nombre Proveedor"
										name="nombre" Value="<%=nom%>" /></th>
								</tr>
								<tr>
									<td>Dirección</td>
									<th><input type="text" placeholder="Dirección"
										name="direccion" Value="<%=dir%>" /></th>
								</tr>
								<tr>
									<td>Teléfono</td>
									<th><input type="text" placeholder="Teléfono"
										name="telefono" Value="<%=tel%>" /></th>
								</tr>
								<tr>
								<tr>
									<td>Ciudad</td>
									<th><input type="text" placeholder="Ciudad" name="ciudad"
										Value="<%=ciu%>" /></th>
								</tr>
								<tr>
							</table>

							<input class="boton1" type="submit" value="Insertar"
								name="btninsertar"> <input class="boton2" type="submit"
								value="Consultar" name="btnconsultar"> <input
								class="boton3" type="submit" value="Actualizar"
								name="btnactualizar"> <input class="boton4"
								type="submit" value="Eliminar" name="btneliminar">

						</form>
						<div style="font-size: 15px; margin-top: 20px;">© FalconTech.co by Equipo 1 MisionTic2022 2021</div>
					</div>
				</header>
			</div>
			<div class="shadow one"></div>
			<div class="shadow two"></div>
		</div>
		<div class="links">
			<ul>
				<li><a href="menu.jsp" style="--i: 0.05s">Home <img
						src="img/home.png"></a></li>
				<li><a href="Usuario.jsp" style="--i: 0.1s">Usuario <img
						src="img/usuario.png"></a></li>
				<li><a href="Cliente.jsp" style="--i: 0.15s">Cliente <img
						src="img/cliente.png"></a></li>
				<li class="active"><a href="Proveedores.jsp" style="--i: 0.2s">Proveedor
						<img src="img/proveedor.png">
				</a></li>
				<li><a href="Productos.jsp" style="--i: 0.2s">Producto <img
						src="img/pc.png"></a></li>
				<li><a href="Ventas.jsp" style="--i: 0.2s">Ventas <img
						src="img/ventas.png"></a></li>
				<li><a href="Reportes.jsp" style="--i:0.2s">Reportes <img
						src="img/check.png"></a></li>
			</ul>
		</div>
		<script type="text/javascript" src="js/menujs.js"></script>
	</div>

</body>
</html>