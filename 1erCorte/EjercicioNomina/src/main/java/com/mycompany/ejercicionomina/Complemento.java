/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicionomina;

/**
 *
 * @author DANIEL
 */
public class Complemento {
    private String descripcion;
    private double valor;
    
    public Complemento(String descripcion, double valor) {
        this.descripcion = descripcion;
        this.valor = valor;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public double getValor() {
        return valor;
    }
    
    @Override
    public String toString() {
        return descripcion + ": " + valor;
    }
}