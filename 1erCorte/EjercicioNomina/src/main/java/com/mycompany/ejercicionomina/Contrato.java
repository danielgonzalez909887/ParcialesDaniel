/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicionomina;

/**
 *
 * @author DANIEL
 */
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Contrato {
    private LocalDate fechaAlta;
    private LocalDate fechaBaja; //puede ser null si el contrato es indefinido
    private Categoria categoria;
    private String puestoDestino;
    private List<Complemento> complementos;
    private List<ComplementoPorCargo> complementosPorCargo;
    
    public Contrato(LocalDate fechaAlta, LocalDate fechaBaja, Categoria categoria, String puestoDestino) {
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.categoria = categoria;
        this.puestoDestino = puestoDestino;
        this.complementos = new ArrayList<>();
        this.complementosPorCargo = new ArrayList<>();
    }
    
    //Consultamos el sueldo base del empleado
    public double getSueldoBase() {
        return categoria.getSueldoBase();
    }
    
    //Agregamos los complementos
    public void addComplemento(Complemento complemento) {
        this.complementos.add(complemento);
    }
    
    //Metodo para agregar un complemento por cargo con fecha de inicio y fin
    public void addComplementoPorCargo(String descripcion, double valor, LocalDate fechaInicio, LocalDate fechaFin) {
        this.complementosPorCargo.add(new ComplementoPorCargo(descripcion, valor, fechaInicio, fechaFin));
    }

    //Metodo para calcular el total de complementos activos en una fecha especifica
    public double getTotalComplementosActivos(LocalDate fecha) {
        double total = 0;
        for (ComplementoPorCargo c : complementosPorCargo) {
            if (c.estadoComplemento(fecha)) { //sumamos complementos activos en la fecha dada
                total += c.getValor();
            }
        }
        return total;
    }
    
    public List<Complemento> getComplementos() {
        return complementos;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }
    
    public String getPuestoDestino() {
        return puestoDestino;
    }
    
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }
    
    public LocalDate getFechaBaja() {
        return fechaBaja;
    }
    
    // Método para calcular la antigüedad en años
    public int getAntiguedad() {
        //Si el contrato ya termino usamos la fecha de baja, Si no usamos la fecha actual.
        LocalDate fechaFin = (fechaBaja != null) ? fechaBaja : LocalDate.now();
        //Calculamos la diferencia en años entre la fecha de alta y la fecha de fin
        return (int) ChronoUnit.YEARS.between(fechaAlta, fechaFin);
    }
    
    //Metodo para calcular la cantidad de trienios basados en la antigüedad
    public int getTrienios() {
         //Obtenemos los años trabajados en la empresa
        int antiguedad = getAntiguedad();
        //Calculamos la cantidad de trienios (1 trienio por cada 3 años trabajados)
        int trienios = antiguedad / 3;
        //Ponemos un limite de 5 trienios maximo para evitar sueldos demasiado altos
        return Math.min(trienios, 5);
    }
    
    //Metodo para calcular el sueldo base con trienios aplicados
    public double getSueldoBaseConTrienios() {
        //Se obtiene el sueldo base de la categoría
        double sueldoBase = categoria.getSueldoBase();
        //Se calcula cuantos trienios tiene el empleado
        int trienios = getTrienios();
        //Cada trienio incrementa el sueldo en un 5%
        double aumentoPorTrienio = sueldoBase * 0.05;
        return sueldoBase + (trienios * aumentoPorTrienio);
    }
    
    //Actualizamos la categoria y por ende se toma el sueldo de dicha categoria
    public void setCategoria(Categoria nuevaCategoria) {
        this.categoria = nuevaCategoria;
    }
    
    //Agregamos los complementos con las condiciones
    public void agregarComplementoCondicionado(Complemento complemento, boolean cumpleCondiciones) {
        if (cumpleCondiciones) {
            this.addComplemento(complemento);
            System.out.println("Complemento agregado: " + complemento.getDescripcion());
        } else {
            System.out.println("No se cumplen las condiciones para el complemento: " + complemento.getDescripcion());
        }
    }

    
    @Override
    public String toString() {
        return "Contrato{" +
                "fechaAlta=" + fechaAlta +
                ", fechaBaja=" + (fechaBaja != null ? fechaBaja : "Indefinido") +
                ", categoria=" + categoria +
                ", puestoDestino='" + puestoDestino + '\'' +
                ", complementos=" + complementos +
                '}';
    }
}