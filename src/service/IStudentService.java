package service;

import java.util.List;

import pojo.Student;

public interface IStudentService {
	List<Student> findAll();
	List<Student> findByName(String name);
	List<Student> findByGender(String gender);
	List<Student> findByfuzzy(String name);
	int add(Student student);
	boolean deleteById(Integer id);
	Student findById(Integer id);
	boolean update(Student student);
}
