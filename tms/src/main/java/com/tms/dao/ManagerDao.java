package com.tms.dao;

import com.tms.entity.Manager;

public interface ManagerDao {
	Manager addManager (Manager manager);
	Manager findManagerByEmail(String managerEmail);
	Manager loginManager (String managerEmail,String managerPw);
}
