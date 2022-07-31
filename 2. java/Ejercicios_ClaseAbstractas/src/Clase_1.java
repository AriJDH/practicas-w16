public class Clase_1  extends Prototipo{

    public Clase_1(Number serie) {
        super(serie);
    }

    @Override
    public Number siguienteSerie() {

         super.serie=super.serie.intValue()+2;
         return super.serie;

    }
}
