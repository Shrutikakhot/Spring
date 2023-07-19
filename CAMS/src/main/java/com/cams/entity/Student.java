package com.cams.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User
{
    @Column(length=20,nullable=false)
    private String studName;
    
    @Column(length=20,nullable=false,unique=true)
    private String email;
    
    @Column(length=10,nullable=false,unique=true)
	private String contact;
    
    @Column(length=20,nullable=false,unique=true)
    private String address;
    
    @ManyToOne//many students take one same course
    private Course course;
}
