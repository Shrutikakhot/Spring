package com.cams.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course
{
	@Id
    private int courseId;

    @Column(length=20,nullable=false)
    private String courseName;
   
    @Column(nullable=false)
    private String duration;
    
    @Column(nullable=false)
    private double fees;
    
    @OneToMany//one course belongs to one student
    private List<Student> student;	
}
