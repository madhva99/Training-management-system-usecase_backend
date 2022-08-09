package com.tms.dao;

import java.util.List;

import com.tms.entity.User;

public interface UserDao {
	User addUser(User user);
	List<User> viewAllUser();
	User finduserByEmail(String email);
	User loginUser(String userEmail, String userPw);
	User findUserByName(String userName);
	String findRoleByUser(String userName);
	List<User> searchUser(String userName);
	User updateUserRole(String role, String userName);
}
