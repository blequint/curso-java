package es_pildorasinformaticas.servletpruebas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistroUsuarios
 */
@WebServlet("/RegistroUsuarios")
public class RegistroUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// como el formulario esta en metodo get es aqui donde se escribe codigo
	/*	PrintWriter salida=response.getWriter();
		salida.println("<html><body>");
		salida.println("Nombre introducido: "+request.getParameter("nombre"));
		salida.println("<br><br>");
		salida.println("Apellido introducido: "+request.getParameter("apellido"));
		
		salida.println("</body></html>");
		
	*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// el contenido puede venir en diferentes formatos; binario, html etc..
		doGet(request, response);
		//se especifica que el contenido viene en html
		response.setContentType("text/html");
		PrintWriter salida=response.getWriter();
		salida.println("<html><body>");
		salida.println("Nombre introducido: "+request.getParameter("nombre"));
		salida.println("<br><br>");
		salida.println("Apellido introducido: "+request.getParameter("apellido"));
		
		salida.println("</body></html>");
		
	}

}
