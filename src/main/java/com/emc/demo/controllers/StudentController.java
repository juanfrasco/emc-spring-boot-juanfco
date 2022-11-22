package com.emc.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.emc.demo.model.Student;
//Aquesta classe connecta amb WebServices via RestTemplate
@Controller
public class StudentController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${webservice.url}")
	String fooResourceUrl = "";
	
	@GetMapping("/studentList")
	public String getStudents(Model model) {

		//String fooResourceUrl = "";

		//Les URLs també haurien d'anar amb variables d'entorn
//		if (System.getenv("DYNO") == null) {
//			fooResourceUrl = "https://emc-test--juanfco.herokuapp.com/student/students";
//		} else {
//			fooResourceUrl = "http://localhost:8080/student/students";
//		}
		//Es crida a API REST  /student/students per obtenir la llista d'estudiants
		//Per fer una petició HTTP fem servir restTemplate
		ResponseEntity<Student[]> response = restTemplate
				.getForEntity(fooResourceUrl, Student[].class);
		//Retorna un array d'estudiants
		Student[] studentsArray = response.getBody();

		//Afegim al model les dades rebudes per accedir a elles des de showStudents.html
		//Convertim a llista i ho fiquem al model
		List<Student> studentList2 = Arrays.asList(studentsArray);
		model.addAttribute("students", studentList2);
		//La pagina html showStudents consultarà la clau "students"
		return "showStudents";

	}
}
