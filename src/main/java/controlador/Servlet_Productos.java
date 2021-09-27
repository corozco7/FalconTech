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
		String nom;
		int NIT, cod;
		double prec,iva,prev;
		boolean res;
		Productos_DTO prodto;
		Productos_DAO prodao;
		Productos_DTO recdatos;
		if(request.getParameter("btninsertar")!=null) {
			cod=Integer.parseInt(request.getParameter("codigo"));
			NIT=Integer.parseInt(request.getParameter("NIT"));
			nom=request.getParameter("nombre");
			prec=Double.parseDouble(request.getParameter("preciocompra"));
			iva=Double.parseDouble(request.getParameter("iva"));
			prev=prec*(1+iva/100);
		    
						
	    prodto= new Productos_DTO(cod,NIT,nom,prec, iva, prev);
	    
		prodao= new Productos_DAO();
		res=prodao.insertarproducto(prodto);
		if (res==true) {
			JOptionPane.showMessageDialog(null, "Producto Registrado");
			response.sendRedirect("Productos.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "Producto No Registrado");
			response.sendRedirect("Productos.jsp");
		}
			
		}
		
		if (request.getParameter("btnconsultar")!=null) {
			
			
		cod=Integer.parseInt(request.getParameter("codigo"));
		prodto=new Productos_DTO(cod);
		prodao=new Productos_DAO();
		recdatos=prodao.consultarproducto(prodto);
			//se usan las mismas variables pero no hay problema por que se ejecutan en distintos if
		
		try {
			cod=recdatos.getCodigo();
			NIT=recdatos.getNIT_proveedor();
			nom=recdatos.getNombre_producto();
			prec=recdatos.getPrecio_compra();
			iva=recdatos.getIva_compra();
			//&& =concatenacion de dato viaja por la url
			response.sendRedirect("Productos.jsp?c="+cod+"&&n="+NIT+"&&no="+nom+"&&p="+prec+"&&i="+iva);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El producto no existe");
			response.sendRedirect("Productos.jsp");
		}
		
		}
		
		
		if (request.getParameter("btnactualizar")!=null) {
			//accion para actualizar
			boolean dat;
			
			cod=Integer.parseInt(request.getParameter("codigo"));
			NIT=Integer.parseInt(request.getParameter("NIT"));
			nom=request.getParameter("nombre");
			prec=Double.parseDouble(request.getParameter("preciocompra"));
			iva=Double.parseDouble(request.getParameter("iva"));
			prev=prec*(1+iva/100);
			prodto=new Productos_DTO(cod, NIT, nom, prec, iva, prev);
			prodao=new Productos_DAO();
			dat=prodao.actualizar(prodto);
			if(dat==true) {
				JOptionPane.showMessageDialog(null, "El producto se actualizo");
				response.sendRedirect("Productos.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "El producto no se actualizo");
				response.sendRedirect("Productos.jsp");
			}
				
			
		}
		if (request.getParameter("btneliminar")!=null) {
			//accion para eliminar
			int y;
			cod=Integer.parseInt(request.getParameter("codigo"));
			prodto=new Productos_DTO(cod);
			prodao=new Productos_DAO();
			y= prodao.eliminar(prodto);
			if(y>0){
				JOptionPane.showMessageDialog(null, "El producto fue eliminado");
				response.sendRedirect("Productos.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "El producto no fue eliminado");
				//response =redirigir
				response.sendRedirect("Productos.jsp");
			}
		}	
	}
	}


