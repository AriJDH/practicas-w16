package Ei_clasesAbtractas;

public class Main {
    public static void main(String[] args) {
        /*
        Se desea crear al menos 2 clases que extiendan de una clase prototipo, que genera un valor en función, a una serie progresiva. La clase prototipo contendrá tres métodos. El primero de los métodos es el encargado de devolver un número que corresponderá al valor siguiente a la serie progresiva. Otro método para reiniciar la serie, y un último que recibirá un valor que servirá para establecer el valor inicial de la serie. Las clases deben estar preparadas para recibir cualquier tipo de dato numérico no primitivo.
Escenarios:
Si se crea una serie de 2 cada vez que se llame el método valor siguiente devolverá:
Primera vez 2
Segunda vez 4
Tercera vez 6
Cuarta vez 8
                                 Así sucesivamente cada vez que se llama al método
         */

        Prototipo<Integer> clase1 = new Clase1();
        System.out.println(clase1.valorInicial(3));
        System.out.println(clase1.valorSiguiente());
        System.out.println(clase1.valorSiguiente());
    }
}
