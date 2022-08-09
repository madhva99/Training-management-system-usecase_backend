package com.tms.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tms.entity.Manager;

@Repository
public class ManagerDaoImpl implements ManagerDao{

	@PersistenceContext
	EntityManager em;

	@Transactional
	public Manager addManager(Manager manager) {
		Manager m=em.merge(manager);
		return m;
	}
	
	@Transactional
	public Manager loginManager(String managerEmail, String managerPw) {
		String jpql="select m from Manager m where m.managerEmail=:uid and m.manager_pw=:pwd";
		TypedQuery<Manager> query=em.createQuery(jpql,Manager.class);
		query.setParameter("uid", managerEmail);
		query.setParameter("pwd", managerPw);
		Manager manager=null;
		try {
		manager=query.getSingleResult();
		}catch(Exception e) {
			return null;
		}
		return manager;
	}


	@Override
	public Manager findManagerByEmail(String managerEmail) {
		String jpql="select m from Manager m where managerEmail=:uid";
		TypedQuery<Manager> query=em.createQuery(jpql,Manager.class);
		query.setParameter("uid", managerEmail);
		Manager me=null;
		try {
			me=query.getSingleResult();
		}catch(Exception e){
			return null;
		}
		return me;
	}
	
}
