package EjerciciosClasesAbstractas;

import java.security.PublicKey;
import java.util.List;

public abstract class Prototipo {
    Integer valorInicial=0;


    public abstract Integer siguienteValorSerieProgresiva(Integer valor);

    public void establecerValorInicialSerie(Integer valor){
        valorInicial=valor;
    }

    public  void reiniciar(){
        valorInicial=0;
    }


}
