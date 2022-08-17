package EjercicioDos;

public class Perishable extends Product {
    private int daysToExpire;

    public Perishable(String name, double price, int daysToExpire) {
        super(name, price);
        this.daysToExpire = daysToExpire;
    }

    @Override
    public double calcular(int quantityProducts) {
        if (daysToExpire == 1) {
            return (quantityProducts * getPrice()) / 4;
        } else if (daysToExpire == 2) {
            return (quantityProducts * getPrice()) / 3;
        } else if (daysToExpire == 3) {
            return (quantityProducts * getPrice()) / 2;
        } else {
            return quantityProducts * getPrice();
        }
    }

    public String toString() {
        return "nombre='" + getName() + '\'' +
                ", precio=" + getPrice() +
                ", dias para expirar=" + daysToExpire;
    }


}
