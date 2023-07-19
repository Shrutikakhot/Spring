package com.cams.service;

import com.cams.entity.AdmissionForm;
import com.cams.model.AddmissionFormDTO;


public interface AddmissionFormService 
{
	AddmissionFormDTO saveAddmissionForm(AdmissionForm addmission);
}
