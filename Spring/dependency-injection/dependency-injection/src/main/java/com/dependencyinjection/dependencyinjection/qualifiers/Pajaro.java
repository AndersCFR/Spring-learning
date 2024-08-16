package com.dependencyinjection.dependencyinjection.qualifiers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pajarito") //Especifica el bean a usar
public class Pajaro extends Animal implements volador{

    private static final Logger log = LoggerFactory.getLogger(Pajaro.class);

    public Pajaro(@Value("Pajaro Loco") String nombre, @Value("2") Integer edad) {
        super(nombre, edad);
    }

    @Override
    public void volar() {
        log.info("estoy volando");
    }
}
