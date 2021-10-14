<%@page import="javax.swing.JOptionPane"%>
<%@page import="modelo.Usuario_DTO"%>
<%@page import="modelo.Cliente_DTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Reporte_DAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/menu.css">
<link rel="stylesheet" type="text/css" href="css/Animacion.css">
<link rel="shortcut icon" href="img/icons8-halcón-26.png">
<link rel="stylesheet" href="css/icomoon/font.css">
<style>
table, th, td {
	border: 1px solid white;
}
</style>

<title>Listado Clientes</title>
</head>
<body>
	<%
	HttpSession varsesion = request.getSession();
	Usuario_DTO us = (Usuario_DTO) varsesion.getAttribute("usuario");
	if (us == null) {
		JOptionPane.showMessageDialog(null, "Usted no se ha logueado");
		response.sendRedirect("index.jsp");
	}
	%>
	<%
	Reporte_DAO rep = new Reporte_DAO();
	ArrayList<Cliente_DTO> listcli = rep.listadoclientes();
	%>
	<div class="container" id="Layer1"
		style="width: auto; height: auto; overflow: scroll;">

		<div class="navbar">
			<div class="social-bar">

				<a href="https://www.facebook.com/" class="icon icon-facebook"
					target="_blank"><img
					src="https://img.icons8.com/ios-glyphs/30/000000/facebook-circled--v2.png" /></a>
				<a href="https://twitter.com/" class="icon icon-twitter"
					target="_blank"><img src="img/twitter.png"></a> <a
					href="https://www.youtube.com/" class="icon icon-youtobe"
					target="_blank"><img src="img/youtube.png"></a> <a
					href="https://www.instagram.com/?hl=es" class="icon icon-instagram"
					target="_blank"><img src="img/instagram.png"></a>
			</div>


			<div class="menu">
				<div class="logo">
					Falcon<span>Tech</span>

				</div>


				<div id="menuu">
					<ul>
						<li style="font-size: 19px"><a href="menu.jsp">Home</a></li>
						<li style="font-size: 19px"><a href="Nosotros.jsp">Nosotros</a></li>

						<li style="font-size: 19px" class="item-r"><a
							href="contacto.jsp">Contacto</a></li>
						<HR WIDTH=700PX SIZE=10 COLOR=#E20F2F>
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
						<div class="letras">
							<h1 class="title" style="font-size: 20px">LISTADO DE
								CLIENTES</h1>
							<br>
							<table>
								<tr>
									<th style="font-size: 18px">Cédula</th>
									<th style="font-size: 18px">Nombre</th>
									<th style="font-size: 18px">Apellido</th>
									<th style="font-size: 18px">Dirección</th>
									<th style="font-size: 18px">Teléfono</th>
									<th style="font-size: 18px">Correo</th>

								</tr>
								<%
								for (Cliente_DTO cli : listcli) {
								%>
								<tr>
									<td style="font-size: 15px"><%=cli.getDocumento()%></td>
									<td style="font-size: 15px"><%=cli.getNombre()%></td>
									<td style="font-size: 15px"><%=cli.getApellido()%></td>
									<td style="font-size: 15px"><%=cli.getDireccion()%></td>
									<td style="font-size: 15px"><%=cli.getTelefono()%></td>
									<td style="font-size: 15px"><%=cli.getCorreo()%></td>

								</tr>



								<%
								}
								%>






							</table>
						</div>
						<br> <br>
						<div style="font-size: 15px; margin-top: 20px;">©
							FalconTech.co by Equipo 1 MisionTic2022 2021</div>
					</div>
				</header>

			</div>
			<div class="shadow one"></div>
			<div class="shadow two"></div>
		</div>

		<div class="links">

			<ul>
				<li><a href="menu.jsp" style="-i: 0.05s">Home <img
						src="img/home.png"></a></li>
				<li><a href="Usuario.jsp" style="-i: 0.1s">Usuario <img
						src="img/usuario.png"></a></li>
				<li><a href="Cliente.jsp" style="-i: 0.15s">Cliente <img
						src="img/cliente.png"></a></li>
				<li><a href="Proveedores.jsp" style="-i: 0.2s">Proveedor <img
						src="img/proveedor.png"></a></li>
				<li><a href="Productos.jsp" style="-i: 0.2s">Producto <img
						src="img/pc.png"></a></li>
				<li><a href="Ventas.jsp" style="-i: 0.2s">Ventas <img
						src="img/ventas.png"></a></li>
				<li class="active"><a href="Reportes.jsp" style="-i: 0.2s">Reportes
						<img src="img/check.png">
				</a></li>

			</ul>
		</div>




		<script type="text/javascript" src="js/menujs.js"></script>
	</div>
	<div class="pie">© FalconTech.co by Equipo 1 MisionTic2022 2021</div>


</body>
</html>