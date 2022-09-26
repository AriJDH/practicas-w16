import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
  private HashMap<Integer, List<Prenda>> prendas = new HashMap();
  private int contador;

  public GuardaRopa() {
  }

  public GuardaRopa(HashMap prendas) {
    this.prendas = prendas;
    this.contador = 1;
  }

  public HashMap getPrendas() {
    return prendas;
  }

  public void setPrendas(HashMap prendas) {
    this.prendas = prendas;
  }

  public int getContador() {
    return contador;
  }

  public void setContador(int contador) {
    this.contador = contador;
  }

  public int guardarPrendas(List<Prenda> panios) {
    prendas.put(this.contador++, panios);
    return this.contador;
  }

  public void mostrarPrendas() {
    for (Integer key : this.prendas.keySet()) {
      System.out.println("Identificador: " + key + "\n"
          + "Lista de prendas: " + this.prendas.get(key).toString());
    }
  }

  public List<Prenda> devolverPrendas(int identificador) {
    return this.prendas.get(identificador);
  }
}

