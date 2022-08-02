package com.bootcam.aplication;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.Locale;

@RestController
public class HolaRestController {

    @GetMapping("/")
    public String sayHello(){
        return  "Hola";
    }
    @GetMapping("/{name}")
    public String sayHelloPathV(@PathVariable String name){
        return "Hola "+name;
    }
    @GetMapping("/convertir/{numero}")
    public String convertirRomano(@PathVariable int numero)
    {
        int miles, centenas, decenas, unidad;
        String romano = "";

        miles = numero/1000;
        centenas = numero / 100 %10;
        decenas = numero / 10%10;
        unidad = numero%10;
            if(numero >3999)
            {
                return  romano;
            }
        for(int i= 1; i <= miles;i++)
            romano=romano+"M";

        switch (centenas)
        {
            case 9:
                    romano = romano+"CM";
                break;
            case 8:
            case 7:
            case 6:
            case 5:
                romano = romano+"D";
                for(int i = 6; i <=centenas; i++)
                    romano = romano+"C";
                break;
            case 4:
                romano = romano+"CD";
            default:
                for(int i = 1; i <=centenas; i++)
                    romano = romano+"C";

        }
        switch (decenas)
        {
            case 9:
                romano = romano+"XC";
                break;
            case 8:
            case 7:
            case 6:
            case 5:
                romano = romano+"L";
                for(int i = 6; i <=decenas; i++)
                    romano = romano+"X";
                break;
            case 4:
                romano = romano+"XL";
            default:
                for(int i = 1; i <=decenas; i++)
                    romano = romano+"X";

        }
        switch (unidad)
        {
            case 9:
                romano = romano+"IX";
                break;
            case 8:
            case 7:
            case 6:
            case 5:
                romano = romano+"V";
                for(int i = 6; i <=unidad; i++)
                    romano = romano+"I";
                break;
            case 4:
                romano = romano+"IV";
            default:
                for(int i = 1; i <=unidad; i++)
                    romano = romano+"I";

        }

        return  romano;
    }

    @GetMapping("/morse/{text}")
    public String morse(@PathVariable String text)
    {
        text = text.toLowerCase(Locale.ROOT);

        String[] arregloPalabras = text.split("   ");

        StringBuffer morse = new StringBuffer();
        for(int i = 0; i < arregloPalabras.length; i++) {
            String[] arregloText = arregloPalabras[i].split(" ");
            for (int x = 0; x < arregloText.length; x++) {
                morse.append( convertir(arregloText[x]));
            }
            morse.append(" ");
        }

        return morse.toString();
    }

    private String convertir(String c)
    {
        String retorno ="";
        switch (c)
        {
            case ".-":  retorno = "A" ;break;
            case "-...": retorno= "B"; break;
            case "-.-.": retorno= "C";break;
            case "-..": retorno = "D";break;
            case ".": retorno = "E";break;
            case "..-.": retorno = "F";break;
            case "--.": retorno = "G";break;
            case "....": retorno = "H";break;
            case "..": retorno = "I";break;
            case ".---": retorno = "J";break;
            case "-.-": retorno = "K";break;
            case ".-..": retorno = "L";break;
            case "--": retorno = "M";break;
            case "-.": retorno = "N";break;
            case "---": retorno = "O";break;
            case ".--.": retorno = "P";break;
            case "--.-": retorno = "Q";break;
            case ".-.": retorno = "R";break;
            case "...": retorno = "S ";break;
            case "-": retorno = "T";break;
            case "..-": retorno = "U";break;
            case "...-": retorno = "V";break;
            case ".--": retorno = "W";break;
            case "-..-": retorno = "X";break;
            case "-.--": retorno = "Y";break;
            case "--..": retorno = "Z";break;

            case "-----": retorno = "0";break;
            case ".----": retorno = "1";break;
            case "..---": retorno = "2";break;
            case "...--": retorno = "3";break;
            case "....-": retorno = "4";break;
            case ".....": retorno = "5";break;
            case "-....": retorno = "6";break;
            case "--...": retorno = "7";break;
            case "---..": retorno = "8";break;
            case "----.": retorno = "9";break;

            case "..--..": retorno = "?";break;
            case "-.-.--": retorno = "!";break;
            case ".-.-.-": retorno = ".";break;
            case "--..--": retorno = ", ";break;

            case " ": retorno = ""; break;
            default: return "";

        }
        return retorno;
    }
}
