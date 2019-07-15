package gres.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import gres.data.ReimbursementDAOImplOJDBC;
import gres.model.Reimbursement;
import gres.model.ReimbursementNoId;
import gres.utility.ConnectionUtility;

/**
 * Servlet implementation class GresFetchServlet
 */
public class GresFetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static int getcounter = 1;
       
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
		
//		HttpSession session = request.getSession();
//		String email = session.getAttribute("email").toString();
//		System.out.println(email);
//		PrintWriter out = response.getWriter();
//		out.print(email);
		
//    	Reimbursement reimbursement = (Reimbursement) request.getSession().getAttribute("reimbursement");
//    	
//    	int id = 0;
//    	String email = null;
//    	String rStuff = null;
//    	double rAmount = 0;
//    	String adchoice = null;
//    	
//    	ReimbursementDAOImplOJDBC reimbursementDAO = new ReimbursementDAOImplOJDBC();
//    	reimbursementDAO.getReimbursement(id, email, rStuff, rAmount, adchoice);
//    	
//    	
//    	
//    	ObjectMapper om = new ObjectMapper();
//    	
//    	
//    	
//    	String jsonRepReimbursement = reimbursement == null ? "null" : om.writeValueAsString(reimbursement);
//    	
//    	log.trace("JSON representation: " + jsonRepReimbursement);
//    	
//    	response.setContentType("application/json");
//    	response.getWriter().write(jsonRepReimbursement);
//		
//		PrintWriter writeToPage = response.getWriter();
//		int id = Integer.parseInt(request.getParameter("id"));
//		writeToPage.print("<table border='1'><tr><th>id</th><th>email</th><th>rstuff</th><th>rAmount</th></tr>");
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		String sql = "Select * From Reimbursement_Pool";
//		try {
//			conn = ConnectionUtility.getConnection();
//			stmt = conn.prepareStatement(sql);
//			rs = stmt.executeQuery();
//			
//			while(rs.next()) {
//				writeToPage.print("<tr><td>");
//				writeToPage.print(rs.getInt(1));
//				writeToPage.print("</td>");
//				writeToPage.print("<td>");
//				writeToPage.print(rs.getString(2));
//				writeToPage.print("</td>");
//				writeToPage.print("<td>");
//				writeToPage.print(rs.getString(3));
//				writeToPage.print("</td>");
//				writeToPage.print("<td>");
//				writeToPage.print(rs.getDouble(4));
//				writeToPage.print("</td>");
//				writeToPage.print("</tr>");
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();				
//			}
//				writeToPage.print("</table>");
//				
//				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ReimbursementDAOImplOJDBC reimbursement = new ReimbursementDAOImplOJDBC();
//		int id = Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");
		String rStuff = request.getParameter("rStuff");
		double rAmount = Double.parseDouble(request.getParameter("rAmount"));
		String adchoice = request.getParameter("adchoice");

		HttpSession session = request.getSession();
		session.getAttribute("email");

		reimbursement.createReimbursementNoId(email, rStuff, rAmount, adchoice);
		reimbursement.getReimbursementNoId(email, rStuff, rAmount, adchoice);
		
		

		//request.getRequestDispatcher("/PendingRequests.html").forward(request, response);
		//doGet(request, response);
	}

}
