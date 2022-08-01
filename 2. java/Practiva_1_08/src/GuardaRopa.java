import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> listaPrendas =new HashMap<>();
    private  int contadorPrendas=0;

    public Integer guardarPrendas(List<Prenda> listaPrenda){
        contadorPrendas++;
        this.listaPrendas.put(contadorPrendas,listaPrenda);
        return contadorPrendas;
    }

    public void mostrarPrendas(){

        for(int i=1;i<=contadorPrendas;i++)
        {
            System.out.println("Prenda para el id"+i);
            this.listaPrendas.get(i).forEach(System.out::println);
        }
    }


    public List<Prenda> devolverPrendas(Integer numero){
        return listaPrendas.get(numero);
    }

}
