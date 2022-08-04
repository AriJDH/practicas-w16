package com.practice.covid.Service;

import com.practice.covid.DTO.GravedadSintomaDTO;
import com.practice.covid.DTO.ListSintomasDTO;
import com.practice.covid.entity.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ServiceSintomas {

    static List<Sintoma> sintomaList = new ArrayList<>(Arrays.asList(
            new Sintoma("DF21G", "Dolor de cabeza", "Normal"),
            new Sintoma("KCOW3", "Dificultad para respirar", "Moderado"),
            new Sintoma("CWE46", "Perdida de gusto", "Alto"),
            new Sintoma("CWY78", "Perdida de olfato", "Alto")
    ));

    public ListSintomasDTO findSymptom() {
        ListSintomasDTO listSintomasDTO = new ListSintomasDTO();
        listSintomasDTO.setSintomasList(sintomaList);

        return listSintomasDTO;
    }

    public GravedadSintomaDTO findSymptomByName(String name) {
        Sintoma sintoma = sintomaList.stream().filter(x -> x.getNombre().equals(name)).findFirst().orElse(null);
        GravedadSintomaDTO gravedadSintomaDTO = new GravedadSintomaDTO();

        if (sintoma == null) {
            return gravedadSintomaDTO;
        }

        gravedadSintomaDTO.setGravedad(sintoma.getNivelGravedad());

        return gravedadSintomaDTO;
    }
}
