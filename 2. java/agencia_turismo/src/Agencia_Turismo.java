import java.util.List;
import java.util.stream.Collectors;

public class Agencia_Turismo {

    private List<Localizadores> localozadores;

    public Agencia_Turismo() {

    }


    public List getLocalizadoresClientes(Cliente cliente){

       return localozadores.stream().filter(x->x.getComprador().equals(cliente)).collect(Collectors.toList());

    }
}
