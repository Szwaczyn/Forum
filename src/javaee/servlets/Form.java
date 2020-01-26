package javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Form extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse Response) throws IOException
	{
		PrintWriter pw = Response.getWriter();
		
		if(request.getCookies() != null)
		{
			for(int i = 0; i <= request.getCookies().length -1; i ++)
			{
				
				if(request.getCookies()[i].getName().equals("name"))
				{
					pw.println("Witaj " + request.getCookies()[i].getValue());
					return;
				}
			}
		}
		
		pw.println("<head> <title>form</title> </head> <body> ");
		
		pw.println("<h1> Form </h1>");
		
		pw.println("<form method=\"post\">");
		pw.println("<p> Get your name </p> <input name=\"name\" /> <input type=\"submit\" value=\"Send\" />");
		pw.println("</form>");
		
		pw.println("</body>");
	}
	
	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html charset=utf-8");
		String name = request.getParameter("name"); // Pobieranie danych z formularza
		PrintWriter pw = response.getWriter();
		
		if(name != null && !"".equals(name))
		{
			Cookie cookie = new Cookie("name", name);
			cookie.setMaxAge(3600); // Ustawienie długości życia ciasteczka w sekundach. 
			response.addCookie(cookie);
			
			pw.println("<h2>Hello " + name + "</h2>");
		}
		else pw.println("<h2>You have to enter your name!</h2>");
	}
	
}
