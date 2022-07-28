package EjemploAnimal;

public class Animal {

    private String especie;

    public Animal(String especie){
        this.especie = especie;
    }

    public String getEspecie(String especie){
        return especie;
    }

    public void setEspecie(String especie){
        this.especie = especie;
    }

    public void mostrarEspecie(){
        System.out.println("Especie: " + this.especie);
    }

    public void hacerSonido(){
        System.out.println("El animal hace sonido");
    }
}
