package EjercicioDos;

public class Nonperishable extends Product {
    private String type;

    public Nonperishable(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    public String toString() {
        return "nombre='" + getName() + '\'' +
                ", precio=" + getPrice() +
                ", tipo='" + type + '\'';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
