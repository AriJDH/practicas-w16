package EjemploHerencia;

public class Main {
    public static void main(String[] args) {

        Instrumentos instrumento = new Instrumentos();
        instrumento.tocar();

        Guitarra guitarra = new Guitarra();
        guitarra.tocar();

        Instrumentos guitarra2 = new Guitarra();
        guitarra2.tocar();

        Trompeta trompeta = new Trompeta();
        trompeta.tocar();


    }
}
