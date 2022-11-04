package com.dependencyinjection.dependencyinjection.qualifiers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Perro extends Animal{

    public Perro(@Value("Puppy") String nombre, @Value("1") Integer edad) {
        super(nombre, edad);
    }
}
