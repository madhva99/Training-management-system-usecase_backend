package com.tms.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.entity.User;
import com.tms.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) throws Exception{
		String uEmail=user.getUserEmail();
		User user1=userService.findUserByEmail(uEmail);
		if(user1!=null) {
			throw new Exception("user with "+uEmail+" already exists");
		}
		userService.sendEmail(uEmail, "Hi Trainee Welcome", "Welcome to Training Management System. Happy Learning");
		return userService.addUser(user);
	}
	@RequestMapping("/viewAllUser")
	public List<User> viewAllUser(){
		return userService.viewAllUser();
	}
	@PostMapping("/loginUser")
	public User loginUser(@RequestBody User user) throws Exception {
		String uEmail=user.getUserEmail();
		String uPw=user.getUserPw();
		User user1=userService.loginUser( uEmail, uPw);
		if(user1==null ) {
			throw new Exception("Invalid credentials");
		}
//		userService.sendEmail(uEmail, "Course Status", "Please update your status regularly");
		return user1;
	}
	@PostMapping("/findByName")
	public User findUserByName(@RequestBody User user) throws Exception {
		String uName=user.getUserName();
		User u1= userService.findUserByName(uName);
		if(u1==null) {
			throw new Exception(uName+" does not exist");
		}
		return u1;
	}
	public void emailSender(@RequestBody User user) {
		userService.sendEmail(user.getUserEmail(), "Course Status", "Please update your status regularly");
		System.out.println(user.getUserEmail());
	}
	@GetMapping("/searchUser/{userName}")
	public List<User> searchUser(@PathVariable String userName) throws Exception {
		List<User>userList=userService.searchUser(userName);
		if(userList.isEmpty()) {
			throw new Exception("Searched UserName dosen't exist");
		}
		return userList;
	}
	@PostMapping("/updateRole/{role}/{userName}")
	public User updateUser( User user,@PathVariable String role,@PathVariable String userName) throws Exception{
//		String uRole=user.getRole();
//		String uName=user.getUserName();
		User u=userService.findUserByName(userName);
		System.out.println("previously "+u.getRole());
		if(u.getRole().equals(role)) {
			
			throw new Exception("Already same role ");
		}
		User us=userService.updateUserRole(role, userName);
		System.out.println("currently "+u.getRole());
		return us;
	}
}
