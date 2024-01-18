package com.internwings.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Rollno;
	
	@Column(name = "student_name", nullable = false, updatable = false)
	String name;
	
	@Column(name = "student_grade", nullable = false)
	double grade;
	
	
	
	
	

}
