package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class CSV_DAO {
	

	Conexion con=new Conexion();
	Connection cnn=con.conexiondb();
	PreparedStatement ps;
	
	public boolean cargarProducto(String URL) {
		
			boolean resul=false;
			try {
				
		
				ps=cnn.prepareStatement( "load data infile '"+URL+"' into table productos fields terminated by ';'  lines terminated  by '\r\n';");
				JOptionPane.showMessageDialog(null, "en try");
			
			resul=ps.executeUpdate()>0;
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null,"Error al registrar producto: "+ e);
				//e.printStackTrace();
			
			}
			return resul;
		}

	
}
