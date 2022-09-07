package ejerciciosIntegradoresP1PG.ejercicioIntegradorParte1;

import java.util.List;

public interface Crud<T>  {
     List<T> listar();
     void crear(T t);
     boolean encontrarPorDni(int dni);
     void eliminarPorDni(int dni);


}
