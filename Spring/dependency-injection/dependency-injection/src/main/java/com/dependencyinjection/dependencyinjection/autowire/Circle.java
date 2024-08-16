package com.dependencyinjection.dependencyinjection.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Figure {

    // ejemplo de value obtenido de properties pasado por config
    // en caso de que no se encuentre se usará 1
    @Value("${circle.radius:1}")
    private double radius;
    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

}
