package com.jbk.student.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.student.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	SessionFactory sf;
	
	@Override
	public boolean saveStudent(Student student) {
		
		Session session = null;
		boolean value = false;
		
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
			value = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return value;
	}

	@Override
	public Student getStudent(int studentId) {
		
		Session session = null;
		Student student = null; 
		
		try {
			session = sf.openSession();
			student = session.get(Student.class, studentId);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return student;
	}

}
