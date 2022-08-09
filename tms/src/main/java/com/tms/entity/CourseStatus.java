package com.tms.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tms_course_status")
public class CourseStatus {
	@Id
	@SequenceGenerator(name = "st_course",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "st_course")
	private int statusId;
	@Column(nullable = false,updatable = false,unique = false)
	private String uName;
	@Column(nullable = false,updatable = false,unique = false)
	private String cName;
	@Column(nullable = false,updatable = false,unique = false)
	private LocalDateTime dateTime;
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
}
