package Interfaces2;

import Interfaces2.models.Informe;
import Interfaces2.models.Libro;
import Interfaces2.models.Persona;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[]args){

        LinkedList <String> skills = new LinkedList<String>();

        skills.add("Java");
        skills.add("JavaScript");
        skills.add("Python");
        skills.add("Junit5");
        skills.add("Html");
        skills.add("AngularJs");
        skills.add("Angular2");
        skills.add("React");
        skills.add("Docker");

        Scanner sc = new Scanner(System.in);

        Informe informe = new Informe("Rodrigo", "Basthian", 56, "Este es un nuevo texto de ejemplo para probar el informe");
        Libro libro = new Libro("La rueda del tiempo",14532, "Brandon Sanderson", "Magia y aventura");
        Persona personaCv = new Persona("Rodrigo",26,"Ingeneria Civil en Informatica","Cifuentes",skills);

        System.out.println("Ingrese que documento desea imprimir");
        System.out.println("1.-Imprimir informe");
        System.out.println("2.-Imprimir Libro");
        System.out.println("3.-Imprimir CV");
        int op = sc.nextInt();


        switch(op){
            case 1:

                informe.imprimirDocumento(informe.toString());
                break;

            case 2:
                libro.imprimirDocumento(libro.toString());
                break;

            case 3:
                personaCv.imprimirDocumento(personaCv.toString());

                break;
        }
    }
 }
