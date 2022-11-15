package com.emc.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.demo.exception.ResourceNotFoundException;
import com.emc.demo.model.Student;
import com.emc.demo.repositories.StudentRepository;
@Service
public class StudentService  {

	@Autowired
	private StudentRepository studentRepository;
		

	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	
	
	//Métodos propios definidos en el repositorio
	public List<Student> getStudentsByName(String name) {
		// TODO Auto-generated method stub
		return studentRepository.findByName(name);
	}

	public List<Student> getStudentsByNameAndSurname(String name, String surname) {
		// TODO Auto-generated method stub
		return studentRepository.findByNameAndSurname(name, surname);
	}
	
	public List<Student> getStudentsByAge(int age) {
		// TODO Auto-generated method stub
		return studentRepository.findByAge(age);
	}
	//Fi mètodes afegits
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	//Afegit update i delete
	
	public Student updateStudent(Student student)
		throws ResourceNotFoundException{
		
		Optional<Student>  oldStudent = studentRepository.findById(student.getIdstudent());
		
		if (!oldStudent.isPresent()) {
			throw new ResourceNotFoundException("Resource not found...");
		} else {
			Student studentToUpdate = oldStudent.get();
			studentToUpdate.setName(student.getName());
			studentToUpdate.setSurname(student.getSurname());
			studentToUpdate.setAge(student.getAge());
			Student updatedStudent = studentRepository.save(studentToUpdate);
			return updatedStudent;
			
		}
	}
	
	public Student deleteStudent(Student student)
			throws ResourceNotFoundException{
		
		Optional<Student>  oldStudent = studentRepository.findById(student.getIdstudent());
		
		if (!oldStudent.isPresent()) {
			throw new ResourceNotFoundException("Resource not found...");
		} else {
			//get() es un mètode de Optional
			Student studentToDelete = oldStudent.get();
			studentToDelete.setName(student.getName());
			studentToDelete.setSurname(student.getSurname());
			studentToDelete.setAge(student.getAge());
			studentRepository.delete(studentToDelete);
			return studentToDelete;
		}
	}
	
	
}
