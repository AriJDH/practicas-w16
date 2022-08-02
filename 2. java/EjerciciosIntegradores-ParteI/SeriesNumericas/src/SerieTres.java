public class SerieTres extends Prototipo{

    public SerieTres(int valorInicial) {
        super(valorInicial);
    }

    @Override
    public int devolverNumero() {
        super.setValorInicial(super.valorInicial +3);
        return super.valorInicial;
    }
}
