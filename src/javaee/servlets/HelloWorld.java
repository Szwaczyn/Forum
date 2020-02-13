package javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;

import javaee.Users;

public class HelloWorld extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println("Hello World ! ś");
		
		Users u = new Users();
		u.setName("Jan Kowalski");
		u.setPassword("tajnehaslo");
		u.setId(10);
		request.setAttribute("user", u);
		
		Users u2 = new Users();
		u2.setId(20);
		u2.setName("Borys Miecugow");
		u2.setPassword("scisleTajneHaslo");
		
		request.setAttribute("List", Arrays.asList(u, u2));
		
		request.setAttribute("imie", "Jan Kowalski");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
}
