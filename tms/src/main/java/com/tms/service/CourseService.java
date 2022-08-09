package com.tms.service;

import java.util.List;

import com.tms.entity.Course;

public interface CourseService {
	Course addCourse (Course course);
	Course findCourseById(int courseId);
	List<Course> viewAllCourse ();
	Course removeCourse (int courseId);
	Course findCourseByName (String courseName);
	List<Course> searchCourse(String searchWord);
}
