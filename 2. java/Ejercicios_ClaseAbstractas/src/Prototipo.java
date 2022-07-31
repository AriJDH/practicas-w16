public abstract class Prototipo {

    Number serie;
    Number original;

    public Prototipo(Number serie){
        this.serie=serie;
        this.original=serie;
    }
    public abstract Number siguienteSerie();

    public void resetSerie(){

        this.serie=original;
    };


    public void setSerie(Number serie) {
        this.serie = serie;
    }
}
