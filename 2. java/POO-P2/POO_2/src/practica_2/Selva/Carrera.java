package practica_2.Selva;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Carrera {

    List<Participante> participantesCarreraChico;
    List<Participante> participantesCarreraMedio;
    List<Participante> participantesCarreraAvanzada;

    public Carrera() {
        this.participantesCarreraChico = new ArrayList<>();
        this.participantesCarreraMedio = new ArrayList<>();
        this.participantesCarreraAvanzada = new ArrayList<>();
    }

    public void calcularValorPago(Participante participante, TiposCircuitos tipoCircuito){

        double pago = 0;
        int edadParticipante = participante.getEdad();

        switch (tipoCircuito){
            case CHICO:{
                if(edadParticipante < 18)
                    pago =1300;
                else
                    pago =1500;

                participante.dineroAbono = pago;
                participante.tiposCircuitos = TiposCircuitos.CHICO;
                participantesCarreraChico.add(participante);
                break;
            }
            case MEDIO:{
                if(edadParticipante < 18)
                    pago =2000;
                else
                    pago =2300;

                participante.dineroAbono = pago;
                participante.tiposCircuitos = TiposCircuitos.MEDIO;
                participantesCarreraMedio.add(participante);
                break;
            }
            case AVANZADO:{
                if(edadParticipante > 18){
                    pago = 2800;
                    participante.tiposCircuitos = TiposCircuitos.AVANZADO;
                }else{
                    pago = 0;
                    participante.tiposCircuitos = TiposCircuitos.EDAD_NO_PERMITIDA;
                }
                participante.dineroAbono = pago;
                participantesCarreraAvanzada.add(participante);
                break;
            }
            default:{
            }
        }
    }

    public void inscribirParticipante(Scanner teclado, int tipoCircuito){

        String dni,nombre,apellido,celular,numeroEmergencia,grupoSanguineo;
        int edad;

        System.out.print("Digita el numero del DNI :");
        dni = teclado.nextLine();
        while (dni.length() == 0){
            dni = teclado.nextLine();
        }

        System.out.print("Digita el nombre :");
        nombre = teclado.nextLine();

        System.out.print("Digita el apellido :");
        apellido = teclado.nextLine();

        System.out.print("Digita la edad :");
        edad = Integer.parseInt(teclado.nextLine());

        System.out.print("Digita el numero del celular :");
        celular = teclado.nextLine();

        System.out.print("Digita el numero de emergencia :");
        numeroEmergencia = teclado.nextLine();

        System.out.print("Digita el grupo sanguineo :");
        grupoSanguineo = teclado.nextLine();


        Participante participante = new Participante(dni,nombre,apellido,edad,celular,numeroEmergencia,grupoSanguineo);

        switch (tipoCircuito){
            case 1 : {
                calcularValorPago(participante,TiposCircuitos.CHICO);
                break;
            }
            case 2 : {
                calcularValorPago(participante,TiposCircuitos.MEDIO);
                break;
            }
            case 3 : {
                calcularValorPago(participante,TiposCircuitos.AVANZADO);
                break;
            }
        }
    }
    public void mostrarParticipantes(){

        int numeroParticipantesCircuitoChico = participantesCarreraChico.size();
        int numeroParticipantesCircuitoMedio = participantesCarreraMedio.size();
        int numeroParticipantesCircuitoAvanzado = participantesCarreraAvanzada.size();

        System.out.println("==================================");
        System.out.println("====      CIRCUITO CHICO      ====");
        System.out.println("==================================");
        System.out.println("Cantidad participantes : " + numeroParticipantesCircuitoChico);

        if (numeroParticipantesCircuitoChico > 0){
            for(Participante participante : participantesCarreraChico){
                System.out.println( participante.toString());
            }
        }

        System.out.println("==================================");
        System.out.println("====      CIRCUITO MEDIO      ====");
        System.out.println("==================================");
        System.out.println("Cantidad participantes : " + numeroParticipantesCircuitoMedio);

        if (numeroParticipantesCircuitoMedio > 0){
            for(Participante participante : participantesCarreraMedio){
                System.out.println( participante.toString());
            }
        }

        System.out.println("==================================");
        System.out.println("====    CIRCUITO AVANZADO     ====");
        System.out.println("==================================");
        System.out.println("Cantidad participantes : " + numeroParticipantesCircuitoAvanzado);

        if (numeroParticipantesCircuitoAvanzado > 0){
            for(Participante participante : participantesCarreraAvanzada){
                System.out.println( participante.toString());
            }
        }


    }

    public void desinscribirParticipante(int tipoCircuito,int id){
        int index = 0;
        Participante resultado = null;

        switch (tipoCircuito){
            case 1 : {
                for(Participante part : participantesCarreraChico){
                   if(part.getId() == id)
                       break;
                    ++index;
                }
                resultado = this.participantesCarreraChico.remove(index);
                break;
            }
            case 2 : {
                for(Participante part : participantesCarreraMedio){
                    if(part.getId() == id)
                        break;
                    ++index;
                }
                resultado = this.participantesCarreraMedio.remove(index);
                break;
            }
            case 3 : {
                for(Participante part : participantesCarreraAvanzada){
                    if(part.getId() == id)
                        break;
                    ++index;
                }
                resultado = this.participantesCarreraAvanzada.remove(index);
                break;
            }
        }

        if(resultado != null){
            System.out.println("Proceso completado exitosamente");
        }
        else{
            System.out.println("No se pudo desinscribir");
        }
    }

    public int cantidadParticipante(){
        int numeroParticipantesCircuitoChico = participantesCarreraChico.size();
        int numeroParticipantesCircuitoMedio = participantesCarreraMedio.size();
        int numeroParticipantesCircuitoAvanzado = participantesCarreraAvanzada.size();

        return numeroParticipantesCircuitoChico +numeroParticipantesCircuitoMedio+numeroParticipantesCircuitoAvanzado;
    }


}
