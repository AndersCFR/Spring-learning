package com.dependencyinjection.dependencyinjection.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutExample {

    //Solo definimos el pointcut, el método, no hace
    //Pointcut específico
    //@Pointcut("execution(* com.dependencyinjection.dependencyinjection.aop.TargetObject.*(..))")
    //Pointcut para todos los métodos de las clases de un paquete
    @Pointcut("within(com.dependencyinjection.dependencyinjection.aop.*)")
    public void targetObjectMethods(){}
}
