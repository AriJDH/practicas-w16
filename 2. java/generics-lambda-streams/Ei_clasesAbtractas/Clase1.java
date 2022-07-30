package Ei_clasesAbtractas;

public class Clase1 extends Prototipo<Integer> {

    private int nro =0;
    private int nroSuma =0;

    public Integer valorSiguiente() {
        nro += nroSuma;
        return nro;
    }

    public Integer reiniciar() {
        nro = 0;
        return nro;
    }

    @Override
    public Integer valorInicial(Integer valor) {
        nro = valor;
        nroSuma = valor;
        return nro;
    }

}
