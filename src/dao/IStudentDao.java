package dao;

import java.util.List;

import pojo.Student;

public interface IStudentDao {
	public int add(Student student);
	
	public int deleteById(int id);
	
	public int update(Student student);
	
	public List<Student> findAll();
	
	public List<Student> findByName(String name);
	
	public List<Student> findByGender(String gender);
	
	public List<Student> findByFuzzy(String name);
	
	public boolean checkName(String name);

	public abstract Student findById(Integer id);
}
