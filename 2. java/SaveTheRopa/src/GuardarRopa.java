import java.util.List;
import java.util.Map;

public class GuardarRopa {
    private Map<Integer, List<Prenda>> armario;
    private int identificador;

    public GuardarRopa(Map<Integer, List<Prenda>> armario, int identificador) {
        this.armario = armario;
        this.identificador = identificador;
    }

    public GuardarRopa() {
    }

    public Map<Integer, List<Prenda>> getArmario() {
        return armario;
    }

    public void setArmario(Map<Integer, List<Prenda>> armario) {
        this.armario = armario;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Integer guardarPrendas (List<Prenda> prendas){
        identificador++;
        this.armario.put(identificador,prendas);
        return identificador;
    }

    public void mostrarPrendas(){
        if(armario.size()==0){
            System.out.println("No hay prendas en el armario");
        }
        else{
            armario.forEach((clave, prendas )->{
                System.out.println("Identificador: "+ clave);
                for (Prenda p:
                        prendas) {
                    System.out.println(p.toString());
                }
            });
        }
    }


    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> prendas = armario.get(numero);
        armario.remove(numero);
        return prendas;
    }


}
