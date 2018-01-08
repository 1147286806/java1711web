package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import dao.IStudentDao;
import dao.StudentDaoMyAqlImpl;
import pojo.Student;

public class StudentDaoMyAqlImplTest {

	@Test
	public void testAdd() {
		Student student = new Student("zhangl", 16, "n", "yitali",null,null);
		IStudentDao studentDao = new StudentDaoMyAqlImpl();
		int result = studentDao.add(student);
		if (result > 0) {
			System.out.println("成功");
		} else {
			System.out.println("失败");
		}
	}

	@Test
	public void testDelet() {
		int id = 4;
		IStudentDao studentDao = new StudentDaoMyAqlImpl();
		int result = studentDao.deleteById(id);
		if (result > 0) {
			System.out.println("成功");
		} else {
			System.out.println("失败");
		}
	}
	
	@Test
	public void testUpdate() {
		int a = 3;
		Student student = new Student(a, "xxx", 15, "v", "wda",null,null);
		IStudentDao studentDao = new StudentDaoMyAqlImpl();
		int result = studentDao.update(student);
		if (result > 0) {
			System.out.println("成功");
		}else {
			System.out.println("失败");
		}
	}
	
	@Test
	public void testCheckeName() {
		String name = "xxx";
		IStudentDao studentDao = new StudentDaoMyAqlImpl();
		boolean result = studentDao.checkName(name);
		if ( result == true) {
			System.out.println("成功");
		}else {
			System.out.println("失败");
		}
	}
}
