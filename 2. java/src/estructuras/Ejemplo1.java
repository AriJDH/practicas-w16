package estructuras;

import java.util.Scanner;

public class Ejemplo1 {

    public static void main(String[] args) {
int numero;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese un numero");

try {
    numero = Integer.parseInt(entrada.nextLine());
    entrada.close();
    if(numero%2==0){
        System.out.println("Numero par");
    }else{
        System.out.println("Numero Impar");
    }

}catch(NumberFormatException a){
    System.out.println("Ingrese solo numeros");
}


    }
}
