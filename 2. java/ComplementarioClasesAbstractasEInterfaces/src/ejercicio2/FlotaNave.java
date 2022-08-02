package ejercicio2;

import java.util.List;
import java.util.OptionalDouble;

public class FlotaNave implements Icompetidor {
    List<Nave> listaNave;

    public FlotaNave(List<Nave> listaNave) {
        this.listaNave = listaNave;
    }

    @Override
    public double calcularDistancia(int coorX,int coorY) {

        OptionalDouble result =listaNave.stream().mapToDouble(x->Math.sqrt(Math.pow(x.getCorrdenadaX()-coorX,2)+Math.pow(x.getCoordenadaY()-coorY,2))).average();
        if(result.isPresent()) {return result.getAsDouble();}
        else return 0;
    }
}
