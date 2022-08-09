package com.tms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tms.entity.CourseStatus;

@Repository
public class CourseStatusDaoImpl implements CourseStatusDao{

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public CourseStatus addStatus(CourseStatus cs) {
		if(cs.getcName()!=null || cs.getuName()!=null) {
			em.persist(cs);
			em.flush();
		}
		return em.merge(cs);
		
	}

	@Transactional
	public CourseStatus deleteStatus(int statusId) {
		CourseStatus cs1=em.find(CourseStatus.class, statusId);
		em.remove(cs1);
		return cs1;
	}

	@Transactional
	public List<CourseStatus> viewAllStatus() {
		String jpql="select c from CourseStatus c";
		Query query=em.createQuery(jpql, CourseStatus.class);
		List<CourseStatus> cs2=query.getResultList();
		return cs2;
	}

	@Transactional
	public CourseStatus findBycNameAnduName(String uName, String cName) {
		String jpql="select c from CourseStatus c where c.uName=:userN and c.cName=:courseN";
		TypedQuery<CourseStatus> query=em.createQuery(jpql, CourseStatus.class);
		query.setParameter("userN", uName);
		query.setParameter("courseN", cName);
		CourseStatus cs3=null;
		try {
			cs3=query.getSingleResult();
		}catch(Exception e) {
			return null;
		}
		return cs3;
	}

}
