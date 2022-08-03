package com.tomas.supermercado;

import java.util.List;
import java.util.Optional;

public interface ICrud <T>{

    void guardar (T objeto);
    void mostrarDatos();
    Optional<T> buscar(int id);
    List<T> listarDatoCompleto();
    void eliminar(int id);


}
