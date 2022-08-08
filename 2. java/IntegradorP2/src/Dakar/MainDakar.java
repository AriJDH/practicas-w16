package Dakar;

public class MainDakar {
    public static void main(String[] args) {
        Carrera grandPrix = new Carrera(3367.0,66.0E6,"Grand Prix", 26);

        grandPrix.darDeAltaAuto(360.0,100/2.4,180.0, "UML334");
        grandPrix.darDeAltaAuto(340.0,120/2.4,178.0, "UML458");
        grandPrix.darDeAltaAuto(330.0,100/2.0,182.0, "UML777");

        grandPrix.definirGanador();

    }
}
