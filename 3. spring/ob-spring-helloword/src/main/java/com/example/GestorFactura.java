package com.example;

public class GestorFactura {

    // 1. Atributo
    CalculatorService calculatorService;

    //2. Constructores
    public GestorFactura(CalculatorService calculatorService){
        System.out.println("Ejecutando constructor GestorConstructor");
        this.calculatorService = calculatorService;
    }




}
