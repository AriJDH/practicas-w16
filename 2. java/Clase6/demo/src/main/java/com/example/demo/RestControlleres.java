package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestControlleres {

    @GetMapping
    public String sayHello(){
        return "hola";
    }

    @GetMapping("/{name}")
    public String sayHellomasName(@PathVariable String name){
        return "hola"+name;
    }
    /*
    1 → I
    2 → II
    3 → III
    4 → IV

    5 → V
    7 → VII
    10 → X
    13 → XIII

    50 → L
    100 → C
    500 → D
    1000 → M
    */
    @GetMapping("/numeros/{numero}")
    public  String cambio(@PathVariable Integer numero){
        //StringBuilder clases que almacenan cadena de caracteres
        StringBuilder resul=new StringBuilder();
        String[] numerosRomanos={"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "VII", "I"};
        int[] numerosComunes={1000,900,500,400,100,90,50,40,10, 7, 5, 4, 1};
        for(int i=0;i<numerosComunes.length;i++){
            for (;numero>=numerosComunes[i];numero -=numerosComunes[i]){
                System.out.println(numero);
                System.out.println(numerosComunes[i]);
                System.out.println(numerosRomanos[i]);
                resul.append(numerosRomanos[i]);
            }
        }

        return resul.toString();
    }

    @GetMapping("/morse/{palabra}")
    public  String Morse(@PathVariable String palabra){
        //StringBuilder clases que almacenan cadena de caracteres
        String[] morseCode={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--"
                            ,"-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
                            ,".----","..---","...--","....-",".....","-....","--...","---..","----.","-----"};
        String[] abecedario={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t"
                            ,"u","v","w","x","y","z","1","2","3","4","5","6","7","8","9","0"};
        String[] arrPalabra=palabra.split("   ");
        for (String l:arrPalabra){
            System.out.println(l);
        };
        StringBuilder resul=new StringBuilder();
        for(int i=0;i< arrPalabra.length;i++){
            String[] c=arrPalabra[i].split(" ");
            for (int h=0;h< c.length;h++){
               // System.out.println(c[i]);
                for (int j=0;j< morseCode.length;j++)
                if (c[h].equals(morseCode[j])) {
                    resul.append(abecedario[j].toUpperCase(Locale.ROOT));
                }
            }
                resul.append(" ");

        }
        return resul.toString();
    }

    @GetMapping("/morse/mejor/{codigo}")
    public  String MorseMejor(@PathVariable String codigo){
        HashMap<String, String> diccionario = new HashMap<>();

        diccionario.put(".-","A");
        diccionario.put("-...","B");
        diccionario.put("-.-.","C");
        diccionario.put("-..","D");
        diccionario.put(".","E");
        diccionario.put("..-.","F");
        diccionario.put("--.","G");
        diccionario.put("....","H");
        diccionario.put("..","I");
        diccionario.put(".---","J");
        diccionario.put("-.-","K");
        diccionario.put(".-..","L");
        diccionario.put("--","M");
        diccionario.put("-.","N");
        diccionario.put("---","O");
        diccionario.put(".--.","P");
        diccionario.put("--.-","Q");
        diccionario.put(".-.","R");
        diccionario.put("...","S");
        diccionario.put("-","T");
        diccionario.put("..-","U");
        diccionario.put("...-","V");
        diccionario.put(".--","W");
        diccionario.put("-..-","X");
        diccionario.put("-.--","Y");
        diccionario.put("--..","Z");
        diccionario.put("-----","0");
        diccionario.put(".----","1");
        diccionario.put("..---","2");
        diccionario.put("...--","3");
        diccionario.put("....-","4");
        diccionario.put(".....","5");
        diccionario.put("-....","6");
        diccionario.put("--...","7");
        diccionario.put("---..","8");
        diccionario.put("----.","9");
        diccionario.put("..--..","?");
        diccionario.put("-.-.--","!");
        diccionario.put(".-.-.-",".");
        diccionario.put("--..--",",");



        String[] palabras = codigo.split("   ");
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < palabras.length; i++) {
            String[] caracter = palabras[i].split(" ");
            for (int j = 0; j < caracter.length; j++){
                resultado.append(diccionario.get(caracter[j]));
            }
            resultado.append(" ");
        }

        return resultado.toString();

    }


}
