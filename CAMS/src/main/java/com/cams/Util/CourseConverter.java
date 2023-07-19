package com.cams.Util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.cams.entity.Course;
import com.cams.entity.Student;
import com.cams.model.CourseDTO;

@Component
public class CourseConverter {
	//convert course entity into courseDTO
			public CourseDTO convertToCourseDTO(Course course)
			{
				CourseDTO courseDto = new CourseDTO();
				if(course!=null)
				{
					BeanUtils.copyProperties(course, courseDto);
				}
				return courseDto;
			}
			
			//convert courseDTO to course entity
			public Course convertToCourseEntity(CourseDTO courseDto)
			{
				Course course = new Course();
				if(courseDto!=null)
				{
					BeanUtils.copyProperties(courseDto, course);
				}
				return course;
			}	
}
