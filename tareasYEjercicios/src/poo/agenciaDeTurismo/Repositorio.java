package poo.agenciaDeTurismo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Repositorio {

    List<Localizador> localizadorList;

    public Repositorio() {
        this.localizadorList = new ArrayList<>();
    }

    public List<Localizador> getLocalizadorList() {
        return localizadorList;
    }

    public void setLocalizadorList(List<Localizador> localizadorList) {
        this.localizadorList = localizadorList;
    }

    public void agregarLocalizador(Localizador loc) {
        this.localizadorList.add(loc);
    }

    public List<Cliente> getClientesConRepetidos() {
        return localizadorList.stream().map(x -> x.getCliente()).collect(Collectors.toList());
    }

    public List<Localizador> getLocalizadoresPorDniCliente(String dni) {
        return localizadorList.stream().filter(x -> x.getCliente().getDni().equals(dni)).collect(Collectors.toList());
    }

    public int getCantidadLocalizadoresPorDni(String dni) {
        return getLocalizadoresPorDniCliente(dni).size();
    }

    @Override
    public String toString() {
        return "\nRepositorio "
                + localizadorList;
    }
}
