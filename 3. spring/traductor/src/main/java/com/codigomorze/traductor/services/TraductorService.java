package com.codigomorze.traductor.services;

import java.util.Hashtable;
import java.util.Set;

public class TraductorService {

    public Hashtable<String, String> obtenerDiccionarioClaveMorse() {
        Hashtable<String, String> equivalencias = new Hashtable<>();
        equivalencias.put("A", ".-");
        equivalencias.put("B", "-...");
        equivalencias.put("C", "-.-.");
        equivalencias.put("D", "-..");
        equivalencias.put("E", ".");
        equivalencias.put("F", "..-.");
        equivalencias.put("G", "--.");
        equivalencias.put("H", "....");
        equivalencias.put("I", "..");
        equivalencias.put("J", ".---");
        equivalencias.put("K", "-.-");
        equivalencias.put("L", ".-..");
        equivalencias.put("M", "--");
        equivalencias.put("N", "-.");
        equivalencias.put("Ñ", "--.--");
        equivalencias.put("O", "---");
        equivalencias.put("P", ".--.");
        equivalencias.put("Q", "--.-");
        equivalencias.put("R", ".-.");
        equivalencias.put("S", "...");
        equivalencias.put("T", "-");
        equivalencias.put("U", "..-");
        equivalencias.put("V", "...-");
        equivalencias.put("W", ".--");
        equivalencias.put("X", "-..-");
        equivalencias.put("Y", "-.--");
        equivalencias.put("Z", "--..");
        equivalencias.put("0", "-----");
        equivalencias.put("1", ".----");
        equivalencias.put("2", "..---");
        equivalencias.put("3", "...--");
        equivalencias.put("4", "....-");
        equivalencias.put("5", ".....");
        equivalencias.put("6", "-....");
        equivalencias.put("7", "--...");
        equivalencias.put("8", "---..");
        equivalencias.put("9", "----.");
        equivalencias.put(".", ".-.-.-");
        equivalencias.put(",", "--..--");
        equivalencias.put("?", "..--..");
        equivalencias.put("!", "−.−.−−");
        return equivalencias;
    }

    public String morseALetras(String letraEnMorse){
        Hashtable<String,String> equivalencias = obtenerDiccionarioClaveMorse();//obtenemos el diccionario definido anteriormente
        Set<String> claves = equivalencias.keySet();//generamos un set de claves del diccionario(traduccion)

        for(String clave : claves){
            if(equivalencias.get(clave).equals(letraEnMorse)){
                return clave;
            }
        }


        return "";
    }

    public String descifrarMorse(String palabraEnMorse){
        String [] palabrasEnMorse = palabraEnMorse.split("   ");
        String [] morseArray;
        StringBuilder decodificado = new StringBuilder();
        if(palabrasEnMorse.length>1){
            for(String palabraMorse : palabrasEnMorse){
                morseArray =  palabraMorse.split(" ");


                for(String letraEnMorse : morseArray){
                    String caracterDescifrado = morseALetras(letraEnMorse);
                    decodificado.append(caracterDescifrado);
                }
                decodificado.append(" ");
            }
            return decodificado.toString();
        }

        morseArray =  palabraEnMorse.split(" ");
        for(String letraEnMorse : morseArray){
            String caracterDescifrado = morseALetras(letraEnMorse);
            decodificado.append(caracterDescifrado);
        }
        return decodificado.toString();
    }

    public void descifrarPalabrasMorse(String palabrasEnMorse){

    }


}
