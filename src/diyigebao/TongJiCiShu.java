package diyigebao;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TongJiCiShu extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		//���������ȡ��count
	    int count = (int) servletContext.getAttribute("count");
	    count++;
	    servletContext.setAttribute("count", count);
	    System.out.println("count: " + count);
	}
}
