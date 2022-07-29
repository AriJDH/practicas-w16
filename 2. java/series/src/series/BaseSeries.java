package series;

public abstract class BaseSeries {

    protected Number initial = 0;
    protected final Number increment;

    protected BaseSeries(Number increment) {
        this.increment = increment;
    }

    public Number next() {
        initial = initial.doubleValue() + increment.doubleValue();
        return initial;
    }

    public void reset() {
        setInitial(0);
    }

    public void setInitial(Number initial) {
        this.initial = initial;
    }
}
