package com.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.binding.Course;
import com.spring.service.CourseService;

@RestController
public class CourseRestController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody Course course){
		String status = courseService.saveCourse(course);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}
	
	@GetMapping("/course/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable int id){
		Course course = courseService.getById(id);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourse(){
		List<Course> course = courseService.getAllCourses();
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	@PutMapping("/course")
	public ResponseEntity<String> updateCourse(@RequestBody Course course){
		courseService.getById(course.getId());
		String status = courseService.updateCourse(course);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
	@DeleteMapping("/course/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable int id){
		String status = courseService.deleteById(id);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
}
