public class Moto extends Vehiculo{


    public Moto(int velocidad,int aceleracion,int anguloDeGiro,String patente) {
        super(patente,velocidad,aceleracion,anguloDeGiro);
        this.peso=300;
        this.ruedas=2;
    }
}
