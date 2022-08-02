/*
    Autor: Tannia Lucía Hernández
    Series numéricas
*/

public class Main {

    public static void main(String[] args){

        SerieDos serieDos = new SerieDos(0);
        SerieTres serieTres = new SerieTres(0);

        System.out.println("----------------------------------------");
        System.out.println("Primera vez "+ serieDos.devolverNumero());
        System.out.println("Segunda vez "+ serieDos.devolverNumero());
        System.out.println("Tercera vez "+ serieDos.devolverNumero());
        serieDos.reiniciarSerie();
        System.out.println("Se reinicia la serie");
        System.out.println("Cuarta vez "+ serieDos.devolverNumero());
        System.out.println("Quinta vez "+ serieDos.devolverNumero());


        serieDos.establecerInicio(1.0);

        System.out.println("----------------------------------------");
        System.out.println("Se establece 1 como valor inicial");
        System.out.println("Primera vez "+ serieDos.devolverNumero());
        System.out.println("Segunda vez "+ serieDos.devolverNumero());
        System.out.println("Tercera vez "+ serieDos.devolverNumero());
        System.out.println("Cuarta vez "+ serieDos.devolverNumero());

        System.out.println("----------------------------------------");
        System.out.println("Primera vez "+ serieTres.devolverNumero());
        System.out.println("Segunda vez "+ serieTres.devolverNumero());
        System.out.println("Tercera vez "+ serieTres.devolverNumero());
        System.out.println("Cuarta vez "+ serieTres.devolverNumero());
    }
}
