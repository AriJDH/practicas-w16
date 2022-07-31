public class Basic extends Clientes {

    private Depositos depositos=new Depositos();

    public Basic(String dni, String nombre, String apellido, int celular) {
        super(dni, nombre, apellido, celular);
    }

    public void depositarOk(){
        this.depositos.transaccionOk();
    }

    public void depostirarNoOK(){
        this.depositos.transaccionNoOk();
    }
}
