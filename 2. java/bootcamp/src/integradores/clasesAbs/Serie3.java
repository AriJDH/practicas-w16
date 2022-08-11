package integradores.clasesAbs;

public class Serie3 extends Prototipo{
    private Integer lastNumber;
    private Integer startNumber;

    @Override
    public Integer getNext() {
        Integer next = lastNumber + 3;
        this.lastNumber = next;
        return next;
    }

    @Override
    public void restart() {
        this.lastNumber = startNumber;
    }

    @Override
    public void setStart(Integer start) {
        this.lastNumber = start;
        this.startNumber = start;
    }
}
