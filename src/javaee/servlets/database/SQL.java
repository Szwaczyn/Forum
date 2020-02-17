package javaee.servlets.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	}
}
