package Package1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Participante marcela = new Participante("marcela", "utria", 12345, 25, 313757036, 311803434, "O+", 1 );

        List<Participante> circuitoChico = new ArrayList<>();
        List<Participante> circuitoMedio = new ArrayList<>();
        List<Participante> circuitoAvanzado = new ArrayList<>();

        //Preguntamos opciones
        Scanner teclado = new Scanner(System.in);
        Scanner teclado2 = new Scanner(System.in);
        Scanner teclado3 = new Scanner(System.in);
        Scanner teclado4 = new Scanner(System.in);
        Scanner teclado5 = new Scanner(System.in);
        Scanner teclado6 = new Scanner(System.in);
        Scanner teclado7 = new Scanner(System.in);
        Scanner teclado8 = new Scanner(System.in);

        int opcion = 0;
        int consecutivo = 0;
        int categoria = 0;
        int abonar = 0;
        int listaCategoria = 0;
        int desuscribirCategoria = 0;
        double participanteDesuscribir = 0;
        double participanteAbono = 0;

        do {
            System.out.println("------- Carrera de la selva --------");
            System.out.println("Selecciona una opción:");
            System.out.println("(1) Inscribir nuevo participante");
            System.out.println("(2) Ver lista de participantes por categoría");
            System.out.println("(3) Desinscribir participante");
            System.out.println("(4) Determinar monto a abonar");
            opcion = teclado.nextInt();

            switch (opcion){
                case 1:
                    Participante nuevoParticipante = new Participante();
                    System.out.print("ingresa el nombre del participante: ");
                    String nombre = teclado.next();
                    System.out.print("ingresa el apellido del participante: ");
                    String apellido = teclado.next();
                    System.out.print("ingresa la edad del participante: ");
                    int edad = teclado.nextInt();
                    System.out.print("ingresa el dni del participante: ");
                    double dni = teclado.nextDouble();
                    System.out.print("ingresa el numero celular del participante: ");
                    double celular = teclado.nextDouble();
                    System.out.print("ingresa el numero de emergencia del participante: ");
                    double numeroEmergencia = teclado.nextDouble();
                    System.out.print("ingresa el grupo sanguineo del participante: ");
                    String grupoSanguineo = teclado.next();

                    System.out.println("Selecciona la categoría del participante: ");
                    System.out.println("(1) Circuito Chico: ");
                    System.out.println("(2) Circuito Medio: ");
                    System.out.println("(3) Circuito Avanzado: ");

                    categoria = teclado2.nextInt();

                    nuevoParticipante.setNombre(nombre);
                    nuevoParticipante.setApellido(apellido);
                    nuevoParticipante.setEdad(edad);
                    nuevoParticipante.setDni(dni);
                    nuevoParticipante.setCelular(celular);
                    nuevoParticipante.setNumeroEmergencia(numeroEmergencia);
                    nuevoParticipante.setGrupoSanguineo(grupoSanguineo);
                    nuevoParticipante.setNumeroConsecutivo(consecutivo + 1);

                    switch (categoria){
                        case 1:
                            circuitoChico.add(nuevoParticipante);
                            if (nuevoParticipante.getEdad() < 18) {
                                nuevoParticipante.setAbono(1300);
                                System.out.println("El participante " + nuevoParticipante.getNombre() + " abona $1300;");
                            } else {
                                nuevoParticipante.setAbono(1500);
                                System.out.println("El participante " + nuevoParticipante.getNombre() + " abona $1500;");
                            }
                            break;

                        case 2:
                            circuitoMedio.add(nuevoParticipante);
                            if (nuevoParticipante.getEdad() < 18) {
                                nuevoParticipante.setAbono(2000);
                                System.out.println("El participante " + nuevoParticipante.getNombre() + " abona $2000;");
                            } else {
                                nuevoParticipante.setAbono(2300);
                                System.out.println("El participante " + nuevoParticipante.getNombre() + " abona $2300;");
                            }
                            break;

                        case 3:
                            circuitoAvanzado.add(nuevoParticipante);
                            if (nuevoParticipante.getEdad() < 18) {
                                System.out.println("El participante " + nuevoParticipante.getNombre() + " no puede inscribirse.");
                            } else {
                                nuevoParticipante.setAbono(2800);
                                System.out.println("El participante " + nuevoParticipante.getNombre() + " abona $2800;");
                            }
                            break;
                    }
                    break;

                // ver listas
                case 2:
                    System.out.println("Selecciona la categoria que quieres ver: ");
                    System.out.println("(1) Circuito Chico: ");
                    System.out.println("(2) Circuito Medio: ");
                    System.out.println("(3) Circuito Avanzado: ");

                    listaCategoria = teclado3.nextInt();

                    switch (listaCategoria){
                        case 1:
                            System.out.println("Participantes del Circuito Chico: ");
                            for (int i = 0; i < circuitoChico.size(); i++){
                                System.out.println((i+1)+". "+circuitoChico.get(i).getNombre() + " " + circuitoChico.get(i).getApellido());
                            }
                    }
                    break;

                //Eliminar participante de una lista
                case 3:
                    System.out.println("Selecciona la categoria del participante que quieres desuscribir: ");
                    System.out.println("(1) Circuito Chico: ");
                    System.out.println("(2) Circuito Medio: ");
                    System.out.println("(3) Circuito Avanzado: ");
                    desuscribirCategoria = teclado5.nextInt();

                    switch (desuscribirCategoria){
                        case 1:
                            System.out.print("Digita el dni del participante: ");
                            participanteDesuscribir = teclado6.nextInt();

                            for(int i=0; i<circuitoChico.size(); i++){
                                if (circuitoChico.get(i).getDni() == participanteDesuscribir){
                                    circuitoChico.remove(i);
                                    System.out.println("el participante con dni: " + participanteDesuscribir + " fue eliminado.");
                                } else {
                                    System.out.println("el participante con dni: " + participanteDesuscribir + " no existe.");
                                }
                            }

                        case 2:
                            System.out.print("Digita el dni del participante: ");
                            participanteDesuscribir = teclado6.nextInt();

                            for(int i=0; i<circuitoMedio.size(); i++){
                                if (circuitoMedio.get(i).getDni() == participanteDesuscribir){
                                    circuitoMedio.remove(i);
                                    System.out.println("el participante con dni: " + participanteDesuscribir + " fue eliminado.");
                                } else {
                                    System.out.println("el participante con dni: " + participanteDesuscribir + " no existe.");
                                }
                            }

                        case 3:
                            System.out.print("Digita el dni del participante: ");
                            participanteDesuscribir = teclado6.nextInt();

                            for(int i=0; i<circuitoAvanzado.size(); i++){
                                if (circuitoAvanzado.get(i).getDni() == participanteDesuscribir){
                                    circuitoAvanzado.remove(i);
                                    System.out.println("el participante con dni: " + participanteDesuscribir + " fue eliminado.");
                                } else {
                                    System.out.println("el participante con dni: " + participanteDesuscribir + " no existe.");
                                }
                            }
                    }

                case 4:
                    System.out.println("Selecciona la categoria del participante que debe abonar: ");
                    System.out.println("(1) Circuito Chico: ");
                    System.out.println("(2) Circuito Medio: ");
                    System.out.println("(3) Circuito Avanzado: ");
                    abonar = teclado7.nextInt();

                    switch (abonar){
                        case 1:
                            System.out.print("Digita el dni del participante: ");
                            participanteAbono = teclado8.nextDouble();

                            for(int i=0; i<circuitoChico.size(); i++){
                                if (circuitoChico.get(i).getDni() == participanteAbono){
                                    System.out.println("el participante con dni: " + participanteAbono + " debe abonar " + circuitoChico.get(i).getAbono() + ".");
                                } else {
                                    System.out.println("el participante con dni: " + participanteAbono + " no existe.");
                                }
                            }
                        case 2:
                            System.out.print("Digita el dni del participante: ");
                            participanteAbono = teclado8.nextDouble();

                            for(int i=0; i<circuitoMedio.size(); i++){
                                if (circuitoMedio.get(i).getDni() == participanteAbono){
                                    System.out.println("el participante con dni: " + participanteAbono + " debe abonar " + circuitoChico.get(i).getAbono() + ".");
                                } else {
                                    System.out.println("el participante con dni: " + participanteAbono + " no existe.");
                                }
                            }

                        case 3:
                            System.out.print("Digita el dni del participante: ");
                            participanteAbono = teclado8.nextDouble();

                            for(int i=0; i<circuitoAvanzado.size(); i++){
                                if (circuitoAvanzado.get(i).getDni() == participanteAbono){
                                    System.out.println("el participante con dni: " + participanteAbono + " debe abonar " + circuitoChico.get(i).getAbono() + ".");
                                } else {
                                    System.out.println("el participante con dni: " + participanteAbono + " no existe.");
                                }
                            }

                    }


            }

            System.out.println("¿Quiere hacer algo más?");
            System.out.println("(1) Si");
            System.out.println("(2) No");
            opcion = teclado4.nextInt();
        } while(opcion == 1);


    }
}
