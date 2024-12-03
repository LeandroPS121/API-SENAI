package com.example.demo.model;

import java.time.LocalDate;

public class Historico {
    private Long userId;
    private double a;
    private double b;
    private double c;
    private String raizes;
    private LocalDate data;

    // Construtores, Getters e Setters
    public Historico(Long userId, double a, double b, double c, String raizes, LocalDate data) {
        this.userId = userId;
        this.a = a;
        this.b = b;
        this.c = c;
        this.raizes = raizes;
        this.data = data;
    }

    // Getters e Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public String getRaizes() {
        return raizes;
    }

    public void setRaizes(String raizes) {
        this.raizes = raizes;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }    
}