package JavaP2VIVO;

import java.util.HashMap;
import java.util.Map;

public class CircuitoDeLaSelva {
    //  Circuito selva, arroyos, barro y escalada en piedra.
    //  Circuito chico: 2 km por selva y arroyos.
    //  Circuito medio: 5 km por selva, arroyos y barro.
    //  Circuito Avanzado: 10 km por selva, arroyos, barro y escalada en piedra.

    // dni, nombre, apellido, edad, celular, número de emergencia y grupo sanguíneo

    Map<Integer, Map> circuitoSelva = new HashMap();
    Map<Integer, Map> categoriaMap = new HashMap();
    Map<String, String> participant = new HashMap();

    public void participantesCircuito() {

        newParticipant(1, "123456789", "Andres", "Perez", "16", "3211234499", "3211234499", "O+");
        newParticipant(1, "123456789", "Andrea", "Perez", "21", "3211234499", "3211234499", "O+");

        newParticipant(2, "123456789", "Marian", "Marti", "17", "3211234499", "3211234499", "O-");
        newParticipant(2, "123456789", "Marian", "Marti", "23", "3211234499", "3211234499", "A+");

        newParticipant(3, "123456789", "Jaimes", "Ramir", "20", "3211234499", "3211234499", "B+");
        newParticipant(3, "123456789", "Samiri", "Loaiz", "16", "3211234499", "3211234499", "B-");
        newParticipant(3, "123456789", "Daniel", "Loaiz", "30", "3211234499", "3211234499", "B-");

        String datos;

        for (int i = 1; i <= circuitoSelva.size(); i++) {

            System.out.println("categoria : " + i);
            for (int j = 1; j <= circuitoSelva.get(i).size(); j++) {
                datos = circuitoSelva.get(i).get(j).toString();
                System.out.println("      N° " + j + " " + datos);
            }
        }
    }

    private void newParticipant(int circuito, String dni, String nombre, String apellido, String edad, String celular, String emergenia, String rh) {

        boolean validate = (circuito == 3 && Integer.valueOf(edad) < 18) ? false : true;

        if (validate) {
            participant = new HashMap<>();
            participant.put("dni", dni);
            participant.put("nombre", nombre);
            participant.put("apellido", apellido);
            participant.put("edad", edad);
            participant.put("celular", celular);
            participant.put("emergencia", emergenia);
            participant.put("rh", rh);
            participant.put("inscripcion", String.valueOf(calculateInscription(circuito, Integer.valueOf(edad))));


            categoriaMap = new HashMap<>();
            if (circuitoSelva.get(circuito) != null) {
                categoriaMap = circuitoSelva.get(circuito);
            }
            categoriaMap.put(categoriaMap.size() + 1, participant);
            circuitoSelva.put(circuito, categoriaMap);
        } else {
            System.out.println("Menor de Edad, NO puede participar en CIRCUITO AVANZADO ");
        }
    }

    private void print() {

        for (Map.Entry<String, String> entrada : participant.entrySet()) {
            System.out.println("         |" + entrada.getKey() + " -> " + entrada.getValue());
        }
    }

    private int calculateInscription(int circuito, int edad) {
        int valueInscription = 0;

        switch (circuito) {
            case 1:
                valueInscription = (edad < 18) ? 1300 : 1500;
                break;
            case 2:
                valueInscription = (edad < 18) ? 2000 : 2300;
                break;
            case 3:
                valueInscription = (edad < 18) ? 0 : 2800;
                break;
        }
        //System.out.println("valor es : " + valueInscription);
        return valueInscription;
    }

    public static void main(String[] args) {

        new CircuitoDeLaSelva().participantesCircuito();
    }
}
