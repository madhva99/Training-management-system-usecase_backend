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
import com.tms.service.CourseService;

@RestController
@CrossOrigin
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@PostMapping("/addCourse")
	public Course addCourse (@RequestBody Course course) throws Exception{
		String tempCourseName=course.getCourseName();
		Course cn=courseService.findCourseByName(tempCourseName);
		if(cn!=null) {
			throw new Exception("course with name "+tempCourseName+ " already exists ");
		}
		return courseService.addCourse(course);
	}
	@RequestMapping("/viewAllCourse")
	public List<Course> viewAllCourse(){
		return courseService.viewAllCourse();
	}
	@DeleteMapping(value = "/deleteCourse/{courseId}")
	public String removeCourse(@PathVariable int courseId) throws Exception {
		
		Course co=courseService.findCourseById(courseId);
		if(co!=null) {
		courseService.removeCourse(courseId);
		System.out.println("Course with id "+co.getCourseId()+" deleted");
		}
		else {
			throw new Exception("specified course does not exist");
//			return "specified course does not exist";
		}
		return"Course with id "+co.getCourseId()+" deleted";
	}
	@RequestMapping("/searchCourse/{searchWord}")
	public List<Course> searchCourse(@PathVariable String searchWord) throws Exception{
		List<Course>courseList=courseService.searchCourse(searchWord);
		if(courseList.isEmpty()) {
			throw new Exception("Course not available");
		}
		return courseList;
	}
}
