package integradores.clasesAbs;

public class Main {
    public static void main(String[] args) {

        Prototipo serie2 = new Serie2();
        serie2.setStart(1);
        System.out.println(serie2.getNext());
        System.out.println(serie2.getNext());
        System.out.println(serie2.getNext());
        System.out.println(serie2.getNext());


        Prototipo serie3 = new Serie3();
        serie3.setStart(3);
        System.out.println(serie3.getNext());
        System.out.println(serie3.getNext());
        System.out.println(serie3.getNext());
        serie3.restart();
        System.out.println(serie3.getNext());
        System.out.println(serie3.getNext());
        System.out.println(serie3.getNext());
    }
}
