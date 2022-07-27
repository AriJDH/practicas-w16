

public class Main {


    public static void main(String[] args) {

        //parte A
        Business program = new Business();
        program.getMySystem().addSubscriptor("chico", "joaco", "antonio", "51188045", 29, "555", "5555", "AB+");
        program.getMySystem().addSubscriptor("medio", "carlos", "antonio", "51188045", 29, "555", "5555", "AB+");
        program.getMySystem().addSubscriptor("avanzado", "mariana", "antonio", "51188045", 29, "555", "5555", "AB+");


        //parte B
        program.getMySystem().printSubscriptors("chico");


        //parte C
        program.getMySystem().removeSubscriptor(3);

        //parte D
        program.getMySystem().calculateSubscriptionById(2);


    }


}
