package practicesInterfaceAbstract2;

public class Print<T> implements IPrint<T> {

    @Override
    public void printDocument(T object) {
        System.out.println("Imprimiendo: ");
        System.out.println(object);
    }
}
