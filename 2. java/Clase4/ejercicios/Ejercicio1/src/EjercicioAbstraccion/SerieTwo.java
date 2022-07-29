package EjercicioAbstraccion;

public class SerieTwo extends Prototipo{
    @Override
    Integer serieProgresiva() {
        Integer result=establecerValorInicial(0)+2;
        return result;
    }

    @Override
    Integer reiniciaSerie() {
        Integer result=establecerValorInicial(0)+2;
        return result;
    }

    @Override
    Integer establecerValorInicial(Integer v) {
        return v;
    }
}
