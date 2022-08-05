package naves;

import java.util.List;
import java.util.stream.Collectors;

public class FlotaNaves extends Nave{
    List<Nave> listaNaves;

    public List<Nave> getListaNaves() {
        return listaNaves;
    }

    public void setListaNaves(List<Nave> listaNaves) {
        this.listaNaves = listaNaves;
    }

    public FlotaNaves(List<Nave> listaNaves) {
        this.listaNaves = listaNaves;
    }

    @Override
    public Double calcularDistancia(int meteorito_coordenada_x, int meteorito_coordenada_y) {

        Double distancia=listaNaves.stream()
                .map(nave -> nave.calcularDistancia(meteorito_coordenada_x,meteorito_coordenada_y))
                .collect(Collectors.toList())
                .stream().reduce(0.0d,(a,b)->a+b);

        return distancia/ listaNaves.size();
    }
}
