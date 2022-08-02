package ejercico2;

public class PrintCurriculum implements Print<Curriculum> {
    @Override
    public void imprimirDocumento(Curriculum obj) {
        System.out.println(obj.toString());
    }
}
