package diyigebao;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String age = req.getParameter("agge");
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		System.out.println("---------------------------------");
		System.out.println("����ʽ��" + req.getMethod());
		System.out.println("����·��URI��" + req.getServletPath());
		System.out.println("http�汾��" + req.getProtocol());
		System.out.println("-------------------------------------");
		Enumeration<String> enumeration = req.getHeaderNames();
		while (enumeration.hasMoreElements()) {
			String key = (String) enumeration.nextElement();
			String value = req.getHeader(key);
			System.out.println(key + " : " + value);
		}
	}
}
