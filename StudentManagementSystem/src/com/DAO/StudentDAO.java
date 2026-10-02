package com.DAO;

import java.util.List;

import com.DTO.StudentDTO;

public interface StudentDAO {
	public abstract void addStudent(StudentDTO student);
	
	public abstract List getAllStudents();
	
	public abstract StudentDTO getstudentById(int id);
	
	void updateStudent(StudentDTO student);
	
	void deleteStudent(int id);
	
	List searchByName(String name);
	
	List searchByAgeRange(int minAge,int maxAge);
	
	int countStudents();
	 
}
