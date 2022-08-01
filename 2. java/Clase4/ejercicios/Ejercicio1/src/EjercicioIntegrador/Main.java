package EjercicioIntegrador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner teclado=new Scanner(System.in);
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);

        List<Clientes> clienList=new ArrayList<>();
        clienList.add(new Clientes("emanuel","rivero",478135));
        clienList.add(new Clientes("emanuel","rivero",4710432));
        clienList.add(new Clientes("emanuel","rivero",478445));
        for(Clientes p:clienList){
            System.out.println("Nombre: "+ p.getNombre());
            System.out.println("Apellido: "+ p.getApellido());
            System.out.println("Dni: "+ p.getDni());
        }
        int m=0;
        System.out.println("ingrese 1 para borrar o 2 para buscar x dni o 0 para seguir");
        int elijo=teclado.nextInt();
        System.out.println("ingrese el dni, cual es el unico elemento unico");
        int dniDate=teclado.nextInt();
        if(elijo==1) {
            for (Clientes p : clienList) {

                if (dniDate == p.getDni()) {
                    clienList.remove(p);

                    m++;
                    break;
                }
                if (m <= 0) {
                    System.out.println("no se encontro el dni");
                }
            }
        }
        elijo=0;
        System.out.println("ingrese 2 para buscar por el dni anterior o ingrese 3 para mirar la lista completa");
        elijo=teclado.nextInt();
        System.out.println(elijo);
        m=0;
            if(elijo==2){
                for (Clientes p : clienList) {

                    if (dniDate == p.getDni()) {
                        System.out.println("Nombre: "+ p.getNombre());
                        System.out.println("Apellido: "+ p.getApellido());
                        System.out.println("Dni: "+ p.getDni());
                        m++;
                        break;
                    }
                    if (m <= 0) {
                        System.out.println("no se encontro el dni");
                    }
                }
            }
        if (elijo==3){
            for(Clientes j:clienList){
                System.out.println("Nombre: "+ j.getNombre());
                System.out.println("Apellido: "+ j.getApellido());
                System.out.println("Dni: "+ j.getDni());
            }
        }
        }

    }

