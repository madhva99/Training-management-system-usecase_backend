package com.tms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.tms.dao.CourseStatusDao;
import com.tms.entity.CourseStatus;

@Service
public class CourseStatusServiceImpl implements CourseStatusService{

	@Autowired
	CourseStatusDao csd;
	
	@Override
	public CourseStatus addStatus(CourseStatus cs) {
		CourseStatus cs1=csd.addStatus(cs);
		return cs1;
	}

	@Override
	public CourseStatus deleteStatus(int statusId) {
		CourseStatus cs2=csd.deleteStatus(statusId);
		return cs2;
	}

	@Override
	public List<CourseStatus> viewAllStatus() {
		List<CourseStatus> cs3=csd.viewAllStatus();
		return cs3;
	}

	@Override
	public CourseStatus findBycNameAnduName(String uName, String cName) {
		CourseStatus cs4=csd.findBycNameAnduName(uName, cName);
		return cs4;
	}

	

}
