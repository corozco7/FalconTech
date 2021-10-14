package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.Proveedor_DAO;
import modelo.Proveedor_DTO;

/**
 * Servlet implementation class Servlet_Proveedor
 */
@WebServlet("/Servlet_Proveedor")
public class Servlet_Proveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom, dir, tel, ciu;
		int n;
		boolean res;
		Proveedor_DTO prdto;
		Proveedor_DAO prdao;
		Proveedor_DTO recdatos;
		if (request.getParameter("btninsertar") != null) {
			n = Integer.parseInt(request.getParameter("NIT"));
			nom = request.getParameter("nombre");
			dir = request.getParameter("direccion");
			tel = request.getParameter("telefono");
			ciu = request.getParameter("ciudad");

			prdto = new Proveedor_DTO(n, nom, dir, tel, ciu);
			prdao = new Proveedor_DAO();
			res = prdao.insertarproveedor(prdto);
			if (res == true) {
				JOptionPane.showMessageDialog(null, "Proveedor Registrado");
				response.sendRedirect("Proveedores.jsp");
			} else {
				JOptionPane.showMessageDialog(null, "Proveedor No Registrado");
				response.sendRedirect("Proveedores.jsp");
			}

		}

		if (request.getParameter("btnconsultar") != null) {
			// accion para consultar un usuario

			n = Integer.parseInt(request.getParameter("NIT"));
			prdto = new Proveedor_DTO(n);
			prdao = new Proveedor_DAO();
			recdatos = prdao.consultarproveedor(prdto);
			// se usan las mismas variables pero no hay problema por que se ejecutan en
			// distintos if

			try {
				n = recdatos.getNIT();
				nom = recdatos.getNombre();
				dir = recdatos.getDireccion();
				tel = recdatos.getTelefono();
				ciu = recdatos.getCiudad();

				// && =concatenacion de dato viaja por la url
				response.sendRedirect(
						"Proveedores.jsp?do=" + n + "&&n=" + nom + "&&d=" + dir + "&&t=" + tel + "&&c=" + ciu);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "El proveedor no existe");
				response.sendRedirect("Proveedores.jsp");
			}

		}

		if (request.getParameter("btnactualizar") != null) {
			// accion para actualizar
			boolean dat;
			n = Integer.parseInt(request.getParameter("NIT"));
			nom = request.getParameter("nombre");
			dir = request.getParameter("direccion");
			tel = request.getParameter("telefono");
			ciu = request.getParameter("ciudad");

			prdto = new Proveedor_DTO(n, nom, dir, tel, ciu);
			prdao = new Proveedor_DAO();
			dat = prdao.actualizar(prdto);
			if (dat == true) {
				JOptionPane.showMessageDialog(null, "El proveedor se actualizo");
				response.sendRedirect("Proveedores.jsp");
			} else {
				JOptionPane.showMessageDialog(null, "El proveedor no se actualizo");
				response.sendRedirect("Proveedores.jsp");
			}

		}
		if (request.getParameter("btneliminar") != null) {
			// accion para eliminar
			int y;
			n = Integer.parseInt(request.getParameter("NIT"));
			prdto = new Proveedor_DTO(n);
			prdao = new Proveedor_DAO();
			y = prdao.eliminar(prdto);
			if (y > 0) {
				JOptionPane.showMessageDialog(null, "El proveedor fue eliminado");
				response.sendRedirect("Proveedores.jsp");
			} else {
				JOptionPane.showMessageDialog(null, "El proveedor no fue eliminado");
				// response =redirigir
				response.sendRedirect("Proveedores.jsp");
			}
		}
	}

}
