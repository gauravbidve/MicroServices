package com.jbk.student.dao;

import com.jbk.student.entity.Student;

public interface StudentDao {

	public boolean saveStudent(Student student);
	public Student getStudent(int studentId);
	
}
