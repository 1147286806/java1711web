package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Student;
import service.IStudentService;
import service.StudentServiceImpl;
import util.Constant;

public class AddStudent extends HttpServlet{
	private IStudentService studentservice = new StudentServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		Student student = new Student(name, Integer.parseInt(age), gender, address, new Date(), new Date());
		int result = studentservice.add(student);
		resp.setContentType("text/html;charset=utf-8");
		/*PrintWriter printWriter = resp.getWriter();
		if (result == Constant.ADD_SUCCESS) {
			printWriter.println("添加成功");
		} else if (result == Constant.ADD_NAME_REPEAT) {
			printWriter.println("名字重复");
		} else {
			printWriter.println("添加失败");
		}
		printWriter.close();*/
		
		resp.sendRedirect("/java1711web/findStudent");
	}
}
