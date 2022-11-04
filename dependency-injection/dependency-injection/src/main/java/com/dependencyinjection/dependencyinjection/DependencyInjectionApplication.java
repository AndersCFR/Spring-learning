package com.dependencyinjection.dependencyinjection;

import com.dependencyinjection.dependencyinjection.atributo.Coche;
import com.dependencyinjection.dependencyinjection.atributo.Motor;
import com.dependencyinjection.dependencyinjection.qualifiers.Animal;
import com.dependencyinjection.dependencyinjection.qualifiers.Nido;
import com.dependencyinjection.dependencyinjection.qualifiers.Pajaro;
import com.dependencyinjection.dependencyinjection.qualifiers.Perro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

	private static final Logger log = LoggerFactory.getLogger(Pajaro.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);
		/*
		// DI
		Motor motor = new Motor("xl", 1984);
		Coche coche = new Coche("Wolswagen", 1866, motor);*/
		//Coche coche = context.getBean(Coche.class);

		// DI usando la clase
		//Perro perro = context.getBean(Perro.class);
		//Pajaro pajaro = context.getBean(Pajaro.class);
		//log.info("Objeto : "+ pajaro.getNombre());

		// FORMAS DE INYECCIÓN CUANDO UNA CLASE PADRE TIENE MÚLTIPLES IMPLEMENTACIONES

		// Forma 1, usando la sobrecarga en getBean
		// DI usando clase padre y especificando Qualifier
		// Por defecto el nombre del Qualifier es el mismo nombre de la clase pero en minúsucula
		// Caso contrario en el decorador Component especifico el nombre del Qualifier
		Animal animal = context.getBean("pajarito",Animal.class);
		log.info("Animal nombre = {} edad = {}", animal.getNombre(), animal.getEdad());

		// Forma 2, usando solo la clase y especificando el Qualifier en la clase
		// DI usando qualifier, en este ejemplo Nido necesita de un animal que debe ser pájaro
		// Por lo que especificaremos que el Qualifier es un pájaro en la clase nido
		Nido nido = context.getBean(Nido.class);
		nido.imprimir();

		// Forma 3, se puede definir un bean por default usando @Primary
	}

}
