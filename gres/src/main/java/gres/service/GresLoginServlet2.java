package gres.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import gres.data.EmployeeDAOImplOJDBC;
import gres.model.Employee;
import gres.model.Reimbursement;

/**
 * Servlet implementation class GresLoginServlet2
 */
public class GresLoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Setup Logger
private static Logger log = Logger.getLogger(GresLoginServlet.class);
	
	//get login service
	
private static EmployeeLoginService employeeLoginService = EmployeeLoginService.getInstance(new EmployeeDAOImplOJDBC());


    /**
     * @see HttpServlet#HttpServlet()
     */
    public GresLoginServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// Gets attribute from session 
		Employee employee = (Employee) req.getSession().getAttribute("employee");

		// Using Object Mapper to turn Java Objects into JSON
		ObjectMapper om = new ObjectMapper();
				
		// Proactively checks to see if Employee is null
		// If not stringfy the object Employee as a String jsonRepEmployee
		String jsonRepEmployee = employee == null ? "" : om.writeValueAsString(employee);
		
		log.trace("JSON " + jsonRepEmployee);
//		System.out.println("JSON " + jsonRepEmployee);
		
		// setting content type tells browser what to expect in body of response
		res.setContentType("application/json");
		res.getWriter().write(jsonRepEmployee);
		
		// Commits response
		res.flushBuffer();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		int roleId = Integer.parseInt(req.getParameter("roleid"));
		System.out.println("RoleID 1 in GresLogin is: " + roleId);
		log.trace("Employee attempting to login with email: " + email + " and password: " + password);
		System.out.println(email + " " + password);
		if(employeeLoginService.validate(email, password, roleId)) {
			System.out.println("RoleID 2 in EmployeeDAOJDBC is: " + roleId);

			log.trace("Employee Login Success");
			
			HttpSession session = req.getSession();
			
			
			session.setAttribute("email", employeeLoginService.getEmployee(email, password, roleId));

			
			//req.getRequestDispatcher("errfwelcome.html").forward(req, res);
			
			switch(roleId) {
			case 1:
				System.out.println("Here");
				req.getRequestDispatcher("errfwelcome.html").forward(req, res);
				System.out.println(roleId);
				System.out.println("Case 1");
				break;
				
			case 2:
				req.getRequestDispatcher("AllPendingRequests.html").forward(req, res);
				System.out.println("Case 2");
				break;
			default:
				res.sendRedirect("index.html");
			}

			
		}
		
		//res.getWriter().write("Hi");


	}

}
