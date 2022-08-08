import com.bootcamp.exceptions.ExceptionOne;
import com.bootcamp.secondExercise.Product;

public class Main {
    static ExceptionOne exceptionOneClass = new ExceptionOne();
    static Product productClass = new Product();

    public static void main(String[] args) {
        exceptionOnee();
    }

    public static void exceptionOnee() {
        try{
            exceptionOneClass.calculateQuotient(0, 300);
        } catch (ArithmeticException ex){
            //System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
