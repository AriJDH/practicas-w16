package animales;

/*
 * Ejercicio > Modulo 5: Java > ClasesAbstractasEInterfaces-VIVO
 * ESTADO: Finalizado (falta revisión).
 * @GonzaloNahuelDiPierro
 * */
public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        System.out.println("RESULTADOS");

        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();
        System.out.println();

        ((Carnivoro)perro).comerCarne();
        ((Carnivoro)gato).comerCarne();
        ((Herviboro)vaca).comerHierba();
        System.out.println();

        ((Carnivoro)perro).comerAnimal(gato);
        System.out.println(gato == null ? "El gato falleció." : "El gato está vivo de milagro."); // Revisar
    }
}
