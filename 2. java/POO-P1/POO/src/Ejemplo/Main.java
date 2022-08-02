package Ejemplo;

public class Main {

    public static void main(String[] args) {

        Libro lb = new Libro("Titulo","Autor",3);

    }

}


public class Automovil {
    String marca;
    String color;
    double kilometros;

    public Automovil() {}

    public Automovil(marca, color, kilometros) {
        this.marca = marca;
        this.color = color;
        this.kilometros = kilometros;
    }

    public String mostrarMarcaYColor() {
        String marcaYColor = "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
        return marcaYColor;

    }
}