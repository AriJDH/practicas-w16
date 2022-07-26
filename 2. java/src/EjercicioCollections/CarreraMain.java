package EjercicioCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarreraMain {
    public static void main(String[]args){
        List<Participante> participantesCircuitoChico = new ArrayList<>();
        List<Participante> participantesCircuitoMediano = new ArrayList<>();
        List<Participante> participantesCircuitoGrande = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int opIterador = 0, opCarrera = 0,numeroCompetidor=0, opCircuito = 0,opDesinscribir, tamanio=0 ;
        String dniDes = "";
        do{
            System.out.println("*************** Bienvenido a la Carrera de la selva ***************");
            System.out.println("Seleccione una opcion numeria");
            System.out.println("1.- Inscribir participante");
            System.out.println("2.- Consulta de participantes");
            System.out.println("3.- Desinscribir Participante");
            System.out.println("*******************************************************************");
            opCarrera = sc.nextInt();

            switch (opCarrera){
                case 1:
                    Participante participante = new Participante();

                    System.out.println("Ingrese su DNI");
                    String dni = sc.next();

                    System.out.println("Ingrese su Nombre");
                    String nombre = sc.next();

                    System.out.println("Ingrese su Apellido");
                    String apellido = sc.next();

                    System.out.println("Ingrese su edad");
                    Integer edad = sc.nextInt();

                    System.out.println("Ingrese su celular");
                    String celular = sc.next();

                    System.out.println("Ingrese su Numero De emergencia");
                    String numeroEmergencia = sc.next();

                    System.out.println("Ingrese su Grupo Sanguineo");
                    String grupoSanguineo = sc.next();

                    participante.setNombre(nombre);
                    participante.setDni(dni);
                    participante.setApellido(apellido);
                    participante.setCelular(celular);
                    participante.setEdad(edad);
                    participante.setGrupoSanguineo(grupoSanguineo);
                    participante.setNumeroEmergencia(numeroEmergencia);
                    participante.setNumeroCorredor(numeroCompetidor+1);


                    System.out.println("Seleccione el circuito a inscribir");
                    System.out.println("1.- Ciruito Chico");
                    System.out.println("2.- Ciruito Medio");
                    System.out.println("3.- Circuito Grande");

                    opCircuito = sc.nextInt();
                    switch (opCircuito) {
                        case 1:
                            participantesCircuitoChico.add(participante);
                            if(participante.getEdad()<18){
                                System.out.println("Monto a abonar $1300");
                            }else{
                                System.out.println("Monto a abonar $1500");

                            }

                            break;
                        case 2:
                            participantesCircuitoMediano.add(participante);
                            if(participante.getEdad()<18){
                                System.out.println("Monto a abonar $2000");
                            }else{
                                System.out.println("Monto a abonar $2300");

                            }
                            break;
                        case 3:

                            if(participante.getEdad()<18){
                                System.out.println("Solo se admiten mayores de edad!!");
                            }else{
                                participantesCircuitoGrande.add(participante);
                                System.out.println("Monto a abonar $2800");
                            }
                            break;
                    }
                break;
                case 2:

                    System.out.println("Seleccione el circuito a consultar");
                    System.out.println("1.- Ciruito Chico");
                    System.out.println("2.- Ciruito Medio");
                    System.out.println("3.- Circuito Grande");

                    opCircuito = sc.nextInt();
                    switch (opCircuito) {
                        case 1:
                            if(participantesCircuitoChico.size()>0) {
                                participantesCircuitoChico.stream().forEach(p -> {
                                    System.out.println("Nombre: "+p.getNombre());
                                    System.out.println("Apellido: "+p.getApellido());
                                    System.out.println("NumeroCorredor: "+p.getNumeroCorredor());

                                });
                            }else{
                                System.out.println("Circuito sin participantes");
                            }


                            break;
                        case 2:
                            if(participantesCircuitoMediano.size()>0) {
                                participantesCircuitoMediano.stream().forEach(p -> {
                                    System.out.println("Nombre: "+p.getNombre());
                                    System.out.println("Apellido: "+p.getApellido());
                                    System.out.println("NumeroCorredor: "+p.getNumeroCorredor());

                                });

                            }else{
                                System.out.println("Circuito sin participantes");
                            }
                            break;
                        case 3:
                            if(participantesCircuitoGrande.size()>0) {
                                participantesCircuitoGrande.stream().forEach(p -> {
                                    System.out.println("Nombre: "+p.getNombre());
                                    System.out.println("Apellido: "+p.getApellido());
                                    System.out.println("NumeroCorredor: "+p.getNumeroCorredor());

                                });
                            }else{
                                System.out.println("Circuito sin participantes");
                            }
                            break;
                    }
                break;
                case 3:
                    System.out.println("Seleccione el circuito del participante a desinscribir");
                    System.out.println("1.- Ciruito Chico");
                    System.out.println("2.- Ciruito Medio");
                    System.out.println("3.- Circuito Grande");

                    opCircuito = sc.nextInt();
                    switch (opCircuito) {
                        case 1:
                            System.out.println("Ingrese DNI a desinscribir");
                            dniDes = sc.next();

                            for(Participante part : participantesCircuitoChico){
                                if(part.getDni().equals(dniDes)){
                                    System.out.println("Participante :" +part.getNombre()+ " Eliminado");
                                    participantesCircuitoChico.remove(part);

                                    break;
                                }
                            }

                            break;
                        case 2:
                            System.out.println("Ingrese DNI a desinscribir");
                            dniDes = sc.next();

                            for(Participante part : participantesCircuitoMediano){
                                if(part.getDni().equals(dniDes)){
                                    System.out.println("Participante :" +part.getNombre()+ " Eliminado");
                                    participantesCircuitoMediano.remove(part);

                                    break;
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Ingrese DNI a desinscribir");
                            dniDes = sc.next();

                            for(Participante part : participantesCircuitoGrande){
                                if(part.getDni().equals(dniDes)){
                                    System.out.println("Participante :" +part.getNombre()+ " Eliminado");
                                    participantesCircuitoGrande.remove(part);

                                    break;
                                }
                            }
                            break;
                    }
                break;
            }


            System.out.println("*********************************");
            System.out.println("Desea Hacer otra operacion?");
            System.out.println("1.- Si");
            System.out.println("2.- No, salir");
            System.out.println("*********************************");
            opIterador = sc.nextInt();
        } while (opIterador==1);


    }
}
