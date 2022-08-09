package com.tms.contoller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.entity.CourseStatus;
import com.tms.service.CourseAssignService;
import com.tms.service.CourseStatusService;

@RestController
@CrossOrigin
@RequestMapping("/courseStatus")
public class CourseStatusController {

	@Autowired
	CourseStatusService css;
	
	@Autowired
	CourseAssignService cas;
	
	@PostMapping("/addStatus")
	public CourseStatus addStatus(@RequestBody CourseStatus cs) throws Exception{
		CourseStatus cs2=css.findBycNameAnduName(cs.getuName(), cs.getcName());
		if(cs2!=null) {
			throw new Exception("Already completed");
		}
		cs.setDateTime(LocalDateTime.now());
		CourseStatus cs1=css.addStatus(cs);
		return cs1;
	}
	@RequestMapping("/viewStatus")
	public List<CourseStatus> viewAllStatus(){
		List<CourseStatus> cs3=css.viewAllStatus();
		return cs3;
	}
}
