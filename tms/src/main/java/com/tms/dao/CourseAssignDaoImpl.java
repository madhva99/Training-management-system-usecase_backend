package com.tms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tms.entity.CourseAssign;

@Repository
public class CourseAssignDaoImpl implements CourseAssignDao{

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public CourseAssign addAssignment(CourseAssign courseAssign) {
		if(courseAssign.getCourseName()!=null || courseAssign.getUserName()!=null) {
			em.persist(courseAssign);
			em.flush();
		}
		return em.merge(courseAssign);
		
	}

	@Transactional
	public CourseAssign findAssignmentByUser(String userName) {
		CourseAssign ca=em.find(CourseAssign.class, userName);
		return ca;
	}

//	@Transactional
//	public CourseAssign deleteAssignmentByUser(String userName,String courseName) {
//		String jpql="delete from CourseAssign c where c.userName=:uName and c.courseName:=cName";
//		em.getTransaction().begin();
//		TypedQuery<CourseAssign>query=em.createQuery(jpql, CourseAssign.class);
//		query.setParameter("uName", userName);
//		query.setParameter("cName", courseName);
//		em.getTransaction().commit();
//		CourseAssign cad=null;
//		try {
//			cad=query.getSingleResult();
//		}catch(Exception e){
//			return null;
//		}
//		return cad;
//	}
	

	@Transactional
	public List<CourseAssign> viewAllAssignment() {
		String jqpl="select a from CourseAssign a";
		Query query=em.createQuery(jqpl, CourseAssign.class);
		List<CourseAssign> ca=query.getResultList();
		return ca;
	}

	@Transactional
	public CourseAssign findAssignmentByUnameAndCname(String userName, String courseName) {
		String jpql="select c from CourseAssign c where c.userName=:uName and c.courseName=:cName";
		TypedQuery<CourseAssign>query=em.createQuery(jpql, CourseAssign.class);
		query.setParameter("uName", userName);
		query.setParameter("cName", courseName);
		CourseAssign ca1=null;
		try {
			ca1=query.getSingleResult();
		}catch (Exception e) {
			return null;
		}
		return ca1;
	}

	@Transactional
	public CourseAssign deleteAssignmentById(int uId) {
		CourseAssign cad=em.find(CourseAssign.class, uId);
		em.remove(cad);
		return cad;
	}
	
	

}
