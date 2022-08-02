package com.tomas.numerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanoRestController {

    @GetMapping("/{numero}")
    public String obtenerNumeroRomano(@PathVariable int numero){

        String numeroRomano = "";

        //Almacena los números que coresponden a letras particulares en romano
        int[] numeroParticularidad = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        int numeroRestante = numero;

        //Recorre el arreglo con los números con particularidad
        for(int numeroArreglo: numeroParticularidad){

            //Adiciona al string el número romano si es mayor o igual a los números del arreglo
            while (numeroRestante >= numeroArreglo) {

                numeroRomano += obtenerLetra(numeroArreglo);
                numeroRestante -= numeroArreglo;
            }

        }

        return "El número " + numero + " es en romano = " + numeroRomano;

    }

    //Método que almacena las letras de los números romanas con alguna particularidad
    public String obtenerLetra(int numeroArreglo){

        if(numeroArreglo == 1) {
            return "I";
        } else if(numeroArreglo == 4) {
            return "IV";
        } else if(numeroArreglo == 5) {
            return "V";
        } else if(numeroArreglo == 9) {
            return "IX";
        } else if(numeroArreglo == 10) {
            return "X";
        } else if(numeroArreglo == 40) {
            return "XL";
        } else if(numeroArreglo == 50) {
            return "L";
        } else if(numeroArreglo == 90) {
            return "XC";
        } else if(numeroArreglo == 100) {
            return "C";
        } else if(numeroArreglo == 400) {
            return "CD";
        } else if(numeroArreglo == 500) {
            return "D";
        } else if(numeroArreglo == 900) {
            return "CM";
        } else if(numeroArreglo == 1000) {
            return "M";
        } else {
            return "El número ingresado no se puede convertir a romano";
        }
    }

}
