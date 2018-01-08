package controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import util.JdbcUtil;

public class DiaoYongLuJing extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("InitServlet.init()");
		ServletContext servletContext = getServletContext();
		JdbcUtil.init(servletContext);
		
		servletContext.setAttribute("count", 0);
	}
}
