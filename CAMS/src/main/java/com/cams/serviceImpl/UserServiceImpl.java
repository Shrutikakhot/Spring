package com.cams.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cams.entity.User;
import com.cams.service.UserService;
import com.cams.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User login(String userName, String password) 
	{	
			return userRepository.findByUserNameAndPassword(userName, password);
	}
}
