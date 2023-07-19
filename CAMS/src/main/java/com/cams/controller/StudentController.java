package com.cams.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cams.Util.StudentConverter;
import com.cams.entity.Student;
import com.cams.model.StudentDTO;
import com.cams.service.StudentService;


@RestController
public class StudentController 
{
	@Autowired
	StudentService studService;
	
	@Autowired
	StudentConverter converter;
	
	//build save method using Rest API
	@PostMapping("/saveStudent")
	public StudentDTO saveStudent(@Valid @RequestBody StudentDTO studDto)
	{
		final Student stud=converter.convertToStudEntity(studDto);
		return studService.saveStudent(stud);
	}
	
	//build get student details using id REST API
	@GetMapping("/getStudById/{studId}")
	public StudentDTO getStudById(@PathVariable("studId")int id)
	{
		return studService.getStudentById(id);
	}
	
	//build get all students details using REST API
	@GetMapping("/getAllStudents")
	public List<StudentDTO> getAllStudents()
	{
		return studService.getAllStudentDetails();
	}
	
	//build update all students details using id REST API
	@PutMapping("/updateStud/{studId}")
	public StudentDTO updateStud(@PathVariable("studId") int studId,
			@Valid @RequestBody StudentDTO studDto)
	{
		final Student stud=converter.convertToStudEntity(studDto);
		return studService.updateStudentById(studId, stud);
	}
	
	//build delete students details using id REST API
	@DeleteMapping("/deleteStud/{studId}")
	public ResponseEntity<String> deleteStudById(@PathVariable("studId") int studId)
	{
		studService.deleteStudentById(studId);
		return new ResponseEntity<String>("Student details with id "+studId+""
				+ "deleted successfully",HttpStatus.OK);
	}
	
	//build delete all students details using REST API
	@DeleteMapping("/deleteAllstud")
	public ResponseEntity<String> deleteAllStud()
	{
		studService.deleteAllStudents();
		return new ResponseEntity<String>("All student details deleted successfully.",
				HttpStatus.OK);
	}
	
	//build delete all students details using REST API
	@GetMapping("/getStudByName/{name}")
	public List<StudentDTO> getStudentByName(@PathVariable("name") String name)
	{
		return studService.getStudentUsingName(name);
	}
	
	//build get students details using email REST API
	@GetMapping("/getStudByEmail/{email}")
	public StudentDTO getStudentByEmail(@PathVariable("email")String email)
	{
		return studService.getStudentByEmail(email);
	}
	
	@PostMapping("/assignStud/{studId}/toCourse/{courseId}")
	public StudentDTO assignStudToStud(@PathVariable("studId") int studId,
			@PathVariable("courseId") int courseId)
	{
		return studService.assignStudToCourse(studId, courseId);
	}	
}
