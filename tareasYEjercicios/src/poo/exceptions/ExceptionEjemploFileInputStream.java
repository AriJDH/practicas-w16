package poo.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionEjemploFileInputStream {

    public static void main(String[] args) {

        try {
            FileInputStream fileInputStream = new FileInputStream("prueba.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

}

