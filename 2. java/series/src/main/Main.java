package main;

import series.AddThreeSeries;
import series.AddTwoSeries;
import series.BaseSeries;

public class Main {
    public static void main(String[] args) {
        BaseSeries series2 = new AddTwoSeries();
        BaseSeries series3 = new AddThreeSeries();

        System.out.println(series2.next());
        System.out.println(series2.next());
        System.out.println(series2.next());
        System.out.println(series2.next());
        System.out.println();

        series2.reset();

        System.out.println(series2.next());
        System.out.println(series2.next());
        System.out.println(series2.next());
        System.out.println(series2.next());
        System.out.println();

        series2.setInitial(5);

        System.out.println(series2.next());
        System.out.println(series2.next());
        System.out.println(series2.next());
        System.out.println(series2.next());
        System.out.println();

        System.out.println(series3.next());
        System.out.println(series3.next());
        System.out.println(series3.next());
        System.out.println(series3.next());
        System.out.println();
    }
}
