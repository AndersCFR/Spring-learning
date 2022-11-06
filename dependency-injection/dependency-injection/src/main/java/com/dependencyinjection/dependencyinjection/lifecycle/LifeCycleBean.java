package com.dependencyinjection.dependencyinjection.lifecycle;

import com.dependencyinjection.dependencyinjection.qualifiers.Pajaro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope("prototype") // En caso de que cambiemos el Scope
//@Lazy // Se ejecutará cuando se injyecte (llame con getBean)
public class LifeCycleBean implements BeanNameAware, InitializingBean, DisposableBean {
    private static final Logger log = LoggerFactory.getLogger(LifeCycleBean.class);

    @Override
    public void setBeanName(String s) {
        log.info("Bean name aware {}", s);
    }

    // Se ejecutará después de la inyección de dependencias
    @PostConstruct
    public void init(){
        log.info("Post construct");
    }

    // Se ejecutará antes que el bean sea destruido
    // No se ejecutan para prototypes, se ejecutan con la terminación de la VM
    @PreDestroy
    public void destroyBean(){
        log.info("Pre destroy");
    }

    // Sobreescritura para InitializingBean
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("After properties set method");
    }

    // Sobreescritura para DisposableBean
    @Override
    public void destroy() throws Exception {
        log.info("Destroy method");
    }
}
