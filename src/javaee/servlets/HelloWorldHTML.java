package javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldHTML extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		pw.println("<head> <title> Hello world </title> </head>");
		pw.println("<body> <h1>Hello World </h1> </body>");
	}
}
