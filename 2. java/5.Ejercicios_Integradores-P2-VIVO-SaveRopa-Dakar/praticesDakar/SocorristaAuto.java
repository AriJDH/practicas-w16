package praticesDakar;

public class SocorristaAuto extends Auto implements ISocorrista<Auto>{

    public SocorristaAuto() {
    }

    public SocorristaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }


    @Override
    public void socorrer(Auto object) {
        System.out.println("Socorriendo auto: " + object.getPatente());
    }
}
