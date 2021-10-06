package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.Productos_DAO;
import modelo.Productos_DTO;

/**
 * Servlet implementation class Servlet_Productos
 */
@WebServlet("/Servlet_Productos")
public class Servlet_Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Productos() {
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
		String nom;
		int NIT, cod;
		double prec, iva, prev;
		boolean res;
		Productos_DTO prodto;
		Productos_DAO prodao;
		Productos_DTO recdatos;
		if (request.getParameter("btninsertar") != null) {
			cod = Integer.parseInt(request.getParameter("codigo"));
			NIT = Integer.parseInt(request.getParameter("NIT"));
			nom = request.getParameter("nombre");
			prec = Double.parseDouble(request.getParameter("preciocompra"));
			iva = Double.parseDouble(request.getParameter("iva"));
			prev = prec * (1 + iva / 100);

			prodto = new Productos_DTO(cod, nom, NIT, prec, iva, prev);

			prodao = new Productos_DAO();
			res = prodao.insertarproducto(prodto);
			if (res == true) {
				JOptionPane.showMessageDialog(null, "Producto Registrado");
				response.sendRedirect("Productos.jsp");
			} else {
				JOptionPane.showMessageDialog(null, "Producto No Registrado");
				response.sendRedirect("Productos.jsp");
			}

		}

	}
}
