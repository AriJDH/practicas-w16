package AgenciaTurismo;

public class Product implements  IProduct {
    private String name;
    @Override
    public String getName() {
        return name;
    }
@Override
    public void setName(String name) {
        this.name = name;
    }

    public Product(String name) {
        this.name = name;
    }
}
