package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.Usuario_DAO;
import modelo.Usuario_DTO;

/**
 * Servlet implementation class Servlet_Usuario
 */
@WebServlet("/Servlet_Usuario")
public class Servlet_Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Usuario() {
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

		String nom, ape, cor, usu, pas;
		int d;
		boolean res;
		Usuario_DTO usdto;
		Usuario_DAO usdao;
		Usuario_DTO recdatos;
		if (request.getParameter("btninsertar") != null) {
			d = Integer.parseInt(request.getParameter("documento"));
			nom = request.getParameter("nombre");
			ape = request.getParameter("apellido");
			cor = request.getParameter("correo");
			usu = request.getParameter("usuario");
			pas = request.getParameter("pass");

			usdto = new Usuario_DTO(d, nom, ape, cor, usu, pas);
			usdao = new Usuario_DAO();
			res = usdao.insertarusuario(usdto);
			if (res == true) {
				JOptionPane.showMessageDialog(null, "Usuario Registrado");
				response.sendRedirect("Usuario.jsp");
			} else {
				JOptionPane.showMessageDialog(null, "Usuario No Registrado");
				response.sendRedirect("Usuario.jsp");
			}

		}

		if (request.getParameter("btnconsultar") != null) {
			// accion para consultar un usuario

			d = Integer.parseInt(request.getParameter("documento"));
			usdto = new Usuario_DTO(d);
			usdao = new Usuario_DAO();
			recdatos = usdao.consultarusuario(usdto);
			// se usan las mismas variables pero no hay problema por que se ejecutan en
			// distintos if

			try {

				d = recdatos.getDocumento();
				nom = recdatos.getNombre();
				ape = recdatos.getApellido();
				cor = recdatos.getCorreo();
				usu = recdatos.getUsuario();
				pas = recdatos.getPass();
				// && =concatenacion de dato viaja por la url

				response.sendRedirect("Usuario.jsp?do=" + d + "&&n=" + nom + "&&a=" + ape + "&&c=" + cor + "&&u=" + usu
						+ "&&p=" + pas);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "El usuario no existe");
				response.sendRedirect("Usuario.jsp");
			}

		}

		if (request.getParameter("btnactualizar") != null) {
			// accion para actualizar
			boolean dat;
			d = Integer.parseInt(request.getParameter("documento"));
			nom = request.getParameter("nombre");
			ape = request.getParameter("apellido");
			cor = request.getParameter("correo");
			usu = request.getParameter("usuario");
			pas = request.getParameter("pass");
			usdto = new Usuario_DTO(d, nom, ape, cor, usu, pas);
			usdao = new Usuario_DAO();
			dat = usdao.actualizar(usdto);
			if (dat == true) {
				JOptionPane.showMessageDialog(null, "El usuario se actualizo");
				response.sendRedirect("Usuario.jsp");
			} else {
				JOptionPane.showMessageDialog(null, "El usuario no se actualizo");
				response.sendRedirect("Usuario.jsp");
			}

		}
		if (request.getParameter("btneliminar") != null) {
			// accion para eliminar
			int y;
			d = Integer.parseInt(request.getParameter("documento"));
			usdto = new Usuario_DTO(d);
			usdao = new Usuario_DAO();
			y = usdao.eliminar(usdto);
			if (y > 0) {
				JOptionPane.showMessageDialog(null, "El usuario fue eliminado");
				response.sendRedirect("Usuario.jsp");
			} else {
				JOptionPane.showMessageDialog(null, "El usuario no fue eliminado");
				// response =redirigir
				response.sendRedirect("Usuario.jsp");
			}
		}
	}

}
