package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.Cliente_DAO;
import modelo.Cliente_DTO;

/**
 * Servlet implementation class Servlet_Cliente
 */
@WebServlet("/Servlet_Cliente")
public class Servlet_Cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_Cliente() {
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
		

		String nom,ape,dir,tel,co;
		int d;
		boolean res;
		Cliente_DTO usdto;
		Cliente_DAO usdao;
		Cliente_DTO recdatos;
		if(request.getParameter("btninsertar")!=null) {
			d=Integer.parseInt(request.getParameter("documento"));
			nom=request.getParameter("nombre");
			ape=request.getParameter("apellido");
			dir=request.getParameter("direccion");
			tel=request.getParameter("telefono");
			co=request.getParameter("correo");
						
	    usdto= new Cliente_DTO(d, nom, ape, dir, tel, co);
		usdao= new Cliente_DAO();
		res=usdao.insertarusuario(usdto);
		if (res==true) {
			JOptionPane.showMessageDialog(null, "Cliente Registrado");
			response.sendRedirect("Cliente.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "Cliente No Registrado");
			response.sendRedirect("Cliente.jsp");
		}
			
		}
		
		if (request.getParameter("btnconsultar")!=null) {
			//accion para consultar un usuario
			
		d=Integer.parseInt(request.getParameter("documento"));
		usdto=new Cliente_DTO(d);
		usdao=new Cliente_DAO();
		recdatos=usdao.consultarusuario(usdto);
			//se usan las mismas variables pero no hay problema por que se ejecutan en distintos if
		
		try {
			d=recdatos.getDocumento();
			nom=recdatos.getNombre();
			ape=recdatos.getApellido();
			dir=recdatos.getDireccion();
			tel=recdatos.getTelefono();
			co=recdatos.getCorreo();
			//&& =concatenacion de dato viaja por la url
			response.sendRedirect("Cliente.jsp?do="+d+"&&n="+nom+"&&a="+ape+"&&d="+dir+"&&t="+tel+"&&c="+co);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El cliente no existe");
			response.sendRedirect("Cliente.jsp");
		}
		
		
		
		}
		
		
		if (request.getParameter("btnactualizar")!=null) {
			//accion para actualizar
			boolean dat;
			d=Integer.parseInt(request.getParameter("documento"));
			nom=request.getParameter("nombre");
			ape=request.getParameter("apellido");
			dir=request.getParameter("direccion");
			tel=request.getParameter("telefono");
			co=request.getParameter("correo");
			usdto=new Cliente_DTO(d, nom, ape, dir, tel, co);
			usdao=new Cliente_DAO();
			dat=usdao.actualizar(usdto);
			if(dat==true) {
				JOptionPane.showMessageDialog(null, "El cliente se actualizo");
				response.sendRedirect("Cliente.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "El cliente no se actualizo");
				response.sendRedirect("Cliente.jsp");
			}
				
			
		}
		if (request.getParameter("btneliminar")!=null) {
			//accion para eliminar
			int y;
			d=Integer.parseInt(request.getParameter("documento"));
			usdto=new Cliente_DTO(d);
			usdao=new Cliente_DAO();
			y= usdao.eliminar(usdto);
			if(y>0){
				JOptionPane.showMessageDialog(null, "El cliente fue eliminado");
				response.sendRedirect("Cliente.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "El cliente no fue eliminado");
				//response =redirigir
				response.sendRedirect("Cliente.jsp");
			}
		}	
	}
	
		
	}


