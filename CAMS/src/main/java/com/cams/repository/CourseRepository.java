package com.cams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cams.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Integer>
{

	//custom method to get employee details using the employee name
			@Query("from Course where courseName=:name")
			List<Course> getCourseByName(@Param("name") String name);	
}
