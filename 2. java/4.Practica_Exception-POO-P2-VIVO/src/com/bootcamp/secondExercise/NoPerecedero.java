package com.bootcamp.secondExercise;

public class NoPerecedero extends Product{
    private String type;

    public NoPerecedero(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    public NoPerecedero(String type) {
        this.type = type;
    }

    public NoPerecedero() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double calculate(int countProduts) {
        return countProduts * getPrice();
    }

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "type='" + type + '\'' +
                '}';
    }
}
