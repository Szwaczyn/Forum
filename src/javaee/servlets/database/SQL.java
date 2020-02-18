package javaee.servlets.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.Response;

public class SQL extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html charset=utf-8");
		
		pw.write("test <br> <br>");
		
		try {
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
			Connection connection = driver.connect("jdbc:mysql://127.0.0.1/forum?user=root&amp;password=&characterEncoding=utf8", null);
			Statement stmt = connection.createStatement();
			if(stmt.execute("SELECT * FROM user"))
			{
				ResultSet sqlResponse = stmt.getResultSet();
				while(sqlResponse.next())
				{
					pw.println("<p> Name: " + sqlResponse.getString("Name") + " " + sqlResponse.getString("Surname") + " </p> <br>");
				}
			}
			connection.close();
			
		} catch(SQLException e) {
			pw.write(e.getMessage());
		}
		
		pw.println(getForm());

	}
	
	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html charset=utf-8");
		String name = request.getParameter("name"); // Pobieranie danych z formularza
		String surname = request.getParameter("surname");
		
		PrintWriter pw = response.getWriter();
		
		if(name != null && !"".equals(name) && surname != null && !"".equals(surname))
		{
			pw.println(name + " " + surname);
		}
		else pw.println("<h2>You have to enter name and surname!</h2>");
	}
	
	private String getForm() {
		String response = "";
		response += "<head> <title>form</title> </head> <body> ";
		
		response += "<h1> Form </h1>";
		
		response += "<form method=\"post\">";
		response += "<p> Name </p> <input name=\"name\" />";
		response += "<p> Surname </p> <input name=\"surname\" /> <input type=\"submit\" value=\"Send\" />";
		response +="</form>";
		
		response += "</body>";
		
		return response;
	}
}
