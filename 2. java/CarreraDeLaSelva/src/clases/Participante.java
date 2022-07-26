package clases;

import java.util.Scanner;

public class Participante {
    public String dni;
    public String nombre;
    public String apellido;
    public int edad;
    public String celular;
    public String numeroEmergencia;
    public String grupoSanguíneo;
    public int nroParticipante;

    public Participante(){
        Scanner teclado1 = new Scanner(System.in);
        Scanner teclado2 = new Scanner(System.in);

        System.out.println("------------------------------------------------------");
        System.out.println("Cargue los datos del participante");
        System.out.println("------------------------------------------------------");
        System.out.println("Nombre:");
        this.nombre = teclado1.nextLine();
        System.out.println("Apellido:");
        this.apellido = teclado1.nextLine();
        System.out.println("DNI:");
        this.dni = teclado1.nextLine();
        System.out.println("Edad:");
        this.edad = teclado2.nextInt();
        System.out.println("Celular:");
        this.celular = teclado1.nextLine();
        System.out.println("Nro emergencia:");
        this.numeroEmergencia = teclado1.nextLine();
        System.out.println("Grupo sanguineo:");
        this.grupoSanguíneo = teclado1.nextLine();
    }
}
