package clases;

import java.util.ArrayList;

public class Circuito {

    public Circuito(String nombre, double precioMenor, double precioMayor){
        this.nombre = nombre;
        this.listaParticipantes = new ArrayList<Participante>();
        this.precioMenores = precioMenor;
        this.precioMayores = precioMayor;
    }

    public String nombre;
    public ArrayList<Participante> listaParticipantes;
    public double precioMenores;
    public double precioMayores;

    public boolean eliminarParticipante(int nro) {

        int i = 0;
        boolean found = false;

        do{
            if(listaParticipantes.get(i).nroParticipante == nro){
                found = true;
                listaParticipantes.remove(i);
            }
        } while (i < this.listaParticipantes.size() && !found);

        return found;
    }

    public void agregarParticipante(Participante p) {
        this.listaParticipantes.add(p);
    }

    public void listarParticipantes() {

        System.out.println("------------------------------------------------------");
        System.out.println("Participantes circuito " + this.nombre);
        System.out.println("------------------------------------------------------");
        for (int i=0; i < this.listaParticipantes.size(); i++){
            Participante p = this.listaParticipantes.get(i);
            System.out.println(p.nroParticipante + " - " + p.nombre + " " + p.apellido);
        }
    }

    public double getPrecio(Participante p){
        double retorno = this.precioMenores;
        if(p.edad >= 18)
            retorno = precioMayores;

        return retorno;
    }
}
