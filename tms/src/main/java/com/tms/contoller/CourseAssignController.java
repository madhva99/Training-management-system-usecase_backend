package com.tms.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.entity.Course;
import com.tms.entity.CourseAssign;
import com.tms.entity.User;
import com.tms.service.CourseAssignService;
import com.tms.service.CourseService;
import com.tms.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/courseAssign")
public class CourseAssignController {
	
	@Autowired
	CourseAssignService cas;
	
	@Autowired
	CourseService cs;
	
	@Autowired
	UserService us;
	
	@PostMapping("/addCourse")
	public CourseAssign addAssignment(User user,@RequestBody CourseAssign ca) throws Exception{
//		User user;
//		Course course;
//		String uname=user.getUserName();
//		String cname=course.getCourseName();
		User u1=us.findUserByName(ca.getUserName());
		Course c1=cs.findCourseByName(ca.getCourseName());
		//String uRole=us.findRoleByUser(ca.getUserName());
		if(u1.getRole().equals("manager") ) {
			throw new Exception("Can't assign to manager");
		}
		CourseAssign ca2=cas.findAssignmentByUnameAndCname(ca.getUserName(), ca.getCourseName());
		CourseAssign ca3=null;
		if(u1==null || c1==null ) {
			throw new Exception(ca.getUserName()+" or "+ca.getCourseName()+" dosen't exist");
		}
		
		if(ca2==null) {
				ca3=cas.addAssignment(ca);
		}else {
			throw new Exception("Assignment already exists");
		}
		return ca3;
	}
	@DeleteMapping("/deleteAssignment/{uId}")
	public CourseAssign deleteAssignmentById(@PathVariable int uId) {
		CourseAssign cd=cas.deleteAssignmentById(uId);
		return cd;
	}
	@RequestMapping("/viewAssignments")
	public List<CourseAssign> viewAllAssignments(){
		List<CourseAssign> cw=cas.viewAllAssignment();
		return cw;
	}
}
