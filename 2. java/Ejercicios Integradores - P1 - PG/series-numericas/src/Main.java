public class Main {
    public static void main(String[] args) {
        ClaseA claseA = new ClaseA();
        ClaseB claseB = new ClaseB();

        System.out.println("SERIE 2");
        System.out.println(claseA.valorSiguiente());
        System.out.println(claseA.valorSiguiente());
        System.out.println(claseA.valorSiguiente());
        System.out.println(claseA.valorSiguiente());
        claseA.reiniciarSerie();

        System.out.println("SERIE 2 con valor inicial 1");
        claseA.establecerValorIniciar(1);
        System.out.println(claseA.valorSiguiente());
        System.out.println(claseA.valorSiguiente());
        System.out.println(claseA.valorSiguiente());
        System.out.println(claseA.valorSiguiente());

        System.out.println("SERIE 3");
        System.out.println(claseB.valorSiguiente());
        System.out.println(claseB.valorSiguiente());
        System.out.println(claseB.valorSiguiente());
        System.out.println(claseB.valorSiguiente());

    }
}
