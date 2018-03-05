package fr.futurskill.tutorial.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/params")
public class RequestParamServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1291233719756677047L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String[]> params = req.getParameterMap();
		
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter os = resp.getWriter();
		os.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		os.println("<html>");
		os.println("<head>");
		os.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		os.println("<title>Servlet Page</title>");
		os.println("</head>");
		os.println("<body>");
		os.println("<h1>List of parameters</h1>");
		params.forEach((k, v) -> {
			os.println("<h2> " + k + " : " + Arrays.asList(v).stream().collect(Collectors.joining(", "))  + "</h2>");
		});
		
		os.println("</body>");
		os.println("</html>");				
	}
}
