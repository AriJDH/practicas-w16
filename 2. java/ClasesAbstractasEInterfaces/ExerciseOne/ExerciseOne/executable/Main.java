package ExerciseOne.executable;

import   ExerciseOne.actors.*;

public class Main{
    public static void main(String args[]){
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.hacerDeposito();
        ejecutivo.hacerTransferencia();
    }
}