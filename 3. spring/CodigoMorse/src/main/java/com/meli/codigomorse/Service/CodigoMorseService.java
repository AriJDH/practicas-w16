package com.meli.codigomorse.Service;

import java.util.HashMap;
import java.util.Set;

public class CodigoMorseService {
    public HashMap<String, String> obtenerEquivalencias() {
        HashMap<String, String> equivalencias = new HashMap<>();
        equivalencias.put("A", ".-");
        equivalencias.put("B", "-...");
        equivalencias.put("C", "-.-.");
        equivalencias.put("CH", "----");
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
        equivalencias.put(":", "---...");
        equivalencias.put("?", "..--..");
        equivalencias.put("'", ".----.");
        equivalencias.put("-", "-....-");
        equivalencias.put("/", "-..-.");
        equivalencias.put("\"", ".-..-.");
        equivalencias.put("@", ".--.-.");
        equivalencias.put("=", "-...-");
        equivalencias.put("!", "−.−.−−");
        return equivalencias;
    }

    public String decodificarMorse(String codificado) {
        StringBuilder decodificado = new StringBuilder();
        // Split espacios
        String[] morse = codificado.split(" ");
        for (String morseActual : morse) {
            String equivalencia = morseAAscii(morseActual);
            decodificado.append(equivalencia);
        }
        return decodificado.toString();
    }
    public String morseAAscii(String morseBuscado) {
        HashMap<String, String> equivalencias = obtenerEquivalencias();
        Set<String> claves = equivalencias.keySet();
        // La clave es la letra ASCII
        for (String clave : claves) {
            String morse = equivalencias.get(clave);
            if (morse.equals(morseBuscado)) {
                return clave;
            }
        }
        return "";
    }
}
