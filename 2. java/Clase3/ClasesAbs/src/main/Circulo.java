package main;

public class Circulo extends FigurasGeometricas implements Graficable,Rotable{
    private float radio;

    public Circulo() {}

    public Circulo(int posX, int posY, float radio) {
        super(posX, posY);
        this.radio = radio;
    }
    public double calcularArea(){
        return Math.PI*(Math.pow(radio,2));
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    @Override
    public void graficable() {
        System.out.println("graficando al circulo");
    }

    @Override
    public void rotable() {
        System.out.println("rotando el ciruclo");
    }
}
