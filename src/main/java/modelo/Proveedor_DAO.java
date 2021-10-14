package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class Proveedor_DAO {
	Conexion con = new Conexion();
	Connection cnn = con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	Proveedor_DTO pro;

	public boolean insertarproveedor(Proveedor_DTO pr) {
		int x;
		boolean dat = false;
		try {
			pro = consultarproveedor(pr);
			if (pro == null) {
				ps = cnn.prepareStatement("INSERT INTO proveedores VALUES(?,?,?,?,?)");
				ps.setInt(1, pr.getNIT());
				ps.setString(2, pr.getNombre());
				ps.setString(3, pr.getDireccion());
				ps.setString(4, pr.getTelefono());
				ps.setString(5, pr.getCiudad());

				x = ps.executeUpdate();
				if (x > 0) {
					dat = true;

				}
			}

			else {
				JOptionPane.showMessageDialog(null, "El proveedor ya existe");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al insertar" + e);
		}
		return dat;
	}

	public Proveedor_DTO consultarproveedor(Proveedor_DTO pr) {
		// ps es el enlace con my sql
		try {
			ps = cnn.prepareStatement("SELECT * FROM proveedores WHERE NIT=?");
			ps.setInt(1, pr.getNIT());
			rs = ps.executeQuery();
			// .next me permite ver si por lo menos hay un resgistro
			if (rs.next()) {
				pro = new Proveedor_DTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return pro;
	}

	public int eliminar(Proveedor_DTO pr) {
		int x = 0;
		try {
			ps = cnn.prepareStatement("DELETE FROM proveedores WHERE NIT=?");
			ps.setInt(1, pr.getNIT());
			x = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}

	public boolean actualizar(Proveedor_DTO pro) {
		boolean dat = false;
		int x;
		try {
			ps = cnn.prepareStatement("UPDATE proveedores SET Nombre=?, Direccion=?, Telefono=?, Ciudad=? WHERE NIT=?");
			ps.setString(1, pro.getNombre());
			ps.setString(2, pro.getDireccion());
			ps.setString(3, pro.getTelefono());
			ps.setString(4, pro.getCiudad());
			ps.setInt(5, pro.getNIT());
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
