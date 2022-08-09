package ejercicio2;

import jdk.swing.interop.SwingInterOpUtils;

public interface Imprimir<T> {
    static <T> void imprimir(T documento) {
        System.out.println(documento);
    }
}

