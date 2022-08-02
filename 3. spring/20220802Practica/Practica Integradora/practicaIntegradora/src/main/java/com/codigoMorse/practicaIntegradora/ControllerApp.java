package com.codigoMorse.practicaIntegradora;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController

public class ControllerApp {

    @GetMapping("/")
    public String traducir2(){

        return "raiz";
    }

    @GetMapping("{cadena}")
    public String traducir(@PathVariable String cadena){
        if (cadena.length() == 0){
            return "";
        }
        String traducido = "";
        String palabras[] = cadena.split("   ");
        for(int i = 0; i < palabras.length; i++){
            String letra[] = palabras[i].split(" ");
            for (int j = 0; j < letra.length; j++){

                traducido = traducido + decodificarLetra(letra[j]);
            }
            traducido = traducido + " ";
        }
        return traducido;
    }

    private static String decodificarLetra(String letra) {
        String resultado = "";
        switch (letra) {
            case ".-.-.-":
                resultado = ".";
                break;
            case "-.-.--":
                resultado = "!";
                break;
            case "..--..":
                resultado = "?";
                break;
            case "--..--":
                resultado = ",";
                break;
            case ".-":
                resultado = "A";
                break;
            case "-...":
                resultado = "B";
                break;
            case "-.-.":
                resultado = "C";
                break;
            case "-..":
                resultado = "D";
                break;
            case ".":
                resultado = "E";
                break;
            case "..-.":
                resultado = "F";
                break;
            case "--.":
                resultado = "G";
                break;
            case "....":
                resultado = "H";
                break;
            case "..":
                resultado = "I";
                break;
            case ".---":
                resultado = "J";
                break;
            case "-.-":
                resultado = "K";
                break;
            case ".-..":
                resultado = "L";
                break;
            case "--":
                resultado = "M";
                break;
            case "-.":
                resultado = "N";
                break;
            case "---":
                resultado = "O";
                break;
            case ".--.":
                resultado = "P";
                break;
            case "--.-":
                resultado = "Q";
                break;
            case ".-.":
                resultado = "R";
                break;
            case "...":
                resultado = "S";
                break;
            case "-":
                resultado = "T";
                break;
            case "..-":
                resultado = "U";
                break;
            case "...-":
                resultado = "V";
                break;
            case ".--":
                resultado = "W";
                break;
            case "-..-":
                resultado = "X";
                break;
            case "-.--":
                resultado = "Y";
                break;
            case "--..":
                resultado = "Z";
                break;
            case ".----":
                resultado = "1";
                break;
            case "..---":
                resultado = "2";
                break;
            case "...--":
                resultado = "3";
                break;
            case "....-":
                resultado = "4";
                break;
            case ".....":
                resultado = "5";
                break;
            case "_....":
                resultado = "6";
                break;
            case "__...":
                resultado = "7";
                break;
            case "___..":
                resultado = "8";
                break;
            case "____.":
                resultado = "9";
                break;
            case "_____":
                resultado = "0";
                break;
            default:
                break;
        }
        return resultado;
    }
}
