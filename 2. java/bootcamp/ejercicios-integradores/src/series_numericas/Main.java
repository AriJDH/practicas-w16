package series_numericas;

public class Main {

    public static void main(String[] args) {

        System.out.println("--Serie de 2--");
        SerieDe2 serieDe2 = new SerieDe2();
        serieDe2.establecerValorInicial(2);
        serieDe2.siguienteDeLaSerie();
        serieDe2.siguienteDeLaSerie();
        serieDe2.siguienteDeLaSerie();
        serieDe2.reiniciarSerie();
        serieDe2.siguienteDeLaSerie();

        System.out.println("");
        System.out.println("--Serie de 3---");
        SerieDe3 serieDe3 = new SerieDe3();
        serieDe3.establecerValorInicial(1);
        serieDe3.siguienteDeLaSerie();
        serieDe3.siguienteDeLaSerie();
        serieDe3.siguienteDeLaSerie();
        serieDe3.reiniciarSerie();
        serieDe3.siguienteDeLaSerie();


    }
}
