package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import modelo.Cliente_DAO;
import modelo.Cliente_DTO;
import modelo.DetalleVentas_DAO;
import modelo.DetalleVentas_DTO;
import modelo.Productos_DAO;
import modelo.Productos_DTO;
import modelo.Ventas_DAO;
import modelo.Ventas_DTO;

/**
 * Servlet implementation class Servlet_Ventas
 */
@WebServlet("/Servlet_Ventas")
public class Servlet_Ventas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	double iva1, iva2, iva3;
	int codigo1, codigo2, codigo3;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Ventas() {
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
		HttpSession sesion = request.getSession();

		if (request.getParameter("confirmar") != null) {

			int cedula;
			Cliente_DTO listado;
			Cliente_DAO clidao = new Cliente_DAO();

			cedula = Integer.parseInt(request.getParameter("cedula"));
			Cliente_DTO clientedto = new Cliente_DTO(cedula);
			listado = clidao.consultarusuario(clientedto);
			sesion.setAttribute("cliente", listado);
			request.getRequestDispatcher("Ventas.jsp").forward(request, response);
		}
		if (request.getParameter("verificarproducto1") != null) {

			Productos_DTO listaproducto1;
			Productos_DAO prodao = new Productos_DAO();

			codigo1 = Integer.parseInt(request.getParameter("codigo1"));
			Productos_DTO proddto = new Productos_DTO(codigo1);
			listaproducto1 = prodao.consultarproducto(proddto);
			if (listaproducto1 == null) {
				JOptionPane.showMessageDialog(null, "Producto no encontrado");
				response.sendRedirect("Ventas.jsp");
			} else {
				iva1 = listaproducto1.getIva_compra();
				sesion.setAttribute("producto1", listaproducto1);
				request.getRequestDispatcher("Ventas.jsp").forward(request, response);
			}

		}
		if (request.getParameter("verificarproducto2") != null) {

			Productos_DTO listaproducto2;
			Productos_DAO prodao = new Productos_DAO();

			codigo2 = Integer.parseInt(request.getParameter("codigo2"));
			Productos_DTO proddto = new Productos_DTO(codigo2);
			listaproducto2 = prodao.consultarproducto(proddto);
			if (listaproducto2 == null) {
				JOptionPane.showMessageDialog(null, "Producto no encontrado");
				response.sendRedirect("Ventas.jsp");
			} else {
				iva2 = listaproducto2.getIva_compra();
				sesion.setAttribute("producto2", listaproducto2);
				request.getRequestDispatcher("Ventas.jsp").forward(request, response);
			}

		}
		if (request.getParameter("verificarproducto3") != null) {

			Productos_DTO listaproducto3;
			Productos_DAO prodao = new Productos_DAO();

			codigo3 = Integer.parseInt(request.getParameter("codigo3"));
			Productos_DTO proddto = new Productos_DTO(codigo3);
			listaproducto3 = prodao.consultarproducto(proddto);
			if (listaproducto3 == null) {
				JOptionPane.showMessageDialog(null, "Producto no encontrado");
				response.sendRedirect("Ventas.jsp");
			} else {
				iva3 = listaproducto3.getIva_compra();
				sesion.setAttribute("producto3", listaproducto3);
				request.getRequestDispatcher("Ventas.jsp").forward(request, response);
			}

		}

		if (request.getParameter("total") != null) {

			double total1, total2, total3, totalsiniva, totaliva, total, precio1, precio2, precio3, res1, res2, res3;
			String x;
			int cantidad1, cantidad2, cantidad3;

			cantidad1 = Integer.parseInt(request.getParameter("cantidad1"));
			cantidad2 = Integer.parseInt(request.getParameter("cantidad2"));
			cantidad3 = Integer.parseInt(request.getParameter("cantidad3"));
			precio1 = Double.parseDouble(request.getParameter("precio1"));
			precio2 = Double.parseDouble(request.getParameter("precio2"));
			precio3 = Double.parseDouble(request.getParameter("precio3"));
			total1 = cantidad1 * precio1;
			total2 = cantidad2 * precio2;
			total3 = cantidad3 * precio3;
			res1 = total1 * iva1 / 100;
			res2 = total2 * iva2 / 100;
			res3 = total3 * iva3 / 100;
			totalsiniva = total1 + total2 + total3;
			totaliva = res1 + res2 + res3;
			total = totalsiniva + totaliva;
			int i = JOptionPane.showConfirmDialog(null,
					"Articulo 1: $" + total1 + "\n" + "Articulo 2: $" + total2 + "\n" + "Articulo 3: $" + total3 + "\n"
							+ "IVA 1: $" + res1 + "\n" + "IVA 2: $" + res2 + "\n" + "IVA 3: $" + res3 + "\n"
							+ "Total sin IVA: $" + totalsiniva + "\n" + "Total IVA: $" + totaliva + "\n"
							+ "TOTAL A PAGAR: $" + total);

			if (i == 0) {

				int cedula_usuario, cedula_cliente, ID;
				Ventas_DAO ventdao = new Ventas_DAO();

				cedula_cliente = Integer.parseInt(request.getParameter("cedula"));
				cedula_usuario = Integer.parseInt(request.getParameter("usuario"));
				Ventas_DTO ventdto = new Ventas_DTO(cedula_cliente, cedula_usuario, totaliva, totalsiniva, total);
				ID = ventdao.InsertarVenta(ventdto);

				if (ID == 0) {
					JOptionPane.showMessageDialog(null, "Venta no realizada");
					response.sendRedirect("Ventas.jsp");

				} else {
					JOptionPane.showMessageDialog(null, "Venta realizada");
					boolean exitodetalle;
					DetalleVentas_DAO detaven = new DetalleVentas_DAO();
					DetalleVentas_DTO detavendto1 = new DetalleVentas_DTO(cantidad1, codigo1, ID, total1, res1,
							total1 + res1);
					DetalleVentas_DTO detavendto2 = new DetalleVentas_DTO(cantidad2, codigo2, ID, total2, res2,
							total2 + res2);
					DetalleVentas_DTO detavendto3 = new DetalleVentas_DTO(cantidad3, codigo3, ID, total3, res3,
							total3 + res3);

					exitodetalle = detaven.insertar(detavendto1);
					if (exitodetalle) {
						JOptionPane.showMessageDialog(null, "El primer detalle de la venta fue creado");
						exitodetalle = detaven.insertar(detavendto2);
						if (exitodetalle) {
							JOptionPane.showMessageDialog(null, "El segundo detalle de la venta fue creado");
							exitodetalle = detaven.insertar(detavendto3);
							if (exitodetalle) {
								JOptionPane.showMessageDialog(null, "El tercer detalle de la venta fue creado");
								response.sendRedirect("Ventas.jsp");

							} else {
								JOptionPane.showMessageDialog(null,
										"Existe un problema al crear el tercer detalle de la venta");
								response.sendRedirect("Ventas.jsp");

							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Existe un problema al crear el segundo detalle de la venta");
							response.sendRedirect("Ventas.jsp");
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Existe un problema al crear el primer detalle de la venta");
						response.sendRedirect("Ventas.jsp");
					}

				}
			}

		}
	}

}
