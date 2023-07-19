package com.cams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.cams.entity.Student;


@EnableJpaRepositories
public interface StudentRepository extends JpaRepository<Student,Integer>
{
	//custom method to get employee details using the employee name
		@Query("from Student where studName=:name")
		List<Student> getStudentByName(@Param("name") String name);
		
		//custom method to get employee details using the employee email with finder method
		Student findByEmail(String email);
}
