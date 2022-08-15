package com.bootcamp.morse.repository;

import com.bootcamp.morse.dto.MorseDto;
import com.bootcamp.morse.model.Morse;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MorseRepository implements IMorseRepository{

    List<Morse> morses = new ArrayList<>();

    @PostConstruct
    public void loadData(){
        morses.add(new Morse(".-", "A"));
        morses.add(new Morse("-...   ", "B"));
        morses.add(new Morse("-.-.", "C"));
        morses.add(new Morse("-..", "D"));
        morses.add(new Morse(".", "E"));
        morses.add(new Morse("..-.", "F"));
        morses.add(new Morse("--.", "G"));
        morses.add(new Morse("....", "H"));
        morses.add(new Morse("..", "I"));
        morses.add(new Morse(".---", "J"));
        morses.add(new Morse("-.-", "K"));
        morses.add(new Morse(".-..", "L"));
        morses.add(new Morse("--", "M"));
        morses.add(new Morse("-.", "N"));
        morses.add(new Morse("---", "O"));
        morses.add(new Morse(".--.", "P"));
        morses.add(new Morse("--.-", "Q"));
        morses.add(new Morse(".-.", "R"));
        morses.add(new Morse("...", "S"));
        morses.add(new Morse("-", "T"));
        morses.add(new Morse("..-", "U"));
        morses.add(new Morse("..-", "V"));
        morses.add(new Morse(".--", "W"));
        morses.add(new Morse("-..-", "X"));
        morses.add(new Morse("-.--", "Y"));
        morses.add(new Morse("--..", "Z"));
        morses.add(new Morse(".----", "1"));
        morses.add(new Morse("..---", "2"));
        morses.add(new Morse("...--", "3"));
        morses.add(new Morse("....-", "4"));
        morses.add(new Morse("......", "5"));
        morses.add(new Morse("-....", "6"));
        morses.add(new Morse("--....", "7"));
        morses.add(new Morse("---..", "8"));
        morses.add(new Morse("----.", "9"));
        morses.add(new Morse("-----", "0"));
    }


    @Override
    public MorseDto contrucMorse(String message) {
        StringBuilder lettersMorse = new StringBuilder();
        List<String[]> words = new ArrayList<>();
        String[] wordsSpanish = message.split("   ");

        for (int i = 0; i < wordsSpanish.length; i++){
            String[] letters = wordsSpanish[i].split(" ");
            words.add(letters);
        }
        /*
        for (String[] letras : letrasPorPalabra) {
            for (String letra : letras) {
                if (morseToEspanol.containsKey(letra)) {
                    palabraEspanol.append(morseToEspanol.get(letra));
                } else {
                    palabraEspanol.append("No existe la letra: " + morseToEspanol.get(letra) );
                }
                //palabraEspanol.append(" ");
            }
        }
        */




        return null;
    }
}
