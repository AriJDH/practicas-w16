package EjerciciosClasesAbstractas;

public class Serie extends Prototipo {

    @Override
    public Integer siguienteValorSerieProgresiva(Integer valor) {
        valorInicial +=valor;
        establecerValorInicialSerie(valorInicial);
        return valorInicial;
    }
}
