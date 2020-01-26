package javaee.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetFile extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest rquest, HttpServletResponse response) throws IOException
	{
		response.setContentType("image/png");
		OutputStream os = response.getOutputStream();
		response.addHeader("Content-Disposition", "attachment;fielname=image.png");
		byte[] bufor = readFile("D:\\Projekty\\Servlets\\Forum\\Resources\\obraz1.png");
		os.write(bufor);
		os.flush();
	}
	
	private byte[] readFile(String fileName) throws IOException
	{
		File f = new File(fileName);
		long sizeOfFile = f.length();
		byte[] binarFile = new byte[(int)sizeOfFile];
		
		FileInputStream fis = new FileInputStream(f);
		
		fis.read(binarFile);
		fis.close();
		
		return binarFile;
	}

}
