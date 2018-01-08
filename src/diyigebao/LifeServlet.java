package diyigebao;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.pool.impl.GenericKeyedObjectPool.Config;

public class LifeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public LifeServlet() {
		super();
		System.out.println("LifeServlet.LifeServlet()");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("LifeServlet.init()");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeServlet.service()");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("LifeServlet.destroy()");
	}
}
