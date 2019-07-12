package gres.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import gres.data.ReimbursementDAOImplOJDBC;
import gres.model.Reimbursement;

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

    private static Logger log = Logger.getLogger(GresFetchServlet.class);

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	Reimbursement reimbursement = (Reimbursement) request.getSession().getAttribute("reimbursement");
    	
    	ObjectMapper om = new ObjectMapper();
    	
    	String jsonRepReimbursement = reimbursement == null ? "null" : om.writeValueAsString(reimbursement);
    	
    	log.trace("JSON representation: " + jsonRepReimbursement);
    	
    	response.setContentType("application/json");
    	response.getWriter().write(jsonRepReimbursement);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_1 = 0;
		int id = Math.incrementExact(id_1);
		String email = request.getParameter("email");
		String rStuff = request.getParameter("rStuff");
		double rAmount = Double.parseDouble(request.getParameter("rAmount"));
		String adchoice = request.getParameter("adchoice");

		HttpSession session = request.getSession();
		session.getAttribute("email");

		ReimbursementDAOImplOJDBC reimbursement = new ReimbursementDAOImplOJDBC();
		reimbursement.createReimbursement(id, email, rStuff, rAmount, adchoice);
		
		request.getRequestDispatcher("/PendingRequests.html").forward(request, response);
		
		doGet(request, response);
	}

}
