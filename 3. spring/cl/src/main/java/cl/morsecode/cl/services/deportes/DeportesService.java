package cl.morsecode.cl.services.deportes;

import cl.morsecode.cl.dto.Persona_Deporte_DTO;
import cl.morsecode.cl.entities.deportista.Deporte;
import cl.morsecode.cl.entities.deportista.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeportesService {
    private static List<Deporte> deportes = new ArrayList<>();
    private static List<Persona> personas = new ArrayList<>();
    private static List<Persona_Deporte_DTO> deportistas = new ArrayList<>();

    public List<Deporte> getDeportes(){
        return deportes;
    }

    public Deporte findDeporte(String name){
        return deportes.stream().filter(deporte -> deporte.getNombre().equals(name))
                .findAny()
                .orElse(null);
    }

    public Deporte addDeporte(Deporte deporte) {
        if (findDeporte(deporte.getNombre()) == null){
            deportes.add(deporte);
            return deporte;
        } {
            return null;
        }
    }

    public Persona addPersona(Persona persona) {
        if (findPersona(persona.getNombre()) == null){
            personas.add(persona);
            return persona;
        } else {
            return null;
        }
    }

    public Persona findPersona(String name){
        return personas.stream().filter(persona -> persona.getNombre().equals(name))
                .findAny()
                .orElse(null);
    }

    public Persona_Deporte_DTO addDeportista(Persona_Deporte_DTO persona_deporte_dto){
        if (findDeporte(persona_deporte_dto.getDeporte().getNombre()) != null && findPersona(persona_deporte_dto.getPersona().getNombre()) != null){
            deportistas.add(persona_deporte_dto);
            return persona_deporte_dto;
        } else {
            return null;
        }
    }

    public List<Persona_Deporte_DTO> getDeportistas() {
        return deportistas;
    }
}
