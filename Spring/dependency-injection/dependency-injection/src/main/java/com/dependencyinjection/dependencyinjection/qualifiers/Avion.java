package com.dependencyinjection.dependencyinjection.qualifiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Avion implements volador{

    private static final Logger log = LoggerFactory.getLogger(Pajaro.class);

    @Override
    public void volar() {
        log.info("Estoy volando");
    }
}
