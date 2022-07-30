package Ejercicios5;

public class Meteorito implements Distanciable{

    private int x;
    private int y;

    public Meteorito(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double coordenadaADistancia() {
        var result = Math.sqrt(Math.pow((x*1 - x*2),2) + Math.pow((y*1 - y*2),2)); //sqtr es para sacar la raiz cuadrada
        return result;
    }

}
