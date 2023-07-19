package com.cams.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cams.Util.CourseConverter;
import com.cams.entity.Course;
import com.cams.entity.Student;
import com.cams.model.CourseDTO;
import com.cams.model.StudentDTO;
import com.cams.service.CourseService;

@RestController
@Validated
public class CourseController 
{
	@Autowired
	CourseService courseService;
	
	@Autowired
	CourseConverter courseConverter;

	//build save method using Rest API
	@PostMapping("/saveCourse")
	public CourseDTO saveCourse(@RequestBody @Valid  CourseDTO courseDTO)
	{
		Course course = courseConverter.convertToCourseEntity(courseDTO);
		return courseService.saveCourse(course);
	}
	
	//build get all course details using REST API
	@GetMapping("/getAllCourses")
	public List<CourseDTO> getAllCourses()
	{
		return courseService.getAllCourses();
	}
		
	//build get all course details using name REST API
		@GetMapping("/getCourseByName/{name}")
		public List<CourseDTO> getCourseByName(@PathVariable("name") String name)
		{
			return courseService.getCourseUsingName(name);
		}
		
		@PostMapping("/assignStud/{studId}/toCourse/{courseId}")
		public CourseDTO assignCourseToStud(@PathVariable("studId") int studId,
				@PathVariable("courseId") int courseId)
		{
			return courseService.assignStudToCourse(studId, courseId);
		}	
}
