package JavaPOOP1PG;

public class Automovil {

    String marca;
    String color;
    double kilometros;

    public Automovil() {
    }

    public Automovil(String marca, String color, double kilometros) {
        this.marca = marca;
        this.color = color;
        this.kilometros = kilometros;
    }

    public String mostrarMarcaYColor() {
        String marcaYColor = "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
        return marcaYColor;
    }

    public static void main(String[] args) {
        new Automovil().mostrarMarcaYColor();
    }
}
