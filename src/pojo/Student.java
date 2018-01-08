package pojo;

import java.util.Date;

public class Student {
	private Integer id;
	private String name;
	private Integer age;
	private String gender;
	private String address;
	private Date birthday;
	private Date addTime;
	
	public Student() {
		super();
	}
	
	public Student(String name, Integer age, String gender, String address, Date birthday, Date addTime) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.addTime = addTime;
	}



	public Student(Integer id, String name, Integer age, String gender, String address, Date birthday, Date addTime) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.addTime = addTime;
	}


	
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ ", birthday=" + birthday + ", addTime=" + addTime + "]";
	}

	
	
}
