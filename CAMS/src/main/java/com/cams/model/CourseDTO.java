package com.cams.model;

import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cams.entity.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDTO 
{
	private int id;
	
	@NotNull(message="Student name cannot be null")
	@NotBlank(message="Student Name is required")
	@Size(max=20,message="Maximum 20 characters allowed")
	@Size(min=2,message="Minimum 2 values values required")
	private String name;
	
	@NotNull(message="Duration cannot be null")
	@NotBlank(message="Duration is required")
	private String duration;
	
	@NotNull(message="Fees cannot be null")
	@NotBlank(message="Fees is required")
	private double fees;
	
	@OneToMany//one course belongs to one student
	private List<Student> student;
}
