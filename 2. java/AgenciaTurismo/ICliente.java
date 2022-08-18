package AgenciaTurismo;

public interface ICliente {
    ILocalizador getLocalizadorById(int id);
    void agregarLocalizador(ILocalizador localizador);
}
