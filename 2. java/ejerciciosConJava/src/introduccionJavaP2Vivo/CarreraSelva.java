package introduccionJavaP2Vivo;

import java.util.*;

public class CarreraSelva {

    public static void main(String[] args) {
        Map<String,String> participante = new HashMap<>();
        Map<Integer,Map> circuitoChico = new HashMap<>();
        Map<Integer,Map> circuitomedio = new HashMap<>();
        Map<Integer,Map> circuitoAvanzado = new HashMap<>();
        Integer numeroParticipante =0;

        System.out.println("Ingrese la opcion que quiere realizar: "+'\n'+
                "1 para inscribir a un nuevo participante en una categoría"+'\n'+
                "2 para mostrar a los integrantes de una categoría"+'\n'+
                "3 para desinscibir a un participante de una categoría"+'\n'+
                "4 para determinar el monto de cada participante al inscribirse");
        Scanner escaner = new Scanner(System.in);
        int opcion = escaner.nextInt();
        System.out.println(opcion);

        switch (opcion){
            case 1:
                System.out.println("Ingrese los datos del participante");
                System.out.print("dni");
                String dni= escaner.nextLine();
                System.out.print("Nombre");
                String nombre = escaner.nextLine();
                System.out.print("Apellido");
                String apellido = escaner.nextLine();
                System.out.print("Edad");
                String edad = escaner.nextLine();
                System.out.print("Celular");
                String celular = escaner.nextLine();
                System.out.print("Numero de emergencia");
                String numeroEmergencia = escaner.nextLine();
                System.out.print("Grupo sanguineo");
                String grupoSanguineo = escaner.nextLine();
                    
                participante.put("dni",dni);
                participante.put("nombre",nombre);
                participante.put("apellido",apellido);
                participante.put("edad",edad);
                participante.put("celular",celular);
                participante.put("numeroEmergencia",numeroEmergencia);
                participante.put("grupoSanguineo",grupoSanguineo);


                System.out.println("Ingrese la categoría del circuito a la que quiera inscribirse:"+'\n'
                +"1 para circuito chico"+ '\n'+"2 para circuito medio"+'\n'+"3 para circuito avanzado");
                int tipoCircuito = escaner.nextInt();
                if(tipoCircuito==1){
                    numeroParticipante +=1;
                    circuitoChico.put(numeroParticipante,participante);
                } else if (tipoCircuito == 2) {
                    
                }

        }

    }

}
