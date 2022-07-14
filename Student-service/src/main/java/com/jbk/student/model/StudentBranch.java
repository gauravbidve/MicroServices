package com.jbk.student.model;

import com.jbk.student.entity.Student;

public class StudentBranch {

	Student student;
	Branch brnach;

	public StudentBranch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentBranch(Student student, Branch brnach) {
		super();
		this.student = student;
		this.brnach = brnach;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Branch getBrnach() {
		return brnach;
	}

	public void setBrnach(Branch brnach) {
		this.brnach = brnach;
	}

	@Override
	public String toString() {
		return "StudentBranch [student=" + student + ", brnach=" + brnach + "]";
	}

}
