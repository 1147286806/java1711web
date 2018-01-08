package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Student;
import service.IStudentService;
import service.StudentServiceImpl;

public class StudentController extends HttpServlet{
	private IStudentService studentService = new StudentServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> list = studentService.findAll();
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<a href='/java1711web/Earth.html'>添加</a>");
		printWriter.println("<table border='1' cellspacing='0' width='300px'>");
	    printWriter.println("<tr>            ");
	    printWriter.println("	<th>编号</th>");
	    printWriter.println("	<th>姓名</th>");
	    printWriter.println("	<th>年龄</th>");
	    printWriter.println("	<th>性别</th>");
	    printWriter.println("	<th>地址</th>");
	    printWriter.println("</tr>           ");

	    for (Student student : list) {
	    	printWriter.println("<tr>            ");
			printWriter.println("	<td>" + student.getId() + "</td>   ");
			printWriter.println("	<td>" + student.getName() + "</td>");
			printWriter.println("	<td>" + student.getAge() + "</td>  ");
			printWriter.println("	<td>" + student.getGender() + "</td>  ");
			printWriter.println("	<td>" + student.getAddress() + "</td>");
	    	printWriter.println("</tr>           ");
		}
	    printWriter.println("</table>");
	    
	    
	}
}
