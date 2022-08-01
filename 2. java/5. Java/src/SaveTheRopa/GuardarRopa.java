package SaveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardarRopa {

    private Integer Contador;
    private Map<Integer, List<Prenda>> LstPrenda;

    public GuardarRopa() {
        Contador= 0;
        LstPrenda = new HashMap<>();
    }

    public Integer getContador() {
        return Contador;
    }

    public void setContador(Integer contador) {
        Contador = contador;
    }

    public Map<Integer, List<Prenda>> getLstPrenda() {
        return LstPrenda;
    }

    public void setLstPrenda(Map<Integer, List<Prenda>> lstPrenda) {
        LstPrenda = lstPrenda;
    }

    public Integer guardarPrenda(List<Prenda> lista)
    {
        this.Contador++;
        this.LstPrenda.put(this.getContador(), lista);
        return  this.getContador();
    }

    public void mostrarPrenda()
    {
        this.getLstPrenda().forEach((Integer, Prenda) -> System.out.println("Identificador : "+Integer));
        this.getLstPrenda().forEach((Integer, Prenda) -> Prenda.forEach(System.out::println));
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> lista =  this.getLstPrenda().get(numero);
        try{
            if(lista == null)
                throw new Exception("No se encontro la preda");

            this.LstPrenda.remove(numero, lista);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return lista;

    }

    @Override
    public String toString() {
        return "GuardarRopa{" +
                "Contador=" + Contador +
                ", LstPrenda=" + LstPrenda +
                '}';
    }
}
