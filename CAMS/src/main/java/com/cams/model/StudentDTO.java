package com.cams.model;


import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cams.entity.Course;
import com.cams.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO extends User 
{
	@NotNull(message="Student name cannot be null")
	@NotBlank(message="Student Name is required")
	@Size(max=20,message="Maximum 20 characters allowed")
	@Size(min=2,message="Minimum 2 values values required")
	private String studName;
	
	@NotNull(message="Email cannot be null")
	@NotBlank(message="Email is required")
	@Email(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
	flags = Pattern.Flag.CASE_INSENSITIVE, 
	message = "Email Id must be a well-formed!")
	private String email;
	
	@NotNull(message="Phone number cannot be null")
	@NotBlank(message="Phone number is required")
	@Pattern(regexp="[6789]{1}[0-9]{9}$",message="phone number should consist of 10 digits")
	private String contact;
	
	@NotNull(message="Address cannot be null")
	@NotBlank(message="Address is required")
	private String address;
	
	@ManyToOne//many students get enrolled in one course
	private Course course;
}
