package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		// Set MIME type of response, "text/html"
		resp.setContentType("text/html");
		
		//user PrintWriter to send text data to the client who has requested the servlet
		java.io.PrintWriter out = resp.getWriter();
		
		//construct the html content

		
		//make sure method="post" so that the servlet service method calls doPost in the response
		// to the form submit
		out.println("<form method=\"post\" action=\"" + req.getContextPath() + "/firstservlet\" >");
		
		
		
		
		
		
		
		
		out.println("</body></html>");
		
	}

}
