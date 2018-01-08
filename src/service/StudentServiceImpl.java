package service;

import java.util.List;

import dao.IStudentDao;
import dao.StudentDaoMyAqlImpl;
import pojo.Student;
import util.Constant;

public class StudentServiceImpl implements IStudentService{
	private IStudentDao studentDao = new StudentDaoMyAqlImpl();

	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public int add(Student student){
		if (studentDao.checkName(student.getName())) {
			return Constant.ADD_NAME_REPEAT;
		} else {
			int result = studentDao.add(student);
			if (result > 0) {
				return Constant.ADD_SUCCESS;
			} else {
				return Constant.ADD_FAIL;
			}
		}
	}

	@Override
	public boolean deleteById(Integer id) {
		int result = studentDao.deleteById(id);
		if (result > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean update(Student student) {
		int result = studentDao.update(student);
		if (result > 0) {
			return true;
		} else{
			return false;
		}
	}
	
	
	public List<Student> findByName(String name) {
		return studentDao.findByName(name);
	}

	@Override
	public List<Student> findByGender(String gender) {
		return studentDao.findByGender(gender);
	}

	@Override
	public List<Student> findByfuzzy(String name) {
		return studentDao.findByFuzzy(name);
	}

	@Override
	public Student findById(Integer id) {
		return studentDao.findById(id);
	}
}
