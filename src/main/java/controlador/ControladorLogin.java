package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.mysql.cj.Session;

import modelo.Usuario_DAO;
import modelo.Usuario_DTO;

/**
 * Servlet implementation class ControladorLogin
 */
@WebServlet("/ControladorLogin")
public class ControladorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion=request.getSession();
		String us, ps;
		Usuario_DAO log= new Usuario_DAO();
		if(request.getParameter("btnLogin") != null) {
			us=request.getParameter("usuario");
			ps=request.getParameter("pass");
			Usuario_DTO val= log.validacionLogin(us, ps);
			if(val != null) {
				sesion.setAttribute("usuario", val);
				
				request.getRequestDispatcher("menu.jsp").forward(request, response);
			}
			else {
				JOptionPane.showMessageDialog(null, "Los datos son incorrectos");
				response.sendRedirect("index.jsp");
			}
		}
		
	}

}
