package com.tms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.dao.CourseAssignDao;
import com.tms.entity.CourseAssign;

@Service
public class CourseAssignServiceImpl implements CourseAssignService{

	@Autowired
	CourseAssignDao cad;
	
	@Override
	public CourseAssign addAssignment(CourseAssign courseAssign) {
		CourseAssign ca=cad.addAssignment(courseAssign);
		return ca;
	}

	@Override
	public CourseAssign findAssignmentByUser(String userName) {
		CourseAssign ca=cad.findAssignmentByUser(userName);
		return ca;
	}

	@Override
	public CourseAssign deleteAssignmentById(int uId) {
		CourseAssign ca=cad.deleteAssignmentById(uId);
		return ca;
	}

	@Override
	public List<CourseAssign> viewAllAssignment() {
		List<CourseAssign> ca=cad.viewAllAssignment();
		return ca;
	}

	@Override
	public CourseAssign findAssignmentByUnameAndCname(String userName, String courseName) {
		CourseAssign ca=cad.findAssignmentByUnameAndCname(userName, courseName);
		return ca;
	}

}
