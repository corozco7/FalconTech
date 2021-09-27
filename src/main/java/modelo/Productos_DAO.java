package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class Productos_DAO {
	
	Conexion con=new Conexion();
	Connection cnn=con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	
	Productos_DTO pro;
	
	public boolean insertarproducto(Productos_DTO produc) {
		int x;
		
		boolean dat=false;
		try {
			pro=consultarproducto(produc);
			if(pro==null) {
			ps=cnn.prepareStatement("INSERT INTO productos VALUES(?,?,?,?,?,?)");
		    ps.setInt(1, produc.getCodigo());
		    ps.setInt(2, produc.getNIT_proveedor());
		    ps.setString(3, produc.getNombre_producto());
		    ps.setDouble(4, produc.getPrecio_compra());
		    ps.setDouble(5, produc.getIva_compra());
		    ps.setDouble(6, produc.getPrecio_venta());
		    x= ps.executeUpdate();
		if(x>0) {
			dat=true;
			
		}}
		
			else {
			JOptionPane.showMessageDialog(null, "El producto ya existe");
		}
			
		} catch (SQLException e) {
	    JOptionPane.showMessageDialog(null, "Error al insertar"+e);
		}
		return dat;
	}
	
	public Productos_DTO consultarproducto(Productos_DTO produc) {
		//ps es el enlace con my sql
		
		try {
			ps=cnn.prepareStatement("SELECT * FROM productos WHERE Codigo=?");
		    ps.setInt(1, produc.getCodigo());
		    rs=ps.executeQuery();
		    //.next me permite ver si por lo menos hay un resgistro
		    if(rs.next()) {
		     pro= new Productos_DTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
		    }
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
return pro;
	}

	public int eliminar(Productos_DTO produc) {
		int x=0;
		try {
			ps=cnn.prepareStatement("DELETE FROM productos WHERE Codigo=?");
		    ps.setInt(1, produc.getCodigo());
		   x= ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return x;
	}
	
	public boolean actualizar(Productos_DTO produc) {
		boolean dat=false;
		int x;
		try {
			ps=cnn.prepareStatement("UPDATE productos SET NIT_proveedor=?, nombre_producto=?, precio_compra=?, iva_compra=?, precio_venta=? WHERE Codigo=?");
		    ps.setInt(1, produc.getNIT_proveedor());
		    ps.setString(2, produc.getNombre_producto());
		    ps.setDouble(3, produc.getPrecio_compra()); 
		    ps.setDouble(4, produc.getIva_compra());
		    ps.setDouble(4, produc.getPrecio_venta());
		    ps.setInt(5, produc.getCodigo());
		   x= ps.executeUpdate();
		   if(x>0) {
			   dat= true;
		   }
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dat;
	}
	
}
