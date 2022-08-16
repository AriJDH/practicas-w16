package bootcamp.series;

public class Main {
    public static void main(String[] args) {

        System.out.println("Serie de dos");
        SerieDos serieDos = new SerieDos();
        serieDos.establecerSerie(2);
        serieDos.valorSiguiente();
        serieDos.valorSiguiente();
        serieDos.valorSiguiente();
        serieDos.valorSiguiente();
        serieDos.reiniciarSerie();
        serieDos.valorSiguiente();

        SerieTres serieTres = new SerieTres();
        serieTres.establecerSerie(3);
        serieTres.valorSiguiente();
        serieTres.valorSiguiente();
        serieTres.valorSiguiente();
        serieTres.valorSiguiente();
        serieTres.reiniciarSerie();
        serieTres.valorSiguiente();
    }
}
