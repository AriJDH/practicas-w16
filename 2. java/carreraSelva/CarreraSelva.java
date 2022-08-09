package carreraSelva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarreraSelva {

    public int participantNumber = 0;
    private Map<Integer, List<Map<String, String>>> circuitos = new HashMap<>();
    private Map<Integer, String> namesMap = new HashMap<>();

    CarreraSelva() {
        List<Map<String, String>> circuitoChico = new ArrayList<>();
        List<Map<String, String>> circuitoMedio = new ArrayList<>();
        List<Map<String, String>> circuitoAvanzado = new ArrayList<>();
        this.namesMap.put(1, "Circuito chico");
        this.namesMap.put(2, "Circuito medio");
        this.namesMap.put(3, "Circuito avanzado");
        this.circuitos.put(1, circuitoChico);
        this.circuitos.put(2, circuitoMedio);
        this.circuitos.put(3, circuitoAvanzado);

    }

    private void addParticipantToCircuit(int option, Map<String, String> participant) {
        this.circuitos.get(option).add(participant);
    }

    public void addParticipant() {
        Map<String, String> persona = new HashMap<>();
        System.out.println("Elija un circuito");
        int option = this.optionSelector();
        Map<String, String> participant = this.createParticipant();
    }

    private Map<String, String> createParticipant() {
        Map<String, String> persona = new HashMap<>();
        persona.put("dni", ScannerUtils.getStringFromScanner("DNI:"));
        persona.put("nombre", ScannerUtils.getStringFromScanner("Nombre:"));
        persona.put("edad", ScannerUtils.getStringFromScanner("Edad:"));
        persona.put("celular", ScannerUtils.getStringFromScanner("Celular:"));
        persona.put("numeroEmergencia", ScannerUtils.getStringFromScanner("Numero de emergencia:"));
        persona.put("grupoSanguineo", ScannerUtils.getStringFromScanner("Grupo sanguineo:"));
        return persona;
    }

    private int optionSelector() {
        int option = ScannerUtils.getIntFromScanner("1) Circuito chico \n 2) Circuito medio \n 3) Circuito avanzado");
        if (option != 1 || option != 2 || option != 3) {
            System.out.println("Elija una opcion valida");
            return this.optionSelector();
        }
        return option;
    }

    public void verParticipantes() {
        this.circuitos.entrySet().stream().forEach(circuito -> {
            System.out.println(this.namesMap.get(circuito.getKey()));
            circuito.getValue()
                    .stream()
                    .forEach(stringStringMap -> {
                        stringStringMap
                                .entrySet()
                                .stream()
                                .forEach(s -> System.out.println(s.getKey() + " " + s.getValue()));
                    });

        });
    }
}