package ejercico2;

public class PrintLibroPdf implements Print<LibroPdf>{


    @Override
    public void imprimirDocumento(LibroPdf obj) {
        System.out.println(obj.toString());
    }
}
