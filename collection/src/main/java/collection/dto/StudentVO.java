package collection.dto;

import java.sql.Date;

// Data Transfer Object(DTO) or Value Object(VO)
// Table Column 1:1

public class StudentVO {
	
	private String studentId;
	private String name;
	private int age;
	private String gender;
	private Date birthday;
	
	public StudentVO() {
		
	}
	
	// Getters and Setters
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		System.out.println("** 학생 정보 **");
		return "학번: " + studentId + "\n이름: " + name + "\n나이: " + age + "\n성별: " + gender + "\n생년월일: " + birthday;
	}
	
	
}
