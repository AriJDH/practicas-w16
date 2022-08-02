package ejercicio3;

public abstract class Animal {

    private String sonido;
    private String especie;

    public Animal(String sonido, String especie) {
        this.sonido = sonido;
        this.especie=especie;
    }

    public Animal() {
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public abstract void emitirSonido();

//    public abstract void comerAnimal(Animal animal);


    public Comer comerAnimal(String especie){
        if(especie.equals("carnivoro")){
            return new ComerCarnivoro();
        }
        else{
            return new ComerHerviboro();
        }
    }
}
