
import Banco.*;
import Imprimir.*;
import Veterinaria.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        banco();
        imprimir();
        veterinaria();
    }
    public static void banco()
    {
        System.out.println("======== Banco ========");
        Basic basic = new Basic();
        basic.consultarSaldo();
        basic.pagoServicio();
        basic.retiroEfectivo();
        Cobrador cobrador = new Cobrador();
        cobrador.consultarSaldo();
        cobrador.retiroEfectivo();
        Ejectutivo ejectutivo = new Ejectutivo();
        ejectutivo.realizarDeposito();
        ejectutivo.transferencia();

    }
    public static void imprimir()
    {
        System.out.println("======== Imprimir ========");
        List<String> lstHabilidades = new ArrayList<String>();
        lstHabilidades.add("C#");
        lstHabilidades.add("Linq");
        Date fechaNacimiento = new Date(1986, Calendar.JULY, 18);
        IImprimir curriculum = new Curriculum("Aldo","Castagnoli", fechaNacimiento, "164086127", lstHabilidades);
        IImprimir libroPDF = new LibroPDF(250, "J.K. RowLing","Harry Potter", "Ficción");
        IImprimir informe = new Informe(10000, 50, "Pedro Peréz", "Juan Palito");
        curriculum.imprimir();
        libroPDF.imprimir();
        informe.imprimir();
    }
    public static void veterinaria(){
        System.out.println("======== Veterinaria ========");
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();
        perro.hacerSonido();
        perro.comerCarne();
        gato.hacerSonido();
        gato.comerCarne();
        vaca.hacerSonido();
        vaca.comerHierba();
        System.out.println("Comer Animal");
        Animal.comerAnimal(vaca);
        Animal.comerAnimal(gato);
        Animal.comerAnimal(perro);
    }
}
