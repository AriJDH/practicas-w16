package com.tomas.codigomorse;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceTraduccionMorse {

    //Método que realiza la traducción
    public String realizarTraduccion(String codigo) {

        String traduccion = "";
        Map<String, String> diccionario = new HashMap();

        diccionario = armarDiccionario();

        //Particiona por un solo espacio
        String[] codigoPartes = codigo.split(" ");

        int contadorEspacioPalabras = 0;
        for(String elemento: codigoPartes){

            //Si el arreglo trae espacios, los cuenta y cuando es 2 añade el espacio (por palabras)
            if(elemento.equals("")) {
                contadorEspacioPalabras += 1;
                if(contadorEspacioPalabras == 2){
                    traduccion += " ";
                }

            } else {
                //Busca el código morse en el diccionario
                traduccion += diccionario.get(elemento);
            }

        }
        return traduccion;
    }


    //Método que crea el diccionario
    public Map<String, String> armarDiccionario() {

        Map<String, String> diccionario = new HashMap();

        diccionario.put(".-", "A");
        diccionario.put("-...", "B");
        diccionario.put("-.-.", "C");
        diccionario.put("-..", "D");
        diccionario.put(".", "E");
        diccionario.put("..-.", "F");
        diccionario.put("--.", "G");
        diccionario.put("....", "H");
        diccionario.put("..", "I");
        diccionario.put(".---", "J");
        diccionario.put("-.-", "K");
        diccionario.put(".-..", "L");
        diccionario.put("--", "M");
        diccionario.put("-.", "N");
        diccionario.put("---", "O");
        diccionario.put(".--.", "P");
        diccionario.put("--.-", "Q");
        diccionario.put(".-.", "R");
        diccionario.put("...", "S");
        diccionario.put("-", "T");
        diccionario.put("..-", "U");
        diccionario.put("...-", "V");
        diccionario.put(".--", "W");
        diccionario.put("-..-", "X");
        diccionario.put("-.--", "Y");
        diccionario.put("--..", "Z");
        diccionario.put(".----", "1");
        diccionario.put("..---", "2");
        diccionario.put("...--", "3");
        diccionario.put("....-", "4");
        diccionario.put(".....", "5");
        diccionario.put("-....", "6");
        diccionario.put("--...", "7");
        diccionario.put("---..", "8");
        diccionario.put("----.", "9");
        diccionario.put("-----", "0");
        diccionario.put("..--..", "?");
        diccionario.put("-.-.--", "!");
        diccionario.put(".-.-.-", ".");
        diccionario.put("--..--", ",");

        return diccionario;

    }

}
