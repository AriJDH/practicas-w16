package carreraSelva;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static int participantNumber = 0;
    public static List<Map<String, String>>  circuitoChico = new ArrayList<>();
    public static List<Map<String, String>>  circuitoMedio = new ArrayList<>();
    public static List<Map<String, String>>  circuitoAvanzado = new ArrayList<>();

    public static void main(String[] args) {
        CarreraSelva carreraSelva = new CarreraSelva();
        carreraSelva.addParticipant();
        carreraSelva.addParticipant();
        carreraSelva.verParticipantes();
    }

}
