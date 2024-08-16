package com.dependencyinjection.dependencyinjection.aop;

import com.dependencyinjection.dependencyinjection.qualifiers.Pajaro;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyAspect2 {
    private static final Logger log = LoggerFactory.getLogger(Pajaro.class);

    //Utilizando notación indicamos que todos los métodos de la clase TargetObject debe ser interceptados
    @Before("PointcutExample.targetObjectMethods()")
    public void before(JoinPoint joinPoint){
        log.info("2. Method name {}", joinPoint.getSignature().getName());
        log.info("2. Object type {}", joinPoint.getSignature().getDeclaringType());
        log.info("2. Modifiers {}", joinPoint.getSignature().getModifiers());
        log.info("2. Argumentos {}", joinPoint.getArgs());
        log.info("2. Before advice");
    }
}
