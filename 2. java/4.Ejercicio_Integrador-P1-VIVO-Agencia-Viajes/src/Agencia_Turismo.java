import java.util.List;
import java.util.stream.Collectors;

public class Agencia_Turismo {
    public List<Localizador> localizadores;

    public Agencia_Turismo(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

}
