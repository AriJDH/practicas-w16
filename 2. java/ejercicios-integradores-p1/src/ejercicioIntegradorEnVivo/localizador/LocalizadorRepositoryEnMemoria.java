package ejercicioIntegradorEnVivo.localizador;

import ejercicioIntegradorEnVivo.cliente.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LocalizadorRepositoryEnMemoria implements LocalizadorRepository {

    private List<Localizador> localizadores;

    public LocalizadorRepositoryEnMemoria() {
        this.localizadores = new ArrayList<>();
    }

    @Override
    public void guardar(Localizador localizador) {
        System.out.println("Log - Localizador guardado: " + localizador.toString());
        localizadores.add(localizador);
    }

    @Override
    public List<Localizador> localizadoresDe(Cliente unCliente) {
        return localizadores.stream().filter(localizador -> localizador.getCliente().equals(unCliente)).collect(Collectors.toList());
    }
}
