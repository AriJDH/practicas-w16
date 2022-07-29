package ejercicioClasesAbstractas;

public class Main {
    public static void main(String[] args) {
        Prototipo<Integer> test = new SeriedeDos<Integer>(0,0);

        int primero = test.obtenerValorSiguiente();
        int segundo = test.obtenerValorSiguiente();
        int tercero = test.obtenerValorSiguiente();


        System.out.println(primero);
        System.out.println(segundo);
        System.out.println(tercero);

        test.reiniciarSerie();
        int primero1 = test.obtenerValorSiguiente();
        int segundo1= test.obtenerValorSiguiente();
        int tercero1 = test.obtenerValorSiguiente();


        System.out.println(primero1);
        System.out.println(segundo1);
        System.out.println(tercero1);

        test.setValorInicial(4);
        int primero2 = test.obtenerValorSiguiente();
        int segundo2= test.obtenerValorSiguiente();
        int tercero2 = test.obtenerValorSiguiente();


        System.out.println(primero2);
        System.out.println(segundo2);
        System.out.println(tercero2);

        Prototipo<Float> test2 = new SeriedeDos<Float>(0f,0f);

        float primero3 = test2.obtenerValorSiguiente();
        float segundo3 = test2.obtenerValorSiguiente();
        float tercero3 = test2.obtenerValorSiguiente();


        System.out.println(primero3);
        System.out.println(segundo3);
        System.out.println(tercero3);

        Prototipo<Float> test3 = new SerieDeTres<Float>(0f,0f);

        float primero4 = test3.obtenerValorSiguiente();
        float segundo4 = test3.obtenerValorSiguiente();
        float tercero4 = test3.obtenerValorSiguiente();


        System.out.println(primero4);
        System.out.println(segundo4);
        System.out.println(tercero4);
    }
}
