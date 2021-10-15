package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	Connection cnn;
	public Connection conexiondb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("org.mariadb.jdbc.Driver");

		try {
			cnn=DriverManager.getConnection("jdbc:mysql://localhost/falcon_tech","root","");
			//cnn=DriverManager.getConnection("jdbc:mariadb://tiendagenericagrupo43-10-32.czo3ixoe3xoe.us-east-1.rds.amazonaws.com/Falcon_tech","admin","123456789");
			
		} catch (SQLException e) {
			e.printStackTrace();
					
		}
			
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cnn;
	}
}
