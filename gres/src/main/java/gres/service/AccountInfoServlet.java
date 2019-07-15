package gres.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class AccountInfoServlet
 */
public class AccountInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	//Setup Logger
private static Logger log = Logger.getLogger(GresLoginServlet.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("email", email);
		session.setAttribute("password", password);
		
		System.out.println("AccountInfoServlet");
		System.out.println(email);
		System.out.println(password);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int roleId = Integer.parseInt(request.getParameter("roleid"));
		System.out.println("RoleID 1 in GresLogin is: " + roleId);
		log.trace("Employee attempting to login with email: " + email + " and password: " + password);
		System.out.println(email + " " + password);

	}
}
