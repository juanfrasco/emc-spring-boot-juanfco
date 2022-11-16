package com.emc.demo.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.emc.demo.model.Student;
//La idea es crear els test a l'entorn de laboratori, ja que possiblement no es pot
//accedir a la base de dades en producció. Per això utilitzem H2

//@DataJpaTest per defecte arrenca Spring Boot i també per defecte H2 ja que un test unitari no ha de dependre
//d'un servei extern. Es crearan les taules automàticament a partir dels models
@DataJpaTest
//@AutoConfigureTestDatabase(replace= Replace.NONE)
class StudentRepositoryTest {
	
	//Injectem dos 
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	StudentRepository repository;

	@Test
	void testFindByName() {
		//Es crea un objecte student
		Student student = new Student();
		student.setName("Jordi");
		student.setSurname("Pujol");
		student.setAge(24);
		
		//Es guarda a la base de dades
		entityManager.persist(student);
		entityManager.flush();
		//Fem la prova
		List<Student> studentList = repository.findByName("Jordi");
		
		assertTrue(studentList.size()>0);
		
		
	}

	@Test
	void testFindByNameAndSurname() {
		// Es crea un objecte student
		Student student = new Student();
		student.setName("Jordi");
		student.setSurname("Pujol");
		student.setAge(24);

		// Es guarda a la base de dades
		entityManager.persist(student);
		entityManager.flush();
		// Fem la prova
		List<Student> studentList = repository.findByNameAndSurname("Jordi", "Pujol");

		assertTrue(studentList.size() > 0);
	}

	@Test
	void testFindByAge() {
		// Es crea un objecte student
		Student student = new Student();
		student.setName("Jordi");
		student.setSurname("Pujol");
		student.setAge(24);

		// Es guarda a la base de dades
		entityManager.persist(student);
		entityManager.flush();
		// Fem la prova
		List<Student> studentList = repository.findByAge(24);

		assertTrue(studentList.size() > 0);
	}

}
