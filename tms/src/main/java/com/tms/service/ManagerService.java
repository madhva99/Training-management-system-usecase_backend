package com.tms.service;

import com.tms.entity.Manager;

public interface ManagerService {
	Manager addManager(Manager manager);
	Manager findManagerByEmail(String managerEmail);
	Manager loginManager(String managerEmail,String managerPw);
}
