/*
 https://www.youtube.com/watch?v=H5A5eXbyPxM&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=248
 video 248 uso del modelo MVC haciendo conexion de un servlet con un jsp
 * */

package es_pildorasinformaticas.servletpruebas;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControladorServlet
 */
@WebServlet("/ControladorServlet")
public class ControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String [] productos= {"Destornillador", "Serrucho", "Tornillo", "Taladro"};
		
		//insta insertando la lista en una variable de tipo request para que pueda ser transmitida 
		request.setAttribute("lista_productos", productos);
		//request que sera enviado a un jsp
		RequestDispatcher miDispatcher=request.getRequestDispatcher("/VistaJSP.jsp");
		miDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
