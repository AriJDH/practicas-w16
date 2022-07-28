package ejercicio1;

public class Cliente implements Transaccion {


    @Override
    public void transaccionOK() {
        System.out.println("ok");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("nook");

    }

}
