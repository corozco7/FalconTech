package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import modelo.CSV_DAO;




/**
 * Servlet implementation class Servlet_CSV
 */
@WebServlet("/Servlet_CSV")
@MultipartConfig
public class Servlet_CSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_CSV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Part archivo=request.getPart("archivo");
			
		   String Url="C:\\\\Users\\\\Laura\\\\eclipse-workspace\\\\FalconTech\\\\src\\\\main\\\\webapp\\\\documentos\\\\";
			
			
			
		   if(request.getParameter("cargar")!=null) {
				
				
				try {
				InputStream file= archivo.getInputStream();
				File copia= new File(Url+"productos.csv");
				FileOutputStream escribir= new FileOutputStream(copia);
				int num=file.read();
				while(num !=-1) {
					
					escribir.write(num);
					num=file.read();
				}
				
				
				file.close();
				escribir.close();
				
				boolean x;
				JOptionPane.showMessageDialog(null, "Se cargo el archivo correctamente");
				
				CSV_DAO credao=new CSV_DAO();
				
				x=credao.cargarProducto(Url+"productos.csv");
				if(x) {
					JOptionPane.showMessageDialog(null, "Datos cargados en la bd");
					response.sendRedirect("Productos.jsp");
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "No se cargaron los datos");
					response.sendRedirect("Productos.jsp");
				}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Error al cargar el archivo: "+e);
									}
					
				
			
			}
			
			
		
		
		
		
		
		
		
		
	}

}
