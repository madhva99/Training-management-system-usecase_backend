package com.tms.service;

import java.util.List;

import com.tms.entity.User;

public interface UserService {
	User addUser (User user);
	List<User> viewAllUser();
	User findUserByEmail(String email);
	User loginUser(String userEmail, String userPw);
	User findUserByName(String userName);
	String findRoleByUser(String userName);
	void sendEmail(String toEmail,String sub,String body);
	List<User> searchUser(String userName);
	User updateUserRole(String role, String userName);
}
