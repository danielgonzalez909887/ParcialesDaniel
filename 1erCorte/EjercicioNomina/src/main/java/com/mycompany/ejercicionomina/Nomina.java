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
public class Nomina {
    private Empleado empleado;
    private Contrato contrato;
    private double percepciones;
    private double deducciones;
    private double sueldoNeto;
    private LocalDate fecha;
    
    public Nomina(Empleado empleado, Contrato contrato, LocalDate fecha) {
        this.empleado = empleado;
        this.contrato = contrato;
        this.fecha = fecha;
        calcularNomina(); //Calculamos automaticamente la nomina
    }
    
    //Metodo para calcular el IRPF segun los tramos de ingresos.
    private double calcularIRPF(double sueldoBruto) {
        if (sueldoBruto <= 17000) {
            return sueldoBruto * 0.17; // 17% hasta 17,000
        } else if (sueldoBruto <= 32000) {
            return sueldoBruto * 0.24; // 24% hasta 32,000
        } else if (sueldoBruto <= 52000) {
            return sueldoBruto * 0.37; // 37% hasta 52,000
        } else {
            return sueldoBruto * 0.43; // 43% si supera 52,000
        }
    }

    //Metodo para calcular la nomina con deducciones segun normativa fiscal
    private void calcularNomina() {
        double sueldoBase = contrato.getSueldoBaseConTrienios(); //Obtiene el sueldo con trienios
        double complementos = contrato.getTotalComplementosActivos(fecha); //Obtiene los complementos activos
        this.percepciones = sueldoBase + complementos; //Total antes de deducciones

        //Aplicamos las deducciones de acuerdo a la ley:
        double seguridadSocial = percepciones * 0.047; //4.7% Seguridad Social
        double desempleo = percepciones * 0.015; //1.5% Desempleo
        double formacion = percepciones * 0.005; //0.5% Formacion Profesional
        double irpf = calcularIRPF(percepciones); //IRPF segun tramo salarial

        this.deducciones = seguridadSocial + desempleo + formacion + irpf; //Suma total de deducciones
        this.sueldoNeto = percepciones - deducciones; //Calculo del sueldo final
    }

    public double getSueldoNeto() {
        return sueldoNeto;
    }

    //Generacion de la nomina de forma clara y comprensible para el empleado:
    @Override
    public String toString() {
        return "Nomina{" +
                "empleado=" + empleado.getNombreCompleto() +
                ", fecha=" + fecha +
                ", percepciones=" + percepciones +
                ", deducciones=" + deducciones +
                ", sueldoNeto=" + sueldoNeto +
                '}';
    }
}