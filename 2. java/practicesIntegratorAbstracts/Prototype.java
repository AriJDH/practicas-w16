package practicesIntegratorAbstracts;


import java.util.ArrayList;
import java.util.List;

public abstract class Prototype<Integer> {

    Integer num;
    List<Integer> listNumbers = new ArrayList<>();

    public Prototype() {
    }

    public Prototype(List<Integer> listNumbers, Integer num) {
        this.listNumbers = listNumbers;
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public List<Integer> getListNumbers() {
        return listNumbers;
    }

    public void setListNumbers(List<Integer> listNumbers) {
        this.listNumbers = listNumbers;
    }

    // El primero de los métodos es el encargado de devolver un número que corresponderá al valor siguiente a la serie progresiva
    public abstract List<Integer> countNetxNumber();

    // Otro método para reiniciar la serie
    public abstract void resetListNumbers();

    // un último que recibirá un valor que servirá para establecer el valor inicial de la serie
    public abstract void createWithInitialBase(Integer number);
}
