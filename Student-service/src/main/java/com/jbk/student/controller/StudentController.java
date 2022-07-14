package com.jbk.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.student.entity.Student;
import com.jbk.student.model.StudentBranch;
import com.jbk.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService service;
	
	@PostMapping("/saveStudent")
	public ResponseEntity<String> saveStudent(@RequestBody Student student){
		
		boolean value = service.saveStudent(student);
		
		if(value) {
			return new ResponseEntity<String>("Saved...!!!", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Something went wrong...!!!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/getStudent")
	public ResponseEntity<Student> getStudent(@RequestParam int studentId){
		
		Student student = service.getStudent(studentId);
		
		if(student!=null) {
			return new ResponseEntity<Student>(student,HttpStatus.OK);
		}else {
			return new ResponseEntity<Student>(student,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/getStudentWithBranch")
	public ResponseEntity<StudentBranch> getStudentWithBranch(@RequestParam int studentId){
		
		StudentBranch studentBranch = service.getStudentWithBranch(studentId);
		
		if(studentBranch != null) {
			return new ResponseEntity<StudentBranch>(studentBranch,HttpStatus.OK);
		}else {
			return new ResponseEntity<StudentBranch>(studentBranch,HttpStatus.NO_CONTENT);
		}
	
	}
	
}
