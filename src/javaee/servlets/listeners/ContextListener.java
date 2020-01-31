package javaee.servlets.listeners;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

		@Override
		public void contextDestroyed(ServletContextEvent arg0)
		{
			System.out.print("Koniec aplikacji " + new Date());
		}
		
		@Override
		public void contextInitialized(ServletContextEvent arg0)
		{
			System.out.print("Start aplikacji " + new Date());
		}
}
