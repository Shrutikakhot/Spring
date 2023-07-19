package com.cams.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Ad_details")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionForm
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private LocalDate ad_date;
	
	@OneToOne//one addmission form holds one student details
	private Student students;
		
	@OneToOne//one student enroll in one course(student and course relation)
	private Course course;
	
}
