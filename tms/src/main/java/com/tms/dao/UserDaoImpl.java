package com.tms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tms.entity.User;

@Repository
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public User addUser(User user) {
		User u=em.merge(user);
		return u;
	}

	@Transactional
	public List<User> viewAllUser() {
		String jpql="select u from User u";
		Query query =em.createQuery(jpql,User.class);
		List<User> us=query.getResultList();
		return us;
	}

	@Transactional
	public User findUserByName(String userName) {
		String jpql="select u from User u where u.userName=:name";
		TypedQuery<User>query=em.createQuery(jpql, User.class);
		query.setParameter("name", userName);
		User ur=null;
		try {
		ur=query.getSingleResult();
		}catch(Exception e) {
			return null;
		}
		return ur;
	}

	@Transactional
	public User finduserByEmail(String email) {
		String jpql="select u from User u where u.userEmail=:uid";
		TypedQuery<User> query=em.createQuery(jpql, User.class);
		query.setParameter("uid", email);
		User u1=null;
		try {
			u1=query.getSingleResult();
		}catch(Exception e) {
			return null;
		}
		return u1;
	}

	@Transactional
	public User loginUser(String userEmail, String userPw) {
		String jpql="select u from User u where u.userEmail=:uid and u.userPw=:pwd";
		TypedQuery<User>query=em.createQuery(jpql, User.class);
		query.setParameter("uid", userEmail);
		query.setParameter("pwd", userPw);
		User user1=null;
		try {
			user1=query.getSingleResult();
		}catch(Exception e) {
			return null;
		}
		return user1;
	}

	@Transactional//Return Type Error, Don't call this method
	public String findRoleByUser(String userName) {
		String jpql="select u.role from User u where u.userName=:uName";
		Query query=em.createQuery(jpql);
		query.setParameter("uName", userName);
		String uRole= query.toString();
		return uRole;
	}

	@Transactional
	public List<User> searchUser(String userName) {
		String jpql="select u from User u where u.userName like :searchWord";
		TypedQuery<User>query=em.createQuery(jpql,User.class);
		query.setParameter("searchWord", '%'+userName+'%');
		List<User> su=null;
		try {
			su=query.getResultList();
		}catch(Exception e) {
			return null;
		}
		return su;
	}

	@Transactional
	public User updateUserRole(String role, String userName) {
		String jpql="update User u set u.role=:userRole where u.userName=:uname";
		Query query=em.createQuery(jpql);
		query.setParameter("userRole", role);
		query.setParameter("uname", userName);
		query.executeUpdate();
		User ur=null;
		try {
			ur=(User) query.getSingleResult();
		}catch(Exception e) {
			return null;
		}
		return ur;
	}

	
	

}
