package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class Ventas_DAO {

	Conexion con = new Conexion();
	Connection cnn = con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;

	public int InsertarVenta(Ventas_DTO vendto) {
		int resultado = 0, x;
		try {
			ps = cnn.prepareStatement(
					"INSERT INTO ventas (cedula_cliente,cedula_usuario,iva_venta, valor_venta,total_venta) VALUES (?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, vendto.getCedula_cliente());
			ps.setInt(2, vendto.getCedula_usuario());
			ps.setDouble(3, vendto.getIva_venta());
			ps.setDouble(4, vendto.getValor_venta());
			ps.setDouble(5, vendto.getTotal_venta());
			x = ps.executeUpdate();
			rs = ps.getGeneratedKeys();

			if (x > 0 && rs.next()) {
				resultado = rs.getInt(1);

			}

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Ocurrio un error con el envio de los datos " + e);
		}

		return resultado;
	}

}
