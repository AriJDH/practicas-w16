import java.util.*;

public class Asteroid {
    private List<Participante> listaParticipantes;
    private List<Meteorito> listaMeteoritos;

    public List<Participante> getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(List<Participante> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    public List<Meteorito> getListaMeteoritos() {
        return listaMeteoritos;
    }

    public void setListaMeteoritos(List<Meteorito> listaMeteoritos) {
        this.listaMeteoritos = listaMeteoritos;
    }

    @Override
    public String toString() {
        return "Asteroid{" +
                "listaParticipantes=" + listaParticipantes +
                ", listaMeteoritos=" + listaMeteoritos +
                '}';
    }

    public Asteroid(List<Participante> listaParticipantes, List<Meteorito> listaMeteoritos) {
        this.listaParticipantes = listaParticipantes;
        this.listaMeteoritos = listaMeteoritos;
    }

    public void jugarAsteroid(){

        Map<Participante,Integer> puntajes = new HashMap<>();
        //Recorro lista de materitos, cada meteorito correesponde a una ronda donde muestro distancia de cada participante del meteorito
        //Luego lo ingreso a un mapa de participante y distrancias, selecciono la menor y asigno el puntaje a su Nave
        for (int i=0;i<listaMeteoritos.size();i++){
            Map<Participante,Double> puntajes_parciales = new HashMap<>();
            System.out.println("¡APARECE " + (i+1) + " METEORITO!");
            for (int j=0;j<listaParticipantes.size();j++){
                double distancia=listaParticipantes.get(j).getNave().calcularDistancia(listaMeteoritos.get(i).getCoordenada_x(),listaMeteoritos.get(i).getCoordenada_y());
                System.out.printf(listaParticipantes.get(j).getNombre() + " se encuentra a %.2f del meteorito\n", distancia);


                puntajes_parciales.put(listaParticipantes.get(j),distancia);
            }
            Participante m=Collections.min(puntajes_parciales.entrySet(), Map.Entry.comparingByValue()).getKey();
            System.out.println("¡Meteorito impactado por " + m.getNombre()+"!");
            m.getNave().setPuntuacion_inicial(1+m.getNave().getPuntuacion_inicial());
        }
        //Recorro la lista de participante y muestro sus puntajes.
        //Los ingreso a un mapa de participante, puntaje y selecciono el mayor que se muestra como ASTEROID
        System.out.println("Los puntajes por participante son:");
        for (Participante participante:listaParticipantes){
            System.out.println(participante.getNombre() + ": " + participante.getNave().getPuntuacion_inicial());
            puntajes.put(participante, participante.getNave().getPuntuacion_inicial());
        }
        System.out.println("EL ASTEROID ES: " + Collections.max(puntajes.entrySet(), Map.Entry.comparingByValue()).getKey().getNombre());

    }




}
