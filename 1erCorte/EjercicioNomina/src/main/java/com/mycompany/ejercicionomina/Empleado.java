/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicionomina;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public class Empleado {
    private String dni;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String cuentaCorriente;
    private List<Contrato> contratos;
    private List<Nomina> nominas;
    
    public Empleado(String dni, String nombre, String apellidos, String telefono, String direccion, String cuentaCorriente) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cuentaCorriente = cuentaCorriente;
        this.contratos = new ArrayList<>();
        this.nominas = new ArrayList<>();
    }
    
    public void agregarContrato(Contrato contrato) {
        this.contratos.add(contrato);
    }
    
    public Nomina generarNomina(Contrato contrato, LocalDate fecha) {
        Nomina nomina = new Nomina(this, contrato, fecha);
        this.nominas.add(nomina);
        return nomina;
    }
    
    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void setCuentaCorriente(String cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    //Hacemos una verificacion para que el empleado pueda visualizar si tiene su informacion completa
    public void verificarInformacion() {
        if (telefono == null || telefono.isEmpty() || cuentaCorriente == null || cuentaCorriente.isEmpty()) {
            System.out.println("Informacion incompleta. Por favor actualizar.");
        } else {
            System.out.println("Informacion completa.");
        }
    }
    
    //Actualizamos el contrato actual
    public void actualizarCategoriaContrato(Contrato contrato, Categoria nuevaCategoria) {
        contrato.setCategoria(nuevaCategoria);
    }
    
    @Override
    public String toString() {
        return "Empleado{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + " " + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", contratos=" + contratos +
                '}';
    }
}