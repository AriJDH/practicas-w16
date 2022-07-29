package poo_p2_vivo;
//Ejercicio 1
public class PracticaExcepciones {
    public int a = 0;
    public int b = 300;

    public float calcularDeficiente() {
        try {
            return b%a;
        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir entre 0");
        } finally {
            System.out.println("Programa finalizado");
            return 0;
        }
    }
}
