package com.tms.dao;

import java.util.List;


import com.tms.entity.Course;

public interface CoursesDao  {
	Course addCourse (Course course);
	Course findCourseById (int courseId);
	List<Course> viewAllCourse ();
	Course removeCourse (int courseId);
	Course findCourseByName (String courseName);
	List<Course> searchCourse(String searchWord);
}
