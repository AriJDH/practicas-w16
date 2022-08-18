package Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wardrobe {

    private Map<Integer, List<Garment>> wardrobes = new HashMap<>();
    private Integer count = 0;

    public Integer guardarPrendas(List<Garment> listaDePrenda) {
        wardrobes.put(++count, listaDePrenda);
        System.out.println("---------------------------------------");
        System.out.println("Su localizador de prendas es: " + count);
        System.out.println("---------------------------------------");
        return count;
    }

    public void mostrarPrendas() {
        System.out.println("\n\n\n\n\n\n");
        wardrobes.forEach((x,y) -> {
            System.out.println("---------------------------------------");
            System.out.println("Prendas guardadas en el localizador N°: " + x);
            for (Garment garment: y) {
                System.out.println(" - Marca: " + garment.getBrand() + " / Modelo: " + garment.getModel() );
            }
        });
    }

    public List<Garment> devolverPrendas(Integer numero) {
        return wardrobes.get(numero);
    }
}
