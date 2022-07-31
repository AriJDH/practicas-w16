import java.util.*;

public class Ejemplo3 {
    public static void main(String[] args) {
        Set<String> hs = new HashSet<>();
        hs.add("Pablo");
        hs.add("Juan");
        hs.add("Pedro");
        hs.add("María");

        System.out.println(hs);
        System.out.println("Me los imprime pero no en el orden add");
        hs.add("Pablo");
        System.out.println("No admite repetidos, no se puede usar un sort");

        //si quiero ordenarlos tengo que hacer un casteo, pasarlo a ArrayList por ejemplo

        List<String> orderhs = new ArrayList<>(hs);
        Collections.sort(orderhs);
        System.out.println(orderhs);
        hs.add("Camila");
        //System.out.println(hs);
    }
}
