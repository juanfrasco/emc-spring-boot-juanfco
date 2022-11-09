package com.emc.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//Controler del programa
//RestController indica que es un BEAN de spring y que puede ser llamada usando API REST
@RestController
public class HelloWorldController {

	static final Logger log = LoggerFactory
			.getLogger(HelloWorldController.class);

	//Indica la url que ejecutará el método http://localhost:8080/hello?name=Pepe
	@RequestMapping("/hello")
	//Permite hacer llamadas desde cualquier nombre de dominio (distinto del que tengas configurado
	//en tu aplicación). Aquí no es obligatoria
	@CrossOrigin
	public String helloWorld(
			//Parámetro que hemos de pasar al método y su valor por defecto
			@RequestParam(value = "name", defaultValue = "World") String name) {

		return "Hello " + name + "!!";
	}
}
