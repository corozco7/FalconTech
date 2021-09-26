<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/menu.css" >
<link rel="stylesheet" type="text/css" href="css/style.css" >
<link rel="shortcut icon" href="img/icons8-halcón-26.png">
<meta charset="UTF-8">
<title>Cliente</title>
</head>
<body>
<% 
String doc="",nom="",ape="",dir="",tel="", co="";
if(request.getParameter("do")!=null){
doc=request.getParameter("do");
nom=request.getParameter("n");
ape=request.getParameter("a");
dir=request.getParameter("d");
tel=request.getParameter("t");
co=request.getParameter("c");
}%>
<div class="container">
	<div class="navbar">

	
		<div class="menu">
			<h3 class="logo">Falcon<span>Tech</span> 	</h3>
				
		
			<div class="hamburger-menu">
				<div class="bar"></div>
			</div>
		</div>
		
	</div>
	
	<div class="main-container">
		<div class="main">
			<header>
				<div class="overlay">
					<h2 class="title">Cliente</h2>
					<p class="description">
					</p>
	  <form action="Servlet_Cliente" method="post">
	  
	  
	  <table>
               <tr>
                 <td>Documento</td>
                 <th><input type="text" placeholder="Documento" name="documento" Value="<%=doc%>" /></th>
              </tr>
              <tr>
                 <td>Nombre</td>
                 <th><input type="text" placeholder="Nombre" name="nombre"  Value="<%=nom%>"/></th>
               </tr>  
                <tr>
                 <td>Apellido</td>
                 <th><input type="text" placeholder="Apellido" name="apellido" Value="<%=ape%>"/></th>
                 </tr>
                  <tr>
                 <td>Dirección</td>
	            <th><input type="text" placeholder="Dirección" name="direccion" Value="<%=dir%>"/></th>
	             </tr>
	             <tr>
	             <td>Teléfono</td>
	            <th><input type="text" placeholder="Teléfono" name="telefono" Value="<%=tel%>"/></th>
	             </tr>
	             <tr>
	             <td>Correo</td>
	            <th><input type="text" placeholder="Correo" name="correo" Value="<%=co%>"/></th>
	             </tr>
	             
	             
	         </table>
	         
	             <input class="boton1" type="submit" value="Insertar" name="btninsertar">
	             <input class="boton2" type="submit" value="Consultar" name="btnconsultar">
	             <input class="boton3" type="submit" value="Actualizar" name="btnactualizar">
	             <input class="boton4" type="submit" value="Eliminar" name="btneliminar">
	  
	  </form>
				</div>
			</header>
		</div>
		<div class="shadow one"></div>
		<div class="shadow two"></div>
	</div>
	<div class="links">
		<ul>
			<li>
				<a href="menu.jsp" style="--i: 0.05s">Home <img src="img/home.png"></a>
			<li>
				<a href="Usuario.jsp" style="--i: 0.1s">Usuario <img src="img/usuario.png"></a>
			</li>
			<li class="active">
				<a href="Cliente.jsp" style="--i: 0.15s">Cliente <img src="img/cliente.png"></a>
			</li>
			<li>
				<a href="Proveedores.jsp" style="--i: 0.2s">Proveedor <img src="img/proveedor.png"></a>
			</li>
			
		</ul>
	</div>
	<script type="text/javascript" src="js/menujs.js"></script>
</div>

</body>
</html>