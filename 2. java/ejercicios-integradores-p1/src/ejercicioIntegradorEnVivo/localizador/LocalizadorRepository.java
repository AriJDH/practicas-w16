package ejercicioIntegradorEnVivo.localizador;

import ejercicioIntegradorEnVivo.cliente.Cliente;

import java.util.List;

public interface LocalizadorRepository {
    void guardar(Localizador localizador);

    List<Localizador> localizadoresDe(Cliente unCliente);
}
