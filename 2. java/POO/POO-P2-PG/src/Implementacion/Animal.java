package Implementacion;

public class Animal {

    private String especie; //no queremos que otras clases directa a esta info

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Animal(String especie) {
        this.especie = especie;
    }

    public void mostrarEspecie() {
        System.out.println("Soy un animal de la especie " + this.especie);//referencia a esta clase
    }

    public void hacerSonidos() {
        System.out.println("Soy un animal y hago sonidos ");//referencia a esta clase
    }
}
