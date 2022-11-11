package com.emc.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emc.demo.service.StudentService;
import com.emc.demo.model.Student;
@CrossOrigin
@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping(path="/students", produces = "application/json")
	@CrossOrigin
	public ResponseEntity<List<Student>> getStudents(){
		List<Student> studentList = studentService.getStudents();
		//System.out.println(studentList);
		return ResponseEntity.ok(studentList);
	}

	@PostMapping(path="/students")
	@CrossOrigin
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}
	
}