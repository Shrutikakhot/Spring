package com.cams.service;

import java.util.List;

import com.cams.entity.Student;
import com.cams.model.StudentDTO;
import com.ems.exceptions.ResourceNotFoundException;


public interface StudentService 
{
	//this method is used to save student details
	StudentDTO saveStudent(Student student);
	
	//this method is used to fetch student details using student id
	StudentDTO getStudentById(int studId);
	
	//method used to fetch all student details
	List<StudentDTO> getAllStudentDetails();
	
	//method used to update employee details using employee id
	StudentDTO updateStudentById(int empId, Student emp);
			
	//method used to delete student details using id
	void deleteStudentById(int studId);
	
	//method used to delete all students
	void deleteAllStudents();

	//method used to fetch employee details using employee name
	List<StudentDTO> getStudentUsingName(String name);
	
	//method used to fetch employee detail using email
	StudentDTO getStudentByEmail(String email);
		
	//method to assign an employee to a department
	StudentDTO assignStudToCourse(int empId, int deptId);

	
}
