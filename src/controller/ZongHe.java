package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Student;
import service.IStudentService;
import service.StudentServiceImpl;

public class ZongHe extends HttpServlet{
	private IStudentService studentservice = new StudentServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		//得到Session里面数据
		String userName = (String) session.getAttribute("userName");
		if (userName == null) {
			//2.重定向到登录界面
			resp.sendRedirect(req.getContextPath() + "/jsp/loggin.jsp");
			return;
		}
		
		
		
		String servletPath = req.getServletPath();
		System.out.println(servletPath);
		req.setCharacterEncoding("UTF-8");
		if ("/addstudent.do".equals(servletPath)) {
			addstudent(req,resp);
		} else if("/findStudent.do".equals(servletPath)){
			findStudent(req,resp);
		} else if("/findByName.do".equals(servletPath)){
			findByName(req,resp);
		} else if("/showInfo.do".equals(servletPath)){
			showInfo(req,resp);
		} else if ("/delete.do".equals(servletPath)) {
			deleteStudent(req,resp);
		} else if ("/update.do".equals(servletPath)) {
			updateStudent(req,resp);
		} else if ("/findupdate.do".equals(servletPath)) {
			findaupdate(req,resp);
		}
	}

	

	private void findaupdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		Student student = studentservice.findById(id);
		req.setAttribute("student", student);
		req.getRequestDispatcher("/update.jsp").forward(req, resp);
	}
	 
	private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		Student student = new Student(Integer.parseInt(id),name, Integer.parseInt(age), gender, address, new Date(), new Date());
		if (studentservice.update(student)) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}
		resp.sendRedirect("/java1711web/findStudent.do");
	}
	
	private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		boolean student = studentservice.deleteById(id);
		resp.sendRedirect("/java1711web/findStudent.do");
	}

	private void findByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		List<Student> list = studentservice.findByName(name);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/showInfo.do").forward(req, resp);
	}

	private void addstudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
		
		resp.sendRedirect("/java1711web/findStudent.do");
	}
	
	private void findStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<Student> list = studentservice.findAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/Diyige.jsp").forward(req, resp);
	}
	
	private void showInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Student> list = (List<Student>) req.getAttribute("list");
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
