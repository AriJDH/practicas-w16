import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Excepciones {
    public static void main(String[] args) {
        /*int valor = 0;
        double resultado = 10/ valor;
        Exception in thread "main" java.lang.ArithmeticException: / by zero*/

        try{
            FileInputStream fileInputStream = new FileInputStream("noexiste.txt");
        }catch (FileNotFoundException exception){
            //System.out.println("Archivo no existe");
            exception.printStackTrace(System.out);//se lo agrego para que me lo tire con consola
        }

    }
}
/*
printStackTrace();
at java.base/java.io.FileInputStream.open0(Native Method)
	at java.base/java.io.FileInputStream.open(FileInputStream.java:219)
	at java.base/java.io.FileInputStream.<init>(FileInputStream.java:157)
	at java.base/java.io.FileInputStream.<init>(FileInputStream.java:112)
	at Excepciones.main(Excepciones.java:11)

 */
