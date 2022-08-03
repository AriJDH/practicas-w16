package cl.morsecode.cl.services;

import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Service
public class MainService {

    public String morseAscii(String ascii){
        Hashtable<String, String> equivalencia = obtenerEquivalencias();
        return  equivalencia.getOrDefault(ascii,"");
    }

    public Hashtable<String, String> obtenerEquivalencias() {
        Hashtable<String, String> traductor = new Hashtable<>();
        traductor.put(".-","A");
        traductor.put("-...","B");
        traductor.put("-.-.", "C");
        traductor.put("----", "CH");
        traductor.put("-..","D");
        traductor.put(".","E");
        traductor.put("..-.","F");
        traductor.put("--.", "G");
        traductor.put("....","H");
        traductor.put("..","I");
        traductor.put(".---", "J");
        traductor.put("-.-","K");
        traductor.put(".-..","L");
        traductor.put("--", "M");
        traductor.put("-.","N");
        traductor.put("--.--","Ñ");
        traductor.put("---","O");
        traductor.put(".--.","P");
        traductor.put("--.-","Q");
        traductor.put(".-.","R");
        traductor.put("...","S");
        traductor.put("-","T");
        traductor.put("..-","U");
        traductor.put("...-","V");
        traductor.put(".--","W");
        traductor.put("-..-","X");
        traductor.put("-.--","Y");
        traductor.put("--..","Z");
        return traductor;
    }

    public String decodificarMorse(String codificado) {
        StringBuilder traduccion = new StringBuilder();
        String morse[] = codificado.split(" ");
        for (String letra : morse) {
            String equivalencia = morseAscii(letra);
            traduccion.append(equivalencia);
        }
        return traduccion.toString();
    }

    public String decodificarRomano(int num){
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder roman = new StringBuilder();
        for(int i=0;i<values.length;i++)
        {
            while(num >= values[i])
            {
                num = num - values[i];
                roman.append(romanLetters[i]);
            }
        }
        System.out.println("\"hola\" = " + "hola");
        return roman.toString();
    }

    public int calcularEdad(int anio, int mes, int dia){
        try {
            LocalDate dob = LocalDate.of(anio,mes,dia);
            LocalDate now = LocalDate.now();
            return Period.between(dob,now).getYears();
        }  catch (DateTimeException ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
            return -1;
        }
    }

}