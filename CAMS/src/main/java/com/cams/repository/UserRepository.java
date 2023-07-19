package com.cams.repository;

import com.cams.entity.User;

public interface UserRepository 
{
	User findByUserNameAndPassword(String userName, String password);
}
