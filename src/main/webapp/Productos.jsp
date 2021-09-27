<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/menu.css" >
<link rel="stylesheet" type="text/css" href="css/style.css" >
<link rel="shortcut icon" href="img/icons8-halcón-26.png">
<meta charset="UTF-8">
<title>Producto</title>
</head>
<body>
<% 
String cod="",nit="",nom="",prec="",iva="";
if(request.getParameter("c")!=null){
cod=request.getParameter("c");
nit=request.getParameter("n");
nom=request.getParameter("no");
prec=request.getParameter("p");
iva=request.getParameter("i");
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
					<h2 class="title">Productos</h2>
					<p class="description"> 
					</p>
				<form action="Servlet_Productos" method="post">
	  
	  
	  <table>
               <tr>
                 <td>Codigo</td>
                 <th><input type="text" placeholder="Codigo Producto" name="codigo"  Value="<%=cod%>" /></th>
              </tr>
              <tr>
                 <td>NIT Proveedor </td>
                 <th><input type="text" placeholder="NIT Proveedor" name="NIT" Value="<%=nit%>" /></th>
               </tr>  
                 <tr>
                 <td>Nombre producto</td>
	            <th><input type="text" placeholder="Nombre" name="nombre" Value="<%=nom%>" /></th>
	             </tr>
	             <tr>
	             <td>Precio de compra</td>
	            <th><input type="text" placeholder="Precio compra" name="preciocompra" Value="<%=prec%>" /></th>
	             </tr>
	             <tr>
	             <tr>
                 <td>IVA</td>
                 <th><input type="text" placeholder="IVA" name="iva" Value="<%=iva%>" /></th>
                 </tr>
                  <tr>
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
			<li >
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
			<li class="active">
				<a href="Productos.jsp" style="--i: 0.2s">Producto<img src="img/proveedor.png"></a>
			</li>
		</ul>
	</div>
	<script type="text/javascript" src="js/menujs.js"></script>
</div>

</body>
</html>