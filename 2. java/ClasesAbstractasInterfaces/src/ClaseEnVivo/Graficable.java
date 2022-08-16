package ClaseEnVivo;

public interface Graficable {
    //se le puede agregar atributos static
    final static Double PI = 3.14;
    public void graficarFigura();
    public Integer numberOfSide();
   // se le puede agregra un metodo default
    default Boolean isRectangle(FiguraGeometrica figura) {
        if (figura.numberOfSide() == 4)
            return true;
        else return false;
    }
}
