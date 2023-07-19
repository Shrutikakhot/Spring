package com.cams.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cams.Util.CourseConverter;
import com.cams.entity.Course;
import com.cams.entity.Student;
import com.cams.exception.ResourceNotFoundException;
import com.cams.model.CourseDTO;
import com.cams.repository.CourseRepository;
import com.cams.repository.StudentRepository;
import com.cams.service.CourseService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CourseServiceImpl  implements CourseService
{
	//logger statically created
			private static final Logger log = LoggerFactory.getLogger(Course.class);
			
	@Autowired
	CourseRepository courseRepository;//injecting course repository
	
	@Autowired
	CourseConverter courseConverter;//injecting the converter which is used to convert entity to dto and vice versa
	
	@Autowired
	StudentRepository studRepository ;
	
	
	public CourseDTO saveCourse(Course course) 
	{
		courseRepository.save(course);
		return courseConverter.convertToCourseDTO(course);
	}
	
	//method used to fetch student details using course id
	public CourseDTO getCourseById(int courseId) throws ResourceNotFoundException
	{
		Course course=courseRepository.findById(courseId).orElseThrow(()->
		new ResourceNotFoundException("Course","Id",courseId));
		log.info("Course details with id"+courseId+"was fetched at "+new Date());
		return courseConverter.convertToCourseDTO(course);
	}
	
	//method used to get all course details
	public List <CourseDTO> getAllCourses() 
	{
		List<Course> courses=courseRepository.findAll();
		List<CourseDTO> courseDto=new ArrayList<>();
		for(Course c : courses)
		{
			courseDto.add(courseConverter.convertToCourseDTO(c));		
		}
		log.info("All course details were fetched at "+new Date());
		return courseDto;
	}

	@Override
	public List<CourseDTO> getCourseUsingName(String name) 
	{
		List<Course> courses = courseRepository.getCourseByName(name);
		List<CourseDTO> courseDto = new ArrayList<>();
		for(Course e : courses)
		{
			courseDto.add(courseConverter.convertToCourseDTO(e));		
		}
		return courseDto;
	}

	
	@Override
	public CourseDTO assignStudToCourse(int studId, int courseId)  throws ResourceNotFoundException{
		
		{	
			Student stud = studRepository.findById(studId).orElseThrow(()->
			new ResourceNotFoundException("Student", "Id", studId));
			
			Course course = courseRepository.findById(courseId).orElseThrow(()->
			new ResourceNotFoundException("Course", "Id", courseId));
			
			stud.setCourse(course);
			
			studRepository.save(stud);
			courseRepository.save(course);
			
			return courseConverter.convertToCourseDTO(course);
		}
	}

}
