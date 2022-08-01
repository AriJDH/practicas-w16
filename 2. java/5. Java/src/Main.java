import SaveTheRopa.GuardarRopa;
import SaveTheRopa.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Prenda> LstRopa = new ArrayList<>();

        LstRopa.add( new Prenda("Polera", "X"));
        LstRopa.add( new Prenda("Poleron", "X"));
        GuardarRopa guardarRopa = new GuardarRopa();
        guardarRopa.guardarPrenda(LstRopa);

        guardarRopa.mostrarPrenda();
    }
}
