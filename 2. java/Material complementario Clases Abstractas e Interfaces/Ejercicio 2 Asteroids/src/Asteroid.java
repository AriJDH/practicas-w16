import javax.swing.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        Map<Meteorito, Participante> mapMeteoritoParticipante=new HashMap<Meteorito,Participante>();
        Map<Participante, Long> puntajes = new HashMap<>();
        Participante ganador;

        //Mapeo los meteoritos con quien lo destruyó respectivamente
        for (Meteorito meteoro:listaMeteoritos){
            mapMeteoritoParticipante.put(meteoro, this.destruirMeteorito(meteoro, listaParticipantes));
        }

        //Mapeo los participantes con la cantidad de veces que destruyeron un meteorito
        puntajes = mapMeteoritoParticipante.values().stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        ));

        //Obtengo el ganador contando quien tiene màs puntaje (value del map puntajes)
        ganador = puntajes.entrySet().stream().max((a,b)->a.getValue()>b.getValue() ? 1:-1).get().getKey();

        //Imprimo ganador
        System.out.println("El ganador es: " + ganador.toString());

        //Imprimo los puntajes de los participantes
        System.out.println("Puntajes");
        List<Map.Entry<Participante, Long>> list = new ArrayList<>(puntajes.entrySet());
        list.sort(Map.Entry.comparingByValue());
        list.forEach(System.out::println);

        //Imprimo que nave destruyo cada meteorito
        System.out.println("Destrucción por asteroide");
        List<Map.Entry<Meteorito,Participante>> list2 = new ArrayList<>(mapMeteoritoParticipante.entrySet());
        list2.forEach(System.out::println);

    }


    public Participante destruirMeteorito(Meteorito meteoro, List<Participante> participantes) {
        Comparator<Participante> comparator = getMinDistancia(meteoro.getCoordenada_x(), meteoro.getCoordenada_y());
        Participante p = participantes.stream()
                .min(comparator).get();
        return p;
    }

    public Comparator<Participante> getMinDistancia(int coordenada_meteorito_x, int coordenada_meteorito_y){
        return Comparator.comparingDouble(p->p.promedioDistancia(coordenada_meteorito_x,coordenada_meteorito_y));
    }



}
