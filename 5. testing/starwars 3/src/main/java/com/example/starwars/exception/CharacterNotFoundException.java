package com.example.starwars.exception;

public class CharacterNotFoundException extends RuntimeException{

    public CharacterNotFoundException ( String query ) {
        super("Not found characters with the query: " + query);
    }
}
