package com.dependencyinjection.dependencyinjection.qualifiers;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Nido {

    private static final Logger log = LoggerFactory.getLogger(Pajaro.class);

    @Autowired
    @Qualifier("pajarito")
    //@Primary //Permite especificar la clase por defecto cuando se va a inyectar el bean
    private Animal animal;

    public void imprimir(){
        log.info("Mi nido tiene al animal {}", animal.getNombre());
    }

}
