package com.tms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.dao.CoursesDao;
import com.tms.entity.Course;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CoursesDao courseDao;
	
	@Override
	public Course addCourse(Course course) {
		return courseDao.addCourse(course);
	}

	@Override
	public List<Course> viewAllCourse() {
		return courseDao.viewAllCourse();
	}

	@Override
	public Course removeCourse(int courseId) {
		return courseDao.removeCourse(courseId);
	}

	@Override
	public Course findCourseById(int courseId) {
		return courseDao.findCourseById(courseId);
	}

	@Override
	public Course findCourseByName(String courseName) {
		return courseDao.findCourseByName(courseName);
	}

	@Override
	public List<Course> searchCourse(String searchWord) {
		return courseDao.searchCourse(searchWord);
	}
	
}
