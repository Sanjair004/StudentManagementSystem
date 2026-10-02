package com.DAO;

import java.util.List;

import com.DTO.CourseDTO;

public interface CourseDAO
{ 
	void addCourse(CourseDTO course); 
	List getAllCourses(); 
	CourseDTO getCourseById(int id); 
	void updateCourse(CourseDTO course); 
	void deleteCourse(int id); 
	List searchByName(String name); 
	List searchByDuration(String duration); 
	List searchByFeeRange(double min, double max); 
	int countCourses(); 
}
