package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class Usuario_DAO {
	Conexion con = new Conexion();
	Connection cnn = con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	Usuario_DTO usu;

	public boolean insertarusuario(Usuario_DTO us) {
		int x;
		boolean dat = false;
		try {
			usu = consultarusuario(us);
			if (usu == null) {
				ps= cnn.prepareStatement("SELECT Usuario FROM usuarios WHERE Usuario=?");
				ps.setString(1, us.getUsuario());
				rs=ps.executeQuery();
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "El usuario ya existe");
					return dat;
				}
				else {
					ps = cnn.prepareStatement("INSERT INTO usuarios VALUES(?,?,?,?,?,?)");
					ps.setInt(1, us.getDocumento());
					ps.setString(2, us.getNombre());
					ps.setString(3, us.getApellido());
					ps.setString(4, us.getCorreo());
					ps.setString(5, us.getUsuario());
					ps.setString(6, us.getPass());
					x = ps.executeUpdate();
					if (x > 0) {
						dat = true;
						
					}
				}
			}

			else {
				JOptionPane.showMessageDialog(null, "El usuario ya existe");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al insertar" + e);
		}
		return dat;
	}

	public Usuario_DTO consultarusuario(Usuario_DTO us) {
		// ps es el enlace con my sql
		try {
			ps = cnn.prepareStatement("SELECT * FROM usuarios WHERE documento=?");
			ps.setInt(1, us.getDocumento());
			rs = ps.executeQuery();
			// .next me permite ver si por lo menos hay un resgistro
			if (rs.next()) {
				usu = new Usuario_DTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return usu;
	}

	public int eliminar(Usuario_DTO us) {
		int x = 0;
		try {
			ps = cnn.prepareStatement("DELETE FROM usuarios WHERE documento=?");
			ps.setInt(1, us.getDocumento());
			x = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}

	public boolean actualizar(Usuario_DTO usu) {
		boolean dat = false;
		int x;
		try {
			ps = cnn.prepareStatement(
					"UPDATE usuarios SET Nombre=?, Apellido=?, Correo=?, Usuario=?, Contraseña=? WHERE documento=?");
			ps.setString(1, usu.getNombre());
			ps.setString(2, usu.getApellido());
			ps.setString(3, usu.getCorreo());
			ps.setString(4, usu.getUsuario());
			ps.setString(5, usu.getPass());
			ps.setInt(6, usu.getDocumento());
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

	public Usuario_DTO validacionLogin(String Usuario, String Pass) {
		try {
			ps = cnn.prepareStatement("SELECT * FROM usuarios where Usuario=? AND Contraseña=?");
			ps.setString(1, Usuario);
			ps.setString(2, Pass);
			rs = ps.executeQuery();
			if (rs.next()) {
				usu = new Usuario_DTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usu;

	}

}
