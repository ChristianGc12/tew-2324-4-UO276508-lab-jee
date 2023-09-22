

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Carrito
 */
@WebServlet("/Carrito")
public class Carrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Carrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		

		out.println("<HTML>");
		out.println("<HEAD><TITLE>Carrito</TITLE></HEAD>");
		out.println("<BODY>");

		out.println("<form action='tienda.jsp' method='post'>");
		out.println("<br>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>escoja el artículo que desea:</td>");
		out.println("</tr>");
		out.println("<tr>");

		out.println("<td>");
		out.println("<select name='producto' size='1'>");
		out.println("<option value='01'>la trampa</option>");
		out.println("<option value='02'>p2</option>");
		out.println("<option value='03'>p3</option>");
		out.println("<option value='04'>p3</option>");
		out.println("<option value='05'>p4</option>");
		out.println("<option value='06'>p5</option>");
		out.println("<option value='07'>p6</option>");
		out.println("<option value='08'>p7</option>");
		out.println("<option value='09'>p8</option>");
		out.println("<option value='10'>p9</option>");
		out.println("</select>");
		out.println("</td>");

		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><input type='submit' value='añadir al carrito...'>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		
		out.println("<br>");
		out.println("<br>");
		
		
		//------------------------------------------------------------------------------------------------------------------------
		//Comprobamos si existe el objeto "carrito" en sesión.
		//Si no existe, lo creamos vacío. Será de tipo HashMap
		@SuppressWarnings("unchecked");
		HashMap<String, Integer> carrito = (HashMap<String, Integer>) request.getSession().getAttribute("carrito");
		if (carrito == null) { 
			carrito = new HashMap<String, Integer>();
		}

		//Añadimos el producto recibido al carrito de la compra (en caso de que no sea nulo!)
		String producto = request.getParameter("producto");
		if (producto != null) {
			Integer cantidad = (Integer) carrito.get(producto);
			if (cantidad == null)
				cantidad = new Integer(1);
			else
				cantidad = new Integer(cantidad.intValue() + 1);
			//Y añadimos el producto al carrito
			carrito.put(producto, cantidad);
		}
		//Añadimos el carrito a la sesión
		request.getSession().setAttribute("carrito", carrito);
	
		
	//-----------------------------------------------------------------------------------------------------------------------		
		
		out.println("<ul>");
		out.println("<c:forEach var='entry' items='${carrito}'>");
		out.println("<li><c:out");
		out.println("value='Del producto ${entry.key}, ${entry.value} unidades' /></li>");
		out.println("</c:forEach>");
		out.println("</ul>");

		
		out.println("</body>");
		out.println("</html>");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
