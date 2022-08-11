package integrador.agencia_turismo.repositorios;

import integrador.agencia_turismo.models.Localizador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LocalizadorRepo {
    public static LocalizadorRepo instance;
    private List<Localizador> localizadores;

    private LocalizadorRepo() {
        this.localizadores = new ArrayList<>();
    }

    public static LocalizadorRepo getInstance(){
        if(instance == null) instance = new LocalizadorRepo();
        return instance;
    }

    public void agregarLocalizador(Localizador localizador){
        localizadores.add(localizador);
    }

    public List<Localizador> getLocalizadoresByCliente(String dni){
        return localizadores.stream().filter(localizador -> localizador.getCliente().getDni().equals(dni)).collect(Collectors.toList());
    }

    public List<Localizador> getAll(){
        return localizadores;
    }
}
