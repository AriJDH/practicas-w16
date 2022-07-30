package SeriesNumericas;

public class Main {
    public static void main(String[] args) {
        SerieNumerica testSerie2 = new Serie2(2);
        SerieNumerica testSerie3 = new Serie3(3);
        Fibonacci testFibonacci = new Fibonacci(1);
        SerieN testSerie5 = new SerieN(0,5);

        System.out.println("Serie de 2:");
        for (int i = 1; i<=10; i++){
            System.out.println("i="+i+'\t'+testSerie2.getValActual());
            testSerie2.sigVal();
        }

        System.out.println("Serie de 3:");
        for (int i = 1; i<=10; i++){
            System.out.println("i="+i+'\t'+testSerie3.getValActual());
            testSerie3.sigVal();
        }

        System.out.println("Serie de 5:");
        for (int i = 1; i<=10; i++){
            System.out.println("i="+i+'\t'+testSerie5.getValActual());
            testSerie5.sigVal();
        }

        System.out.println("Serie de Fibonacci:");
        for (int i = 1; i<=10; i++){
            System.out.println("i="+i+'\t'+testFibonacci.getValActual());
            testFibonacci.sigVal();
        }
    }
}
