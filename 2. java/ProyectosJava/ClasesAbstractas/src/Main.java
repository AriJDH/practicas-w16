public class Main {
    public static void main(String[] args) {

        Clase1 serie3 = new Clase1();
        Clase2 serie2 = new Clase2();

        System.out.println("\n\nSERIE 3");

        System.out.println(serie3.devolverNum());
        System.out.println(serie3.devolverNum());
        serie3.valorInicial(55.0f);
        System.out.println(serie3.devolverNum());
        System.out.println(serie3.devolverNum());
        serie3.reiniciarSerie();
        System.out.println(serie3.devolverNum());
        System.out.println(serie3.devolverNum());

        System.out.println("\n\nSERIE 2");

        System.out.println(serie2.devolverNum());
        System.out.println(serie2.devolverNum());
        serie3.valorInicial(55.0f);
        System.out.println(serie2.devolverNum());
        System.out.println(serie2.devolverNum());
        serie3.reiniciarSerie();
        System.out.println(serie2.devolverNum());
        System.out.println(serie2.devolverNum());


    }
}
