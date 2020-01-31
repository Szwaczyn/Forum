package javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Attribute extends HttpServlet {
	
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html; charset=utf8");
		PrintWriter pw = response.getWriter();
		
		ServletContext context = this.getServletContext();
		String imie = request.getParameter("imie");
		
		synchronized (context) {
			context.setAttribute("imie", imie);
		}
	}
}
