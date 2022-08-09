package com.tms.service;

import java.util.List;

import com.tms.entity.CourseAssign;

public interface CourseAssignService {
	CourseAssign addAssignment(CourseAssign courseAssign);
	CourseAssign findAssignmentByUser(String userName); 
	CourseAssign deleteAssignmentById(int uId);
	List<CourseAssign> viewAllAssignment();
	CourseAssign findAssignmentByUnameAndCname(String userName,String courseName);
}
