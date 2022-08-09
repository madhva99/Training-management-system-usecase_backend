package com.tms.dao;

import java.util.List;

import com.tms.entity.CourseStatus;

public interface CourseStatusDao {
	CourseStatus addStatus(CourseStatus cs);
	CourseStatus deleteStatus(int statusId);
	List<CourseStatus> viewAllStatus();
	CourseStatus findBycNameAnduName(String uName,String cName);
}
