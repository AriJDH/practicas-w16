import java.util.List;

public class Carrera {
    private int distancia;
    private String nombre;
    private  int premioEnDolares;

    private int cantidiadVehiculos;

    private List<Vehiculo> vehiculos;

    private SocorrerAuto socorrerAuto;
    private SocorrerMoto socorrerMoto;

    public Carrera() {
    }

    public Carrera(int distancia, String nombre, int premioEnDolares, int cantidadVehiculos, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.nombre = nombre;
        this.premioEnDolares = premioEnDolares;
        this.cantidiadVehiculos = cantidadVehiculos;
        this.vehiculos = vehiculos;
    }

    public int getCantidiadVehiculos() {
        return cantidiadVehiculos;
    }

    public void setCantidiadVehiculos(int cantidiadVehiculos) {
        this.cantidiadVehiculos = cantidiadVehiculos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(int premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public void darDeAltaAuto(int velocidad,int aceleracion,int anguloDeGiro,String patente){
        if(this.vehiculos.size()!=cantidiadVehiculos){
            Vehiculo vehiculo = new Auto(velocidad,aceleracion,anguloDeGiro,patente,1000,4);
            vehiculos.add(vehiculo);
        }
    }

    public void darDeAltaMoto(int velocidad,int aceleracion,int anguloDeGiro,String patente){
        if(this.vehiculos.size()!=cantidiadVehiculos){
            Vehiculo vehiculo = new Moto(velocidad,aceleracion,anguloDeGiro,patente,300,2);
            vehiculos.add(vehiculo);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if(this.vehiculos.size()!=0){
            vehiculos.remove(vehiculo);
        }
    }

    public void eliminarVehiculoConPatente(String patente){
        if(this.vehiculos.size()!=0){
            int index = 0;
            for (Vehiculo vehiculo :
                    this.vehiculos) {
                if (vehiculo.getPatente().equals(patente)) {

                }
                index++;
            }
            vehiculos.remove(index);
        }

    }


    public void determinarGanador(){
        int index =0;
        double maximo =0;
        int indexMaximo=0;
        for (Vehiculo vehiculo :
                this.vehiculos) {
            double valorFormula = vehiculo.getVelocidad()*0.5*vehiculo.getAceleración()/vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100);
            if(valorFormula>maximo){
                maximo=valorFormula;
                indexMaximo=index;
            }
            index++;
        }

        System.out.println("El ganador es " + vehiculos.get(indexMaximo).getPatente());
    }


    public void socorrerAuto(String patente) {
        for (Vehiculo vehiculo :
                vehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                socorrerAuto.socorrer((Auto) vehiculo);
            }
        }
    }

    public void socorrerMoto(String patente){
        for (Vehiculo vehiculo :
                vehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                socorrerMoto.socorrer((Moto) vehiculo);
            }
        }
    }
}
