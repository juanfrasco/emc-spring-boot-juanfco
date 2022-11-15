package com.emc.demo;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
//Clase que arranca el programa
@SpringBootApplication
public class SpringEmcWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmcWebApiApplication.class, args);
	}
	
	@EventListener({ApplicationReadyEvent.class})
	void applicationReadyEvent() {
		if(System.getenv("DYNO") == null) {
			System.out.println("Lanzo el browser");
			browse("http://localhost:8080/swagger-ui/index.html");
			//browse("https://emc-spring-boot--juanfco.herokuapp.com/swagger-ui/index.html");
		} else {
			System.out.println("Estoy en Heroku");
		}
		
		
	}
	
	public static void browse(String url) {
		System.setProperty("java.awt.headless", "false");
		Desktop desktop1 = Desktop.getDesktop();
		try {
			desktop1.browse(new URI(url));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
