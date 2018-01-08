package diyigebao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Student;
import service.IStudentService;
import service.StudentServiceImpl;

public class ContextServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		servletContext.setAttribute("name", "zhangsan");
		IStudentService service = new StudentServiceImpl();
		List<Student> list = service.findAll();
		servletContext.setAttribute("list", list);

	}

}
