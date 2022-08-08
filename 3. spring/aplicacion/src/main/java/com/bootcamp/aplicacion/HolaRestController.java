package com.bootcamp.aplicacion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaRestController {

    @GetMapping
    public String sayHello(){
        return "Hola";
    }

    @GetMapping("/{name}")
    public String sayHelloPorPathVar(@PathVariable String name){
        return "Hola " + name;
    }

    @GetMapping("/convertToRomano/{decimal}")
    public String convertToRomano(@PathVariable int decimal){
        int numeroParcial = decimal;
        int mil = decimal/1000;
        String solucion = "";

        if(mil > 0 && numeroParcial>=1000) {
            for (int i = 0; i < mil; i++) {
                solucion += "M";
            }
            numeroParcial -= mil*1000;
        }
        int quinientos = (numeroParcial)/500;

        if(quinientos > 0 && numeroParcial>=500) {
            for (int i = 0; i < mil; i++) {
                solucion += "D";
            }
            numeroParcial -= quinientos*500;
        }
        int cien = (numeroParcial)/100;

        if(cien > 0 && numeroParcial>=100) {
            for (int i = 0; i < cien; i++) {
                solucion += "C";
            }
            numeroParcial -= cien*100;
        }
        int cincuenta = (numeroParcial)/50;

        if(cincuenta > 0 && numeroParcial>=50) {
            for (int i = 0; i < cincuenta; i++) {
                solucion += "L";
            }
            numeroParcial -= cincuenta*50;
        }
        int diez = (numeroParcial)/10;

        if(diez > 0 && numeroParcial>=10) {
            for (int i = 0; i < diez; i++) {
                solucion += "X";
            }
            numeroParcial -= diez*10;
        }
        int cinco = (numeroParcial)/5;

        if(cinco > 0 && numeroParcial>=5) {
            for (int i = 0; i < cinco; i++) {
                solucion += "V";
            }
            numeroParcial -= cinco*5;
        }
        if(numeroParcial==4){
            solucion += "IV";
            numeroParcial -= 4;
        }
        if(numeroParcial>0){
            for (int i = 0; i < numeroParcial; i++) {
                solucion += "I";
            }
            numeroParcial -= numeroParcial;
        }

        return solucion;

    }
}
