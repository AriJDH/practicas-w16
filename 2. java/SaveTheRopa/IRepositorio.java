package SaveTheRopa;

import java.util.List;

public interface IRepositorio {
    public Integer guardar(List<Prenda> prenda);
    public List<Prenda> devolverPrenda(Integer id);
    public void mostrarPrendas();
}
