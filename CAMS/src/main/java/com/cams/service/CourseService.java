package com.cams.service;

import java.util.List;

import com.cams.entity.Course;
import com.cams.model.CourseDTO;

public interface CourseService 
{
	//this method is used to save course details
	CourseDTO saveCourse(Course course);

	//method used to fetch all course details
	List<CourseDTO> getAllCourses();

	//method used to fetch course details using course name
	List<CourseDTO> getCourseUsingName(String name);

	//method to assign an course to a student
	CourseDTO assignStudToCourse(int studId, int courseId);	
}
