/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicionomina;

import java.time.LocalDate;

/**
 *
 * @author DANIEL
 */
public class EjercicioNomina {

    public static void main(String[] args) {
        // Crear algunas categorías
        Categoria catAdministrativo = new Categoria("Administrativo", 1000.0);
        Categoria catProfesional = new Categoria("Profesional", 2000.0);
        
        // Crear un empleado
        Empleado empleado1 = new Empleado("123456789", "Juan", "Perez", "304304", "Villa grande", "100123");
        
        // Crear un contrato para el empleado (sin fecha de baja, contrato indefinido)
        Contrato contrato1 = new Contrato(LocalDate.of(2020, 1, 1), null, catAdministrativo, "Oficina Central");
        
        // Agregar complementos al contrato
        contrato1.addComplemento(new Complemento("Complemento de Puesto", 200.0));
        contrato1.addComplemento(new Complemento("Complemento por Antiguedad", 150.0));
        
        // Agregar el contrato al empleado
        empleado1.agregarContrato(contrato1);
        
        // Generar una nómina para el contrato actual
        Nomina nomina1 = empleado1.generarNomina(contrato1, LocalDate.now());
        
        
        
        //Agregar complemento con condiciones:-----------------------------------

        // Crear contrato
        Contrato contrato = new Contrato(LocalDate.of(2020, 1, 1), null, catProfesional, "Ingeniero");

        // Crear un complemento
        Complemento bonoDesempeno = new Complemento("Bono por desempeño", 400.0);

        // Condición de ejemplo: el empleado cumplió sus metas
        boolean cumpleMetas = true;

        // Intentar agregar el complemento con condición
        contrato.agregarComplementoCondicionado(bonoDesempeno, cumpleMetas);

        // Mostrar complementos asignados
        System.out.println("Complementos actuales: " + contrato.getComplementos());
        
        // Imprimir datos de la nómina
        System.out.println(nomina1);
        
        
        
        //Calculo de complemento por cargos:--------------------------------
        
        // Crear una categoría con sueldo base
        Categoria catGerente = new Categoria("Gerente", 3000.0);

        // Crear contrato con fecha de alta hace 5 años
        Contrato contrato2 = new Contrato(LocalDate.of(2018, 1, 1), null, catGerente, "Gerente");

        // Agregar un complemento por cargo (Gerente) con una duración de 3 años
        contrato2.addComplementoPorCargo("Bono de liderazgo", 500.0, LocalDate.of(2018, 1, 1), LocalDate.of(2021, 1, 1));

        // Agregar un nuevo complemento por un ascenso a Director en 2022
        contrato2.addComplementoPorCargo("Bono de Director", 800.0, LocalDate.of(2022, 1, 1), null);

        // Consultar complementos activos en 2020 (Debería sumar 500 porque aún era Gerente)
        System.out.println("Complementos activos en 2020: " + contrato2.getTotalComplementosActivos(LocalDate.of(2020, 6, 1)));//YYYY/MM/DD

        // Consultar complementos activos en 2023 (Debería sumar 800 porque ahora es Director)
        System.out.println("Complementos activos en 2023: " + contrato2.getTotalComplementosActivos(LocalDate.of(2023, 6, 1)));//YYYY/MM/DD
        
        
        
        
        //Crear nomina con calculo de deducciones:----------------------------------------------------------------
        //Crear un contrato con fecha de alta hace 6 años
        Contrato contrato3 = new Contrato(LocalDate.of(2018, 1, 1), null, catProfesional, "Ingeniero");

        //Agregar un complemento activo
        contrato3.addComplementoPorCargo("Bono de productividad", 500.0, LocalDate.of(2020, 1, 1), null);

        //Crear un empleado
        Empleado empleado2 = new Empleado("123450055", "Daniel", "Gonzalez", "3041235", "Ternera", "90012345");

        //Asignar el contrato al empleado
        empleado2.agregarContrato(contrato3);

        //Generar una nomina para este empleado
        Nomina nomina = empleado2.generarNomina(contrato3, LocalDate.of(2024, 1, 1));

        //Mostrar la nomina con deducciones calculadas
        System.out.println(nomina);
    }
}
