package gres.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import gres.data.EmployeeDAOImplOJDBC;
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

    	Reimbursement reimbursement = (Reimbursement) req.getSession().getAttribute("reimbursement");
    	
    	ObjectMapper om = new ObjectMapper();
    	
    	String jsonRepReimbursement = reimbursement == null ? "null" : om.writeValueAsString(reimbursement);
    	
    	log.trace("JSON representation: " + jsonRepReimbursement);
    	
    	res.setContentType("application/json");
    	res.getWriter().write(jsonRepReimbursement);	
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

			
			req.getRequestDispatcher("webapp/errfwelcome.html").forward(req, res);
			
//			if(roleId == 1) {
//			req.getRequestDispatcher("/pages/errfwelcome.html").forward(req, res);
//			}
//			else {
//				req.getRequestDispatcher("/pages/madwelcome.html").forward(req, res);
//			}
		}
		
		//res.getWriter().write("Hi");


	}

}
