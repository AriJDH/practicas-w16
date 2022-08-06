package ejerciciosIntegradoresP1PG.ejercicioIntegradorParte1;

import java.util.List;

public interface Crud<T>  {
     List<T> listar();
     void encontrarPorDni(int dni);
     void eliminarPorDni(int dni);
}
