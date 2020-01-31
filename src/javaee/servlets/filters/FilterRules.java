package javaee.servlets.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterRules implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
			String imie = arg0.getParameter("imie");
			if(imie != null && imie.equals("user"))
			{
				arg2.doFilter(arg0, arg1);
			}
		
	}

}
