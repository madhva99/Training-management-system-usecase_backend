package com.tms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tms_course")
public class Course {
	
	@Id
	@SequenceGenerator(name = "seq_course",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "seq_course")
	private int courseId;
	@Column(nullable = false)
	private String courseName;
	@Column(nullable = false)
	private int course_duration;
	@Column(nullable = false)
	private String authorName;
	@ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL)
	private List<User> users;
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourse_duration() {
		return course_duration;
	}
	public void setCourse_duration(int course_duration) {
		this.course_duration = course_duration;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	
}
