package com.tms.service;

import java.util.List;

import com.tms.entity.CourseStatus;

public interface CourseStatusService {
	CourseStatus addStatus(CourseStatus cs);
	CourseStatus deleteStatus(int statusId);
	List<CourseStatus> viewAllStatus();
	CourseStatus findBycNameAnduName(String uName,String cName);
	
}
