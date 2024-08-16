package com.dependencyinjection.dependencyinjection.atributo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
//@Service
public class Motor {

    private String marca;

    private Integer modelo;

    public Motor(){}

    /*public Motor(String marca, Integer modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }*/

    public String getMarca() {
        return marca;
    }

    @Value("XL")
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getModelo() {
        return modelo;
    }

    @Value("1982")
    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "marca='" + marca + '\'' +
                ", modelo=" + modelo +
                '}';
    }
}
