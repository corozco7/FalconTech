package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controlador.Conexion;

public class Reporte_DAO {
	Conexion con = new Conexion();

	Connection cnn = con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;

	public ArrayList<Usuario_DTO> listadousuarios() {
		ArrayList<Usuario_DTO> lista = new ArrayList<Usuario_DTO>();
		try {
			ps = cnn.prepareStatement("SELECT * FROM usuarios ");
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario_DTO us = new Usuario_DTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
				lista.add(us);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;

	}

	public ArrayList<Cliente_DTO> listadoclientes() {
		ArrayList<Cliente_DTO> lista = new ArrayList<Cliente_DTO>();
		try {
			ps = cnn.prepareStatement("SELECT * FROM clientes ");
			rs = ps.executeQuery();
			while (rs.next()) {
				Cliente_DTO cli = new Cliente_DTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
				lista.add(cli);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;

	}

	public ArrayList<Reporte_DTO> listadoventas() {
		ArrayList<Reporte_DTO> lista = new ArrayList<Reporte_DTO>();
		ArrayList<Cliente_DTO> clientes = listadoclientes();

		for (Cliente_DTO cli : clientes) {
			int totalventas = 0;
			try {
				ps = cnn.prepareStatement("SELECT total_venta FROM ventas WHERE cedula_cliente=?");
				ps.setInt(1, cli.getDocumento());
				rs = ps.executeQuery();
				while (rs.next()) {

					totalventas += rs.getInt(1);

				}

				if (totalventas != 0) {
					Reporte_DTO rep = new Reporte_DTO(cli.getDocumento(), cli.getNombre() + ' ' + cli.getApellido(),
							totalventas);
					lista.add(rep);

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return lista;

	}

}
