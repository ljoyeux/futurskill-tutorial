package fr.futurskill.tutorial.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6914072564345303460L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
				
		PrintWriter os = resp.getWriter();
		os.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		os.println("<html>");
		os.println("<head>");
		os.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		os.println("<title>Servlet Page</title>");
		os.println("</head>");
		os.println("<body>");
		os.println("<h1>Hello World from Servlet!</h1>");
		os.println("<h2>The current date is " + new Date(System.currentTimeMillis()).toString() + "</h2>");
		os.println("</body>");
		os.println("</html>");		
	}
}


