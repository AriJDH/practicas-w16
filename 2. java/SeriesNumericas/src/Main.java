import Classes.SerieDeDos;
import Classes.SerieDeTres;
import Classes.SerieDeUno;

public class Main {
    public static void main(String[] args) {

        //Se crea e imprime una serie numérica de dos
        int cantidadDeRepeticiones = 4;
        SerieDeDos serieDeDos = new SerieDeDos(0, 0, 0);
        serieDeDos.setearValorInicial();

        System.out.println("****** Serie de Dos ******");

        for (int i = 0; i < cantidadDeRepeticiones; i++){
            System.out.println(serieDeDos.addValor());
        }

        System.out.println(serieDeDos.resetearSerie(0));

        for (int i = 0; i < cantidadDeRepeticiones; i++){
            System.out.println(serieDeDos.addValor());
        }

        //Se crea e imprime una serie numérica de uno
        SerieDeUno serieDeUno = new SerieDeUno(0, 0, 0);
        serieDeUno.setearValorInicial();

        System.out.println();
        System.out.println("****** Serie de Uno ******");

        for (int i = 0; i < cantidadDeRepeticiones; i++){
            System.out.println(serieDeUno.addValor());
        }

        System.out.println(serieDeUno.resetearSerie(1));

        for (int i = 0; i < cantidadDeRepeticiones; i++){
            System.out.println(serieDeUno.addValor());
        }

        //Se crea e imprime una serie numérica de tres
        SerieDeTres serieDeTres = new SerieDeTres(0, 0, 0);
        serieDeTres.setearValorInicial();

        System.out.println();
        System.out.println("****** Serie de Tres ******");

        for (int i = 0; i < cantidadDeRepeticiones; i++){
            System.out.println(serieDeTres.addValor());
        }

        System.out.println(serieDeTres.resetearSerie(0));

        for (int i = 0; i < cantidadDeRepeticiones; i++){
            System.out.println(serieDeTres.addValor());
        }
    }
}
