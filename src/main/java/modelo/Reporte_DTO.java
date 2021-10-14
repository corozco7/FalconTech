package modelo;

public class Reporte_DTO {
private int cedula_cliente;
private String Nombre_cliente;
private double ventas;

public Reporte_DTO(int cedula_cliente, String nombre_cliente, double ventas) {
	super();
	this.cedula_cliente = cedula_cliente;
	Nombre_cliente = nombre_cliente;
	this.ventas = ventas;
}

public int getCedula_cliente() {
	return cedula_cliente;
}

public void setCedula_cliente(int cedula_cliente) {
	this.cedula_cliente = cedula_cliente;
}

public String getNombre_cliente() {
	return Nombre_cliente;
}

public void setNombre_cliente(String nombre_cliente) {
	Nombre_cliente = nombre_cliente;
}

public double getVentas() {
	return ventas;
}

public void setVentas(double ventas) {
	this.ventas = ventas;
}
	
	
	
	
}
