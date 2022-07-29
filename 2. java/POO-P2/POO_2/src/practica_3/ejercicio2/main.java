package practica_3.ejercicio2;

public class main implements Imprimir{

    public static void main(String[] args) {

        Curriculum cv = new Curriculum();
        LibroPdF libroPDF = new LibroPdF();

        Imprimir.imprimirTexto(cv.toString());
        Imprimir.imprimirTexto(libroPDF.toString());

    }
}

//
//// Java program to demonstrate
//// static method in Interface.
//
//interface NewInterface {
//
//    // static method
//    static void hello()
//    {
//        System.out.println("Hello, New Static Method Here");
//    }
//
//    // Public and abstract method of Interface
//    void overrideMethod(String str);
//}
//
//// Implementation Class
//public class InterfaceDemo implements NewInterface {
//
//    public static void main(String[] args)
//    {
//        InterfaceDemo interfaceDemo = new InterfaceDemo();
//
//        // Calling the static method of interface
//        NewInterface.hello();
//
//        // Calling the abstract method of interface
//        interfaceDemo.overrideMethod("Hello, Override Method here");
//    }
//
//    // Implementing interface method
//
//    @Override
//    public void overrideMethod(String str)
//    {
//        System.out.println(str);
//    }
//}