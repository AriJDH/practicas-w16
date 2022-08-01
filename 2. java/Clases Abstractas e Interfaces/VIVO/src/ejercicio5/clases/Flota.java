package ejercicio5.clases;

import ejercicio5.interfaces.Nave;

import java.util.List;

public class Flota implements Nave {
    private List<NaveSimple> listaNaves;

    @Override
    public String toString() {
        String res = "";
        for (NaveSimple nave : listaNaves){
            res += "\n" + nave.toString() ;
        }
        return res;
    }

    public List<NaveSimple> getListaNaves() {
        return listaNaves;
    }

    public void setListaNaves(List<NaveSimple> listaNaves) {
        this.listaNaves = listaNaves;
    }

    public Flota(List<NaveSimple> listaNaves) {
        this.listaNaves = listaNaves;
    }

    @Override
    public double calcularDistancia(double x, double y){
        double resultado = 0;
        int cantidadNaves = listaNaves.size();
        double totalDistancia = 0;
        for (NaveSimple nave : listaNaves){
                totalDistancia += nave.calcularDistancia(x,y);
        }
        resultado = totalDistancia / cantidadNaves;
        return resultado;
    }
}
