package ejercicio_turismo;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    List<Localizador> localizadorList = new ArrayList<>();



    public List<Localizador> getLocalizadorList() {
        return localizadorList;
    }

    public void setLocalizadorList(List<Localizador> localizadorList) {
        this.localizadorList = localizadorList;
    }

    public boolean checkCliente(Cliente cli){

        int contador = (int) localizadorList.stream().filter(localizador -> localizador.getCliente().getDni().equals(cli.getDni())).count();
        return contador > 2;

    }


}
