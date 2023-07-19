package com.cams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cams.entity.AdmissionForm;

public interface AddmissionFormRepository  extends JpaRepository<AdmissionForm, Integer>
{
	
	
}
