package com.tms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.tms.dao.UserDao;
import com.tms.entity.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Autowired
	JavaMailSender jms;
	
	@Override
	public User addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public List<User> viewAllUser() {
		return userDao.viewAllUser();
	}

	@Override
	public User findUserByEmail(String email) {
		return userDao.finduserByEmail(email);
	}

	@Override
	public User loginUser(String userEmail, String userPw) {
		return userDao.loginUser(userEmail, userPw);
	}
	@Override
	public User findUserByName(String userName) {
		return userDao.findUserByName(userName);
	}

	@Override
	public String findRoleByUser(String userName) {
		return userDao.findRoleByUser(userName);
	}
	@Override
	public void sendEmail(String toEmail, String sub, String body) {
		SimpleMailMessage mssg=new SimpleMailMessage();
		mssg.setFrom("tmsnew2022@outlook.com");
		mssg.setTo(toEmail);
		mssg.setSubject(sub);
		mssg.setText(body);
		jms.send(mssg);
		System.out.println("mail sent");
	}

	@Override
	public List<User> searchUser(String userName) {
		return userDao.searchUser(userName);
	}

	@Override
	public User updateUserRole(String role, String userName) {
		return userDao.updateUserRole(role, userName);
	}
}
