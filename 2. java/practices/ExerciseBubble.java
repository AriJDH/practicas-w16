package practices;

import practicesInterfaceAbstract1.Collector;

import java.util.Arrays;

public class ExerciseBubble {
    public static void main(String[] args) {
        int[] arrayburbble = {1,90,100,3,5,6,10,35};
        burbble(arrayburbble);
    }

    public static void burbble(int[] array) {
        System.out.println(Arrays.toString(Arrays.stream(array).sorted().toArray()));
    }
}
