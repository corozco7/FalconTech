<%@page import="javax.swing.JOptionPane"%>
<%@page import="modelo.Usuario_DTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/menu.css" >
<link rel="stylesheet" type="text/css" href="css/Animacion.css" >
<link rel="shortcut icon" href="img/icons8-halcón-26.png">
<link rel="stylesheet" href="css/icomoon/font.css">

<meta charset="UTF-8">
<title>Falcon Tech</title>

</head>
<body>
<%
HttpSession varsesion=request.getSession();
Usuario_DTO us=(Usuario_DTO)varsesion.getAttribute("usuario");
 if (us==null){
	// JOptionPane.showMessageDialog(null, us);
	 }

%>

<div class="container" id="Layer1" style="width:auto; height:auto; overflow: scroll;">

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
						<li style="font-size: 19px"><a href="menu.jsp">Home</a></li>
						<li style="font-size: 19px"><a href="Nosotros.jsp">Nosotros</a></li>
					
						<li style="font-size: 19px" class="item-r"><a href="contacto.jsp">Contacto</a></li>
						<HR WIDTH=700PX SIZE=10 COLOR= #E20F2F>
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
				<div class="overlay" style="background-color: black;">
				<br>
				<br>
				
					<div class="title" style="background-color: black;">¡Nosotros somos</div> <div  style="margin:0;padding:0;background-color: black;" class="logo">Falcon<span>Tech!</span> 	</div>
					<div class="letter" Style="text-align: center ; margin-left: 70px; margin-right: 70px; background-color: black; color:white; font-family: Montserrat; font-size: 20px"> Somos una empresa creada para las personas del mundo, buscamos innovar con tecnologia de ultima genereacion el mundo entero.</div>
					<br>
					
					<div style="font-family: Share Tech Mono; font-size: 20px; align-content: center;">Nuestro equipo</div>
					<br>
					<div class="name" style="font-family: Share Tech Mono; font-size: 20px;"> Cesar Orozco &nbsp &nbsp  Diana Penagos  &nbsp &nbsp  Saira Puentes  &nbsp &nbsp   Laura Rios</div>
				
					<div class="avatar"> <img src="img/cesar.png"> &nbsp &nbsp &nbsp &nbsp  <img src="img/diana}.png">  &nbsp &nbsp  <img src="img/saira.png">  &nbsp &nbsp &nbsp  <img src="img/Laura.png"></div>
							<br>
							<br>
							<br>
							<br>
						
							<div style="font-size: 15px">© FalconTech.co by Equipo 1 MisionTic2022 2021</div>	
				</div>
	
			</header>

		</div>
		<div class="shadow one"></div>
		<div class="shadow two"></div>
	</div>
		
	<div class="links">
	
		<ul>
			<li class="active">
				<a href="menu.jsp" style="--i: 0.05s">Home <img src="img/home.png"></a>
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
			<li><a href="Ventas.jsp" style="--i: 0.2s">Ventas <img
						src="img/ventas.png"></a></li>
			<li><a href="Reportes.jsp" style="--i: 0.2s">Reportes <img
						src="img/check.png"></a></li>
		</ul>
	</div>

	<script type="text/javascript" src="js/menujs.js"></script>
</div>


</body>
</html>