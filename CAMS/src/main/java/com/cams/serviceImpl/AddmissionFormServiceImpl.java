package com.cams.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cams.Util.AddmissionFormConverter;
import com.cams.entity.AdmissionForm;
import com.cams.model.AddmissionFormDTO;
import com.cams.repository.AddmissionFormRepository;
import com.cams.service.AddmissionFormService;

@Service
public class AddmissionFormServiceImpl implements AddmissionFormService
{
	@Autowired
	AddmissionFormRepository adRepository;
	
	@Autowired
	AddmissionFormConverter adConverter;
	
	@Override
	public AddmissionFormDTO saveAddmissionForm(AdmissionForm addmission) {
	
		adRepository.save(addmission);
		return adConverter.convertToAddmissionFormDTO(addmission);
	}
}
