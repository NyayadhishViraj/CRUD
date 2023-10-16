package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.binding.Course;
import com.spring.repo.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Override
	public String saveCourse(Course course) {
		
		courseRepo.save(course); //insert
		
		return "success";
	}
	
	@Override
	public String updateCourse(Course course) {
		
		courseRepo.save(course); //insert
		
		return "data updated";
	}
	@Override
	public Course getById(Integer id) {
		Optional <Course> findById = courseRepo.findById(id);
		
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		
		return courseRepo.findAll();
	}

	@Override
	public String deleteById(Integer id) {
		if(courseRepo.existsById(id)) {
			courseRepo.deleteById(id);
			return "Delete Success";
		}
		else {
		return "No Data Found";
		}
	}

}