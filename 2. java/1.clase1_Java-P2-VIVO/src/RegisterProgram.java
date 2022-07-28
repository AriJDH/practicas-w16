import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterProgram {

    public static void main(String[] args) {

        List<Participante> circuitoChico = new ArrayList<Participante>();
        List<Participante> circuitoMedio = new ArrayList<Participante>();
        List<Participante> circuitoAvanzado = new ArrayList<Participante>();

        int optionSelected;

        String optionName;
        String optionLastName;
        int optionDNI;
        int optionAge;
        String optionCellphone;
        String optionEmergencyNumber;
        String optionBloodType;

        int id = 1;

        Scanner input = new Scanner(System.in);
        Scanner inputId = new Scanner(System.in);
        Scanner inputName = new Scanner(System.in);
        Scanner inputLastName = new Scanner(System.in);
        Scanner inputDNI = new Scanner(System.in);
        Scanner inputAge = new Scanner(System.in);
        Scanner inputCellphone = new Scanner(System.in);
        Scanner inputEmergencyNumber = new Scanner(System.in);
        Scanner inputBloodType = new Scanner(System.in);

        boolean leave = false;

        while(!leave){
            System.out.println("---------- BIENVENIDO A LA CARRERA DE LA SELVA ----------");

            System.out.println("---- Presione el numero de la opcion que desea: ");

            System.out.println("---- ----1. Inscripcion de participante.");
            System.out.println("---- ----2. Ver los inscritos por categoria.");
            System.out.println("---- ----3. Desinscribir a un participante.");
            System.out.println("---- ----4. Salir.\n");

            optionSelected = input.nextInt();

            switch (optionSelected) {
                case 1:

                    System.out.println("---- Escoja la opcion que desea: ");
                    System.out.println("---- 1. Circuito Chico.");
                    System.out.println("---- 2. Circuito Medio.");
                    System.out.println("---- 3. Circuito Avanzado.");

                    optionSelected = input.nextInt();
                    switch (optionSelected) {
                        case 1:
                            //Circuito Chico
                            System.out.println("--Ingrese el Nombre del participante: ");
                            optionName = inputName.next();

                            System.out.println("--Ingrese el Apellido del participante: ");
                            optionLastName = inputLastName.next();

                            System.out.println("--Ingrese el DNI del participante: ");
                            optionDNI = inputDNI.nextInt();

                            System.out.println("--Ingrese la Edad del participante: ");
                            optionAge = inputAge.nextInt();

                            System.out.println("--Ingrese un Numero de telefono del participante: ");
                            optionCellphone = inputCellphone.next();

                            System.out.println("--Ingrese un Numero de emergencia del participante: ");
                            optionEmergencyNumber = inputEmergencyNumber.next();

                            System.out.println("--Ingrese el Tipo de Sangre del participante: ");
                            optionBloodType = inputBloodType.next();

                            Participante participanteChico = new Participante(id, optionName, optionLastName, optionDNI, optionAge, optionCellphone, optionEmergencyNumber, optionBloodType);

                            circuitoChico.add(participanteChico);
                            id++;

                            if(optionAge < 18){
                                System.out.println("--El costo de inscripcion es de $ 1.300 COP");
                            } else {
                                System.out.println("--El costo de inscripcion es de $ 1.500 COP");
                            }

                            break;
                        case 2:
                            //Circuito Medio
                            System.out.println("--Ingrese el Nombre del participante: ");
                            optionName = inputName.next();

                            System.out.println("--Ingrese el Apellido del participante: ");
                            optionLastName = inputLastName.next();

                            System.out.println("--Ingrese el DNI del participante: ");
                            optionDNI = inputDNI.nextInt();

                            System.out.println("--Ingrese la Edad del participante: ");
                            optionAge = inputAge.nextInt();

                            System.out.println("--Ingrese un Numero de telefono del participante: ");
                            optionCellphone = inputCellphone.next();

                            System.out.println("--Ingrese un Numero de emergencia del participante: ");
                            optionEmergencyNumber = inputEmergencyNumber.next();

                            System.out.println("--Ingrese el Tipo de Sangre del participante: ");
                            optionBloodType = inputBloodType.next();

                            Participante participanteMedio = new Participante(id, optionName, optionLastName, optionDNI, optionAge, optionCellphone, optionEmergencyNumber, optionBloodType);

                            circuitoMedio.add(participanteMedio);
                            id++;

                            if(optionAge < 18){
                                System.out.println("--El costo de inscripcion es de $ 2.000 COP");
                            } else {
                                System.out.println("--El costo de inscripcion es de $ 2.300 COP");
                            }

                            break;
                        case 3:
                            //Circuito Avanzado;
                            System.out.println("--Ingrese el Nombre del participante: ");
                            optionName = inputName.next();

                            System.out.println("--Ingrese el Apellido del participante: ");
                            optionLastName = inputLastName.next();

                            System.out.println("--Ingrese el DNI del participante: ");
                            optionDNI = inputDNI.nextInt();

                            System.out.println("--Ingrese la Edad del participante: ");
                            optionAge = inputAge.nextInt();

                            System.out.println("--Ingrese un Numero de telefono del participante: ");
                            optionCellphone = inputCellphone.next();

                            System.out.println("--Ingrese un Numero de emergencia del participante: ");
                            optionEmergencyNumber = inputEmergencyNumber.next();

                            System.out.println("--Ingrese el Tipo de Sangre del participante: ");
                            optionBloodType = inputBloodType.next();

                            Participante participanteAvanzado = new Participante(id, optionName, optionLastName, optionDNI, optionAge, optionCellphone, optionEmergencyNumber, optionBloodType);

                            circuitoAvanzado.add(participanteAvanzado);
                            id++;

                            if(optionAge < 18){
                                System.out.println("--No se permiten inscripciones a menores de 18 años");
                            } else {
                                System.out.println("--El costo de inscripcion es de $ 2.800 COP");
                            }

                            break;
                        default:
                            System.out.println("---------La opcion es incorrecta!!");
                            break;
                    }
                    break;
                case 2:
                    //un foreach para imprimir las listas
                    System.out.println("---- Escoja la opcion que desea: ");
                    System.out.println("---- 1. Circuito Chico.");
                    System.out.println("---- 2. Circuito Medio.");
                    System.out.println("---- 3. Circuito Avanzado.");

                    optionSelected = input.nextInt();
                    switch (optionSelected) {
                        case 1:
                            //Circuito Chico
                            for (Participante participanteChico : circuitoChico) {
                                System.out.println(participanteChico.showDataParticipante());
                            }
                            break;
                        case 2:
                            //Circuito Medio
                            for (Participante participanteMedio : circuitoMedio) {
                                System.out.println(participanteMedio.showDataParticipante());
                            }
                            break;
                        case 3:
                            //Circuito Avanzado
                            for (Participante participanteAvanzado : circuitoAvanzado) {
                                System.out.println(participanteAvanzado.showDataParticipante());
                            }
                            break;
                        default:
                            System.out.println("---------La opcion es incorrecta!!");
                            break;
                    }
                    break;
                case 3:
                    //remover de la lista mediante el numero de la fila;
                    System.out.println("---- Escoja la opcion que desea: ");
                    System.out.println("---- 1. Circuito Chico.");
                    System.out.println("---- 2. Circuito Medio.");
                    System.out.println("---- 3. Circuito Avanzado.");

                    optionSelected = input.nextInt();

                    switch (optionSelected) {
                        case 1:
                            //Circuito Chico
                            System.out.println("--Ingrese el numero de inscripcion del participante que desea remover de la lista: ");
                            id = inputId.nextInt();
                            circuitoChico.remove(id);
                            System.out.println("--Participante removido");
                            break;
                        case 2:
                            //Circuito Medio
                            System.out.println("--Ingrese el numero de inscripcion del participante que desea remover de la lista: ");
                            id = inputId.nextInt();
                            circuitoMedio.remove(id);
                            System.out.println("--Participante removido");
                            break;
                        case 3:
                            //Circuito Avanzado
                            System.out.println("--Ingrese el numero de inscripcion del participante que desea remover de la lista: ");
                            id = inputId.nextInt();
                            circuitoAvanzado.remove(id);
                            System.out.println("--Participante removido");
                            break;
                        default:
                            System.out.println("---------La opcion es incorrecta!!");
                            break;
                    }
                    break;
                case 4:
                    //salir del menu
                    leave = true;
                    break;
                default: System.out.println("---------La opcion es incorrecta!!");
                    break;
            }

            //input.close();
            //inputName.close();
            ///inputLastName.close();
            //inputDNI.close();
            //inputAge.close();
            //inputCellphone.close();
            ///inputEmergencyNumber.close();
            //inputBloodType.close();
        }
    }
}
