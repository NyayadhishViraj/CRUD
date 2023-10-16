package com.spring.repo;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.binding.Course;

public interface CourseRepository extends JpaRepository<Course, Serializable>{

}
