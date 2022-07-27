package estructurasDinamicas;

import java.util.HashMap;
import java.util.Map;

public class Ejemplo4 {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("pedro","juan perez");
        map.put("jorge","juan lus");
        map.put("luis","juan luis");
        map.put("kaka","juan perez");
        map.put("pepe","Emanuel rivero");
        String pedro=map.get("pepe");

        for (Map.Entry pareja:map.entrySet()){
            System.out.println(pareja);
        }

    }
}
