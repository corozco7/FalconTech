package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controlador.Conexion;

public class DetalleVentas_DAO {

	Conexion con = new Conexion();
	Connection cnn = con.conexiondb();
	PreparedStatement ps;

	public boolean insertar(DetalleVentas_DTO detalledto) {
		int x;
		boolean dat = false;

		try {
			ps = cnn.prepareStatement(
					"INSERT INTO detalle_ventas (cantidad_producto, codigo_producto,codigo_venta, valor_venta, valor_iva,valor_total) VALUES(?,?,?,?,?,?)");
			ps.setInt(1, detalledto.getCantidad_producto());
			ps.setInt(2, detalledto.getCodigo_producto());
			ps.setInt(3, detalledto.getCodigo_venta());
			ps.setDouble(4, detalledto.getValor_venta());
			ps.setDouble(5, detalledto.getValor_IVA());
			ps.setDouble(6, detalledto.getValor_total());
			x = ps.executeUpdate();

			if (x > 0) {
				dat = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dat;
	}

}
