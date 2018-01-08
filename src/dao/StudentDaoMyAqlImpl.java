package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

import pojo.Student;
import util.JdbcUtil;

public class StudentDaoMyAqlImpl implements IStudentDao{

	@Override
	public int add(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "INSERT INTO student(NAME,age,gender,address,birthday,addTime) VALUES(?,?,?,?,?,?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.setString(4, student.getAddress());
			preparedStatement.setDate(5, new Date(student.getBirthday().getTime()));
			preparedStatement.setDate(6, new Date(student.getAddTime().getTime()));
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		return result;
	}

	@Override
	public int deleteById(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "DELETE FROM student WHERE id=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		return result;
	}

	@Override
	public int update(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "UPDATE student SET NAME=?,age=?,gender=?,address=?,birthday=?, addTime=? WHERE id=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.setString(4, student.getAddress());
			preparedStatement.setDate(5, new Date(student.getBirthday().getTime()));
			preparedStatement.setDate(6, new Date(student.getAddTime().getTime()));
			preparedStatement.setInt(7, student.getId());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		return result;
	}

	@Override
	public List<Student> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT id,NAME,age,gender,address,birthday,addTime FROM student;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Date birthday = resultSet.getDate("birthday");
				Date date = resultSet.getDate("addTime");
				Student student = new Student(id, name, age, gender, address, birthday,date);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	@Override
	public List<Student> findByName(String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT * FROM student WHERE NAME = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name1 = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Date birthday = resultSet.getDate("birthday");
				Date date = resultSet.getDate("addTime");
				Student student = new Student(id, name1, age, gender, address, birthday,date);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	@Override
	public List<Student> findByGender(String gender) {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT * FROM student WHERE gender=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, gender);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name1 = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender1 = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Date birthday = resultSet.getDate("birthday");
				Date date = resultSet.getDate("addTime");
				Student student = new Student(id, name1, age, gender1, address, birthday,date);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	@Override
	public boolean checkName(String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean isExist = false;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT id FROM student WHERE NAME=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				isExist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return isExist;
	}

	@Override
	public List<Student> findByFuzzy(String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String hl = "%";
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT * FROM student WHERE NAME LIKE %?%;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name1 = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Date birthday = resultSet.getDate("birthday");
				Date date = resultSet.getDate("addTime");
				Student student = new Student(id, name1, age, gender, address, birthday,date);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	@Override
	public Student findById(Integer searchId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT id,NAME,age,gender,address,birthday,addTime "
				+ "FROM student where id=?;";
		try {
			connection = JdbcUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, searchId);
			resultSet = preparedStatement.executeQuery();
			System.out.println(preparedStatement);
			if (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Integer age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				String gender = resultSet.getString("gender");
				Date birthday = resultSet.getDate("birthday");// java.sql.Date
				Date addTime = resultSet.getDate("addTime");// java.sql.Date
				Student student = new Student(id, name, age, gender, address, addTime, birthday);
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		
		return null;
	}
	
}
