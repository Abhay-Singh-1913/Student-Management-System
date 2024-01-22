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
		
		public boolean updateStudentDetails(String updated_name,double updated_grade, int rollno) {
			Student student = searchStudent(rollno);
			if (student != null && updated_grade == 0) {
				student.setName(updated_name);
				entityTransaction.begin();
				entityManager.merge(student);
				entityTransaction.commit();
				return true;
			}else if (student != null && updated_name == null) {
				student.setGrade(updated_grade);
				entityTransaction.begin();
				entityManager.merge(student);
				entityTransaction.commit();
				return true;
			}
			return false;
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
			String jpql = "SELECT std FROM Student std";
			TypedQuery<Student> query = entityManager.createQuery(jpql, Student.class);
			return query.getResultList();
		}
		
}
