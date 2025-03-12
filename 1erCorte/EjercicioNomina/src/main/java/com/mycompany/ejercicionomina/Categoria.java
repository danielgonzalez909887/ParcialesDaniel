/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicionomina;

/**
 *
 * @author DANIEL
 */
public class Categoria {
    private String nombre;
    private double sueldoBase;
    
    public Categoria(String nombre, double sueldoBase) {
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public double getSueldoBase() {
        return sueldoBase;
    }
    
    @Override
    public String toString() {
        return "Categoria: " + nombre + " (Sueldo base: " + sueldoBase + ")";
    }
}