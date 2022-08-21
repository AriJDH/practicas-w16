package com.bootcamp.deportistas;

import com.bootcamp.deportistas.models.Deportista;
import com.bootcamp.deportistas.repository.DeportistasRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeportistasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeportistasApplication.class, args);
		System.out.println("Hola Mundo");

		Deportista deportista1 = new Deportista("Alejandro","Patino",28, "Basketball", "Master");
		Deportista deportista2 = new Deportista("Sabrina","Ortega",17, "Football", "Junior");
		Deportista deportista3 = new Deportista("Pepito","Perez",54, "", "");
		System.out.println(deportista2.toString());

		DeportistasRepository deportistasRepository = new DeportistasRepository();
		deportistasRepository.addDeportistas(deportista1);
		deportistasRepository.addDeportistas(deportista2);
		deportistasRepository.addDeportistas(deportista3);

		System.out.println(deportistasRepository);

	}

}
