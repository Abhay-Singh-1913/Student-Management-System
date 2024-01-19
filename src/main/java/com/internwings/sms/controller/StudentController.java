package com.internwings.sms.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.internwings.sms.model.Student;

public class StudentController {
		
		static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pgstudent");
		static EntityManager entityManager = entityManagerFactory.createEntityManager();
		static EntityTransaction entityTransaction = entityManager.getTransaction();
		

		public boolean addStudent(Student student) {
			if (student != null) {
				entityTransaction.begin();
				entityManager.persist(student);
				entityTransaction.commit();
				return true;
			}
			return false;
		}
		
		public void update(String name, double grade) {
			if (name != null) {
				
			}
		}
		
		public boolean deleteStudent(Student student) {
			if (student != null) {
				entityTransaction.begin();
				entityManager.remove(student);
				entityTransaction.commit();
				return true;
			}
			return false;
		}
		
		public Student searchStudent(int rollno) {
			return entityManager.find(Student.class, rollno);
		}
		
		public List<Student> displayAllStudents() {
			String jpql = "SELECT std FORM Student std";
			TypedQuery<Student> query = entityManager.createQuery(jpql, Student.class);
			return query.getResultList();
		}
		
}
