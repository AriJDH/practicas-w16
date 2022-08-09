package AgenciaTurismo;

import java.util.List;

public class Cliente {
    List<ILocalizador> localizadores;

    public List<ILocalizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<ILocalizador> localizadores) {
        this.localizadores = localizadores;
    }

    public Cliente(List<ILocalizador> localizadores) {
        this.localizadores = localizadores;
    }
}
