package p2pg;

public class Animal {

    private String especie;

    public String getEspecie() {
        return this.especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Animal(String especie) { this.especie = especie; }

    public void mostrarEspecie() { System.out.println("Soy un animal de la especie: " + this.especie); }

    public void hacerSonido() { System.out.println("El animal hace un sonido"); }
}
