package EjercicioAbstraccion;

public class SerieThree extends Prototipo{
    @Override
    Integer serieProgresiva() {
        Integer result=establecerValorInicial(1)+2;
                return result;
    }

    @Override
    Integer reiniciaSerie() {
        Integer result=establecerValorInicial(1)+2;
        return result;
    }

    @Override
    Integer establecerValorInicial(Integer v) {
        return v;
    }
}
