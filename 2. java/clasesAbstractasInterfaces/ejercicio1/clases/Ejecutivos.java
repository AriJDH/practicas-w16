package clases;

import interfaces.Deposito;
import interfaces.Transferencia;

public class Ejecutivos implements Deposito,Transferencia{

	@Override
	public void transaccionOk() {
		// TODO Auto-generated method stub
	}

	@Override
	public void transaccionNoOk() {
		// TODO Auto-generated method stub

	}

	@Override
	public void realizarTransferencia() {
      System.out.println("realizando una transferencia...");
	}

	@Override
	public void realizarDeposito() {
		// TODO Auto-generated method stub

	}

}
