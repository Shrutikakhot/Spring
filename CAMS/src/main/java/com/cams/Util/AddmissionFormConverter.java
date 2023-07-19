package com.cams.Util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.cams.entity.AdmissionForm;
import com.cams.model.AddmissionFormDTO;

@Component
public class AddmissionFormConverter 
{
	//convert addmissionForm entity into addmissionFormDTO
	public AddmissionFormDTO convertToAddmissionFormDTO(AdmissionForm admission_form)
	{
		AddmissionFormDTO admission_formDto = new AddmissionFormDTO();
		if(admission_form!=null)
		{
			BeanUtils.copyProperties(admission_form, admission_formDto);
		}
		return admission_formDto;
	}
	
	//convert addmissionFormDTO to AddmissionForm entity
	public AdmissionForm convertToAdmissionFormEntity(AddmissionFormDTO addmission_formDto)
	{
		AdmissionForm addmission_form = new AdmissionForm();
		if(addmission_formDto!=null)
		{
			BeanUtils.copyProperties(addmission_formDto, addmission_form);
		}
		return addmission_form;
	}
}
