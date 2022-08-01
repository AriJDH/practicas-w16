package practicesIntegrator1;

public interface IRepository<T> {

    T create(T object);

    T consult(T object);

    boolean delete(T object);

    boolean update(T object);

}
