package com.grodriguez.codigoMorse;

import java.util.HashMap;
import java.util.Map;

public class DecodeService {

    private Map<String, String> morseDicc = new HashMap<>();

    public DecodeService(){
        morseDicc.put(".-", "A" );
        morseDicc.put("-...", "B");
        morseDicc.put("-.-.", "C");
        morseDicc.put("-..", "D");
        morseDicc.put(".", "E");
        morseDicc.put("..-.", "F");
        morseDicc.put("--.", "G");
        morseDicc.put("....", "H");
        morseDicc.put("..", "I");
        morseDicc.put(".---", "J");
        morseDicc.put("-.-", "K");
        morseDicc.put(".-..", "L");
        morseDicc.put("--", "M");
        morseDicc.put("-.", "N");
        morseDicc.put("---", "O");
        morseDicc.put(".--.", "P");
        morseDicc.put("--.-", "Q");
        morseDicc.put(".-.", "R");
        morseDicc.put("...", "S");
        morseDicc.put("-", "T");
        morseDicc.put("..-", "U");
        morseDicc.put("...-", "V");
        morseDicc.put(".--", "W");
        morseDicc.put("-..-", "X");
        morseDicc.put("-.--", "Y");
        morseDicc.put("--..", "Z");

        //Numeros
        morseDicc.put("-----", "0");
        morseDicc.put(".----", "1");
        morseDicc.put("..---", "2");
        morseDicc.put("...--", "3");
        morseDicc.put("....-", "4");
        morseDicc.put(".....", "5");
        morseDicc.put("-....", "6");
        morseDicc.put("--...", "7");
        morseDicc.put("---..", "8");
        morseDicc.put("----.", "9");

        //Signos
        morseDicc.put("..--..", "?");
        morseDicc.put("-.-.--", "!");
        morseDicc.put(".-.-.-", ".");
        morseDicc.put("--..--", ",");
    }

    public String getDecodedLetter(String letter){
        return this.morseDicc.get(letter);
    }
}
