package ejercicio1;

public class Ejecutivo implements Deposito, RealizarTransferencia{

  @Override
  public void hacerDeposito() {
    System.out.println("“Realizándose depósito”");
  }

  @Override
  public void realizarTransferencia() {
    System.out.println("haciendo transferencia");
  }

  @Override
  public void transaccionOk() {
    System.out.println("Transaccion exitosa !");
  }

  @Override
  public void transaccionNoOk() {
    System.out.println("Transaccion fallida :(");
  }
}
