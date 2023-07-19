package com.cams.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.OneToOne;

import com.cams.entity.Course;
import com.cams.entity.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddmissionFormDTO 
{
	private int id;
	
	private LocalDate date;
	
	@OneToOne
	private Student students;
	
	@OneToOne//one students enrolled in one course
	private Course course;
}
