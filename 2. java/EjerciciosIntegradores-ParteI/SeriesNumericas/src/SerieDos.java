public class SerieDos extends Prototipo {

    public SerieDos(int valorInicial) {
        super(valorInicial);
    }

    @Override
    public int devolverNumero() {
        super.setValorInicial(super.valorInicial +2);
        return super.valorInicial;
    }


}
