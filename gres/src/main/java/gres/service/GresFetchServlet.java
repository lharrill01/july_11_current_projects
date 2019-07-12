package gres.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GresFetchServlet
 */
public class GresFetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GresFetchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//    	Employee employee = (Employee) req.getSession().getAttribute("employee");
//    	
//    	ObjectMapper om = new ObjectMapper();
//    	
//    	String jsonRepEmployee = employee == null ? "null" : om.writeValueAsString(employee);
//    	
//    	log.trace("JSON representation: " + jsonRepEmployee);
//    	
//    	res.setContentType("application/json");
//    	res.getWriter().write(jsonRepEmployee);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id_1 = 0;
		long id = Math.incrementExact(id_1);
		String email = request.getParameter("email");
		String selection = request.getParameter("selection");
		double rAmount = Double.parseDouble(request.getParameter("rAmount"));
		
		
	}

}
