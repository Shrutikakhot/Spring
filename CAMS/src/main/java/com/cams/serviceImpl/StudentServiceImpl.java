package com.cams.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cams.Util.StudentConverter;
import com.cams.entity.Course;
import com.cams.entity.Student;
import com.cams.exception.PropertyAlreadyExistException;
import com.cams.exception.ResourceNotFoundException;
import com.cams.model.StudentDTO;
import com.cams.repository.CourseRepository;
import com.cams.repository.StudentRepository;
import com.cams.service.StudentService;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService
{
	//logger statically created
		private static final Logger log = LoggerFactory.getLogger(Student.class);
		
	@Autowired
	StudentRepository studRepository ;
	
	@Autowired
	StudentConverter converter;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public StudentDTO saveStudent(Student student) throws PropertyAlreadyExistException
	{
		List<Student> students = studRepository.findAll();
		for(Student s: students)
		{
			if(s.getStudName().equals(student.getStudName()))
			{
				throw new PropertyAlreadyExistException("Student name already exists.");
			}
			if(s.getContact().equals(student.getContact()))
			{
				throw new PropertyAlreadyExistException("Phone number already exists.");
			}
		}
		
		studRepository.save(student); //save the Student details
		return converter.convertToStudDTO(student);//return Student details
	}

	//method used to fetch student details using student id
	@Override
	public StudentDTO getStudentById(int studId) throws ResourceNotFoundException
	{
		Student stud=studRepository.findById(studId).orElseThrow(()->
		new ResourceNotFoundException("Student","Id",studId));
		log.info("Student details with id"+studId+"was fetched at "+new Date());
		return converter.convertToStudDTO(stud);
	}
	
	//method used to get all student details
	@Override
	public List <StudentDTO> getAllStudentDetails() 
	{
		List<Student> students=studRepository.findAll();
		List<StudentDTO> studDto=new ArrayList<>();
		for(Student s : students)
		{
			studDto.add(converter.convertToStudDTO(s));		
		}
		log.info("All student details were fetched at "+new Date());
		return studDto;
	}
		
	@Override
	public StudentDTO updateStudentById(int studId, Student stud) throws ResourceNotFoundException{
		Student existStud = studRepository.findById(studId).orElseThrow(()->
		new ResourceNotFoundException("Student", "Id", studId));
		
		//updating the existing employee details with new details
		existStud.setStudName(stud.getStudName());
		existStud.setContact(stud.getContact());
		existStud.setEmail(stud.getEmail());
		existStud.setAddress(stud.getAddress());
		existStud.setUserName(stud.getUserName());
		existStud.setPassword(stud.getPassword());
		
		//saving the updated details
		studRepository.save(existStud);
		
		log.info("Student with id "+studId+" has been updated to "+existStud.toString());
		return converter.convertToStudDTO(existStud);
	}
	@Override
	
	public void deleteStudentById(int studId) throws ResourceNotFoundException{
		Optional<Student> opStud = studRepository.findById(studId);
		Course course = opStud.get().getCourse();
		if(course!=null)
		{
			//course.setTotalStud(course.getTotalStud()-1);
			courseRepository.save(course);
		}
		if(opStud.isPresent())
		{
			studRepository.deleteById(studId);
		}
		else
		{
			throw new ResourceNotFoundException("Student", "Id", studId);
		}
	}
	
	@Override
	public void deleteAllStudents() 
	{
		studRepository.deleteAll();
	}

	@Override
	public List<StudentDTO> getStudentUsingName(String name) {
		List<Student> students = studRepository.getStudentByName(name);
		List<StudentDTO> studDto = new ArrayList<>();
		for(Student e : students)
		{
			studDto.add(converter.convertToStudDTO(e));		
		}
		return studDto;
	}
	
	public StudentDTO getStudentByEmail(String email) throws ResourceNotFoundException
	{
		Student stud = studRepository.findByEmail(email);
		if(stud!=null)
		{
		return converter.convertToStudDTO(stud);
		}
		else
		{
			throw new ResourceNotFoundException("Student", "Email", email);
		}
	}
	
	@Override
	public StudentDTO assignStudToCourse(int studId, int courseId) throws ResourceNotFoundException
	{	
		Student stud = studRepository.findById(studId).orElseThrow(()->
		new ResourceNotFoundException("Student", "Id", studId));
		
		Course course = courseRepository.findById(courseId).orElseThrow(()->
		new ResourceNotFoundException("Course", "Id", courseId));
		
		stud.setCourse(course);
		
		//course.setTotalEmp(course.getTotalStud()+1);
		
		studRepository.save(stud);
		courseRepository.save(course);
		
		return converter.convertToStudDTO(stud);
	}
	
}
