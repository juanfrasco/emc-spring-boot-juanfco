package com.emc.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

//La anotación Data de Lombok genera los constructores, setters i getters, todo
//lo necesario para un java bean
@Data
@Entity
//JPA
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idstudent;
	
	@Column
	private String name;
	
	@Column
	private String surname;
	
	@Column
	private int age;

}
