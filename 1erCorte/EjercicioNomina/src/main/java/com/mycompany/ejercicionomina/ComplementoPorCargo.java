/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicionomina;

import java.time.LocalDate;

/**
 *
 * @author DANIEL
 */
public class ComplementoPorCargo {
    private String descripcion;
    private double valor;
    private LocalDate fechaInicio; // Fecha en la que el empleado asume el cargo
    private LocalDate fechaFin; // Fecha en la que deja el cargo (puede ser null si aún lo tiene)

    public ComplementoPorCargo(String descripcion, double valor, LocalDate fechaInicio, LocalDate fechaFin) {
        this.descripcion = descripcion;
        this.valor = valor;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    //Metodo para verificar si el complemento está activo
    public boolean estadoComplemento(LocalDate fecha) {
        return (fecha.isAfter(fechaInicio) || fecha.isEqual(fechaInicio)) &&
               (fechaFin == null || fecha.isBefore(fechaFin));
    }

    public double getValor() {
        return valor;
    }

    public String getDescripcion() {
        return descripcion;
    }
}