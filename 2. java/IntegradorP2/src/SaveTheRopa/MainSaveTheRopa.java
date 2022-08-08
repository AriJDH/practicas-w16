package SaveTheRopa;

import java.util.ArrayList;
import java.util.List;

public class MainSaveTheRopa {
    public static void main(String[] args) {

        GuardaRopa wardrobe = new GuardaRopa();

        ArrayList<Prenda> listaCliente = new ArrayList<>();
        listaCliente.add(new Prenda("Wrangler", "Montana"));
        listaCliente.add(new Prenda("Calvin Klein", "Remera Blanca"));

        Integer codigo = wardrobe.guardarPrendas(listaCliente);
        List<Prenda> listaDevuelta = wardrobe.devolverPrendas(codigo);

        System.out.println(listaDevuelta);

    }
}
