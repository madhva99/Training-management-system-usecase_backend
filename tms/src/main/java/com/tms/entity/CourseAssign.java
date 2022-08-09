package com.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tms_course_assign")
public class CourseAssign {
	
	@Id
	@SequenceGenerator(name = "se_course",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "se_course")
	private int uId;
	@Column(nullable = false,updatable = false,unique = false)
	private String userName;
	@Column(nullable = false,updatable = false,unique = false)
	private String courseName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	
}
