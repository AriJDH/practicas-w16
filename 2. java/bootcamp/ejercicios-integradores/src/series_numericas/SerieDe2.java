package series_numericas;

import java.util.ArrayList;
import java.util.List;

public class SerieDe2 extends Prototipo{

    private Number valorInicial;
    private Number valorFinal;

    @Override
    public void siguienteDeLaSerie() {

        Number siguiente = this.valorFinal.intValue()+2;
        this.valorFinal = siguiente;
        System.out.println(siguiente);
    }

    @Override
    public void reiniciarSerie() {
        this.valorFinal = valorInicial;
    }

    @Override
    public void establecerValorInicial(Number valorInicial) {
        this.valorInicial = valorInicial;
        this.valorFinal = valorInicial;
    }
}
