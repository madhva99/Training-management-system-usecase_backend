package com.tms.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="tms_user")
public class User {
	@Id
	@SequenceGenerator(name = "seq_user",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "seq_user")
	private int userId;
	@Column(nullable = false)
	private String userEmail;
	@Column(nullable = false)
	private String userName;
	@Column(nullable = false)
	private String userPw;
	@Column(nullable = false)
	private String role;
	@ManyToMany
	@JoinColumn(name = "courseId")
	private List<Course> courses;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
