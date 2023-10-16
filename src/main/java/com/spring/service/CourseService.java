package com.spring.service;

import java.util.List;

import com.spring.binding.Course;

public interface CourseService {
	//The insert and save will be done by upsert method
	public String saveCourse(Course course);
	
	public String updateCourse(Course course);
	
	public Course getById(Integer id);
	
	public List<Course> getAllCourses();
	
	public String deleteById(Integer id);
	

}
