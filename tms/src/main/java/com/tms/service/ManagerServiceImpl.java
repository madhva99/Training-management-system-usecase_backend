package com.tms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.dao.ManagerDao;
import com.tms.entity.Manager;

@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	ManagerDao managerDao;
	
	@Override
	public Manager addManager(Manager manager) {
		return managerDao.addManager(manager);
	}

	@Override
	public Manager loginManager(String managerEmail, String managerPw) {
		return managerDao.loginManager(managerEmail, managerPw);
	}

	@Override
	public Manager findManagerByEmail(String managerEmail) {
		return managerDao.findManagerByEmail(managerEmail);
	}

}
