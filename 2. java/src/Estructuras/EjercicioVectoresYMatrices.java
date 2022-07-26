package Estructuras;

import java.util.Scanner;

public class EjercicioVectoresYMatrices {
    public static void main(String[]args){
        String ciudades [] = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","São Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int temperaturas[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
        Scanner sc =  new Scanner(System.in);
        int opCiudad =0,opMaxMin =0, opIterador = 1;

        do{
            System.out.println("*************** Bienvenido a la consulta de temperaturas ***************");
            System.out.println("Seleccione una opcion numeria para consultar la temperatura de la ciudad");
            System.out.println("1.- Londres");
            System.out.println("2.- Madrid");
            System.out.println("3.- Nueva York");
            System.out.println("4.- Buenos Aires");
            System.out.println("5.- Asunción");
            System.out.println("6.- São Paulo");
            System.out.println("7.- Lima");
            System.out.println("8.- Santiago de Chile");
            System.out.println("9.- Lisboa");
            System.out.println("10.- Tokio");
            System.out.println("************************************************************************");
            opCiudad = sc.nextInt();

            System.out.println("************************************************************************");
            System.out.println("Seleccione una opcion numeria la temperatura mayor o menor");
            System.out.println("1.- Menor");
            System.out.println("2.- Mayor");
            System.out.println("************************************************************************");
            opMaxMin = sc.nextInt();


            if(opCiudad>10 || opCiudad<1){
                System.out.println("Opcion invalida");
            }else{
                if(opMaxMin==1 || opMaxMin == 2){
                    System.out.println("Ciudad: "+ciudades[opCiudad-1]+" Temperatura: "+temperaturas[opCiudad-1][opMaxMin-1]);
                }else{
                    System.out.println("Error ingreso mal la opcion!");
                }
            }
            System.out.println("************************************************************************");
            System.out.println("Desea Consultar otra ciudad?");
            System.out.println("1.- Si");
            System.out.println("2.- No, salir");
            System.out.println("************************************************************************");
            opIterador = sc.nextInt();

        } while (opIterador==1);




    }
}
