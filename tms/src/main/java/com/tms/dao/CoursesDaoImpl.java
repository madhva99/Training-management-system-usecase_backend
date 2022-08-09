package com.tms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tms.entity.Course;

@Repository
public class CoursesDaoImpl implements CoursesDao{
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Course addCourse(Course course) {
		Course c=em.merge(course);
		return c;
	}
	@Transactional
	public Course findCourseById(int courseId) {
	//	String jpql="select ";
		Course cid=em.find(Course.class, courseId);
		return cid;
	}

	@Transactional
	public List<Course> viewAllCourse() {
		String jpql="select c from Course c";
		Query query=em.createQuery(jpql,Course.class);
		List<Course> cu=query.getResultList();
		return cu;
	}

	@Transactional
	public Course removeCourse(int courseId) {
		Course cr=em.find(Course.class, courseId);
		em.remove(cr);
		return cr;
	}
	@Transactional
	public Course findCourseByName(String courseName) {
		String jpql="select c from Course c where c.courseName=:name";
		TypedQuery<Course>query=em.createQuery(jpql, Course.class);
		query.setParameter("name", courseName);
		Course cur=null;
		try {
		cur=query.getSingleResult();
		}catch(Exception e) {
			return null;
		}
		return cur;
	}
	@Transactional
	public List<Course> searchCourse(String searchWord) {
		String jpql="select c from Course c where c.courseName like :searchWord";
		TypedQuery<Course>query=em.createQuery(jpql, Course.class);
		query.setParameter("searchWord", '%'+searchWord+'%');
		List<Course>cl=null;
		try {
			cl=query.getResultList();
		}catch(Exception e) {
			return null;
		}
		return cl;
	}
	
	
	
}
