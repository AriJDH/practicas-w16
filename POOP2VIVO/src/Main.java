import com.bootcamp.exception.*;
import com.bootcamp.twoExercise.Perecedero;
import com.bootcamp.twoExercise.Producto;

import java.io.IOException;

public class Main {

    static OneException oneExceptionClass = new OneException();
    static OneExercise oneExerciseClass = new OneExercise();



    public static void main(String[] args) {

    }

    public static void exceptioOne(){
        try{
            oneExceptionClass.writeToFile();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }


    public static void oneExercise(){
        try {
            oneExerciseClass.divide(300, 0);

        }catch (ArithmeticException ex){
            //System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
