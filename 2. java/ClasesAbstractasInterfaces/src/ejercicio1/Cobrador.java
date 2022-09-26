package ejercicio1;

public class Cobrador implements ConsultaSaldo, RetiroEfectivo{

  @Override
  public void consultarSaldo() {
    System.out.println("Tu saldo es de . . . ");

  }

  @Override
  public void retirarEfectivo() {
    System.out.println("Retiro exitoso!");

  }

  @Override
  public void transaccionOk() {

  }

  @Override
  public void transaccionNoOk() {

  }
}
