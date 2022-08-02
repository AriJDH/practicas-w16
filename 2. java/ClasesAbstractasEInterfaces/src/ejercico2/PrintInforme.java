package ejercico2;

public class PrintInforme implements Print<Informe>{

    @Override
    public void imprimirDocumento(Informe obj) {
        System.out.println(obj.toString());
    }
}
