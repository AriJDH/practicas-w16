package integrador.p2_prenda.interfaces;

import integrador.p2_prenda.model.Prenda;

import java.util.List;

public interface IRepositorio {

    Integer guardarPrendas(List<Prenda> prendas);
    List<Prenda> devolverPrenda(Integer id);
    void mostrarPrendas();
}
