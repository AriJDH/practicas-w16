package AgenciaTurismo;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorRepository {
    private List<Localizador> localizadores;

    public LocalizadorRepository() {
        this.localizadores = new ArrayList<>();
    }

    public void addLocalizador(Localizador l){
        this.localizadores.add(l);
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public boolean verificacionDescuento(Cliente c){
        int co = 0;
        int i = 0;
        do{
            if(localizadores.size() > 0 && localizadores.get(i).getCliente().getNombre().equals(c.getNombre()))
                co++;
            i++;
        } while (i < localizadores.size() && co < 3);

        return co == 2;
    }
}
