package com.cams.Util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.cams.entity.Student;
import com.cams.model.StudentDTO;

@Component
public class StudentConverter 
{
	//convert student entity into StudentDTO
		public StudentDTO convertToStudDTO(Student stud)
		{
			StudentDTO sDto=new StudentDTO();
			if(stud!=null)
			{
				BeanUtils.copyProperties(stud, sDto);
			}
			return sDto;
		}
		
		//convert StudentDTO to Student entity
		public Student convertToStudEntity(StudentDTO sDto)
		{
			Student stud=new Student();
			if(sDto!=null)
			{
				BeanUtils.copyProperties(sDto, stud);
			}
			return stud;
		}
}
