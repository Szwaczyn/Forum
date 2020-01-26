package javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionTest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		HttpSession session = request.getSession();
		Integer counter = (Integer)session.getAttribute("counter");
		if(counter == null)
		{
			counter = 1;
		} else counter ++;
		
		session.setAttribute("counter", counter);
		
		pw.println("Counter: " + counter);
	}
}
