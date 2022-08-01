public class Auto extends Vehiculo{

    public Auto(int velocidad,int aceleracion,int anguloDeGiro,String patente) {
        super(patente,velocidad,aceleracion,anguloDeGiro);
        this.peso=1000;
        this.ruedas=300;
    }


}
