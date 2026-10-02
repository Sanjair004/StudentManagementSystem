package com.DTO;

public class StudentDTO {
	private int 	studentId;
	private String name;
	private String email;
	private int phone;
	private int age;
	
	public StudentDTO(int studentId,String name,String email,int phone,int age)
	{
		this.studentId=studentId;
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.age=age;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "StudentDTO [studentId=" + studentId + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", age=" + age + "]";
	}
	
	
}
