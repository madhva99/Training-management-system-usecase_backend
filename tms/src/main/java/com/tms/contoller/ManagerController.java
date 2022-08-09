package com.tms.contoller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.entity.Manager;
import com.tms.service.ManagerService;

@RestController
@CrossOrigin
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	ManagerService managerService;
	
	@PostMapping("/addManager")
	public Manager addManager (@Valid @RequestBody Manager manager)throws Exception {
		String managerEmailid=manager.getManagerEmail();
		Manager me=managerService.findManagerByEmail(managerEmailid);
		if(me!=null) {
			throw new Exception("Manager with email "+managerEmailid+" already exists");
		}
		return managerService.addManager(manager);
		
	}
	@PostMapping("/loginManager")
	public Manager loginManager(@RequestBody Manager manager) throws Exception {
		String tempEmail=manager.getManagerEmail();
		String tempPw=manager.getManager_pw();
		Manager ml=null;
		if(tempEmail!=null&&tempPw!=null) {
			 ml=managerService.loginManager(tempEmail, tempPw);
		}
		if(ml==null) {
			throw new Exception("Invalid Credentials");
		}
		System.out.println("Logged in successfully");
		return ml;
	}
	
}
