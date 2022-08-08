package com.example.ejerciciodeportistas.repository;

import com.example.ejerciciodeportistas.entities.covid.Persona;
import com.example.ejerciciodeportistas.entities.covid.PersonaCovid;
import com.example.ejerciciodeportistas.entities.covid.Sintoma;

import java.util.Locale;
import java.util.Optional;

public class PersonaCovidRepo {
    public Repository<Persona> Persona = new Repository<>();
    public Repository<Sintoma> Sintoma = new Repository<>();
    public Repository<PersonaCovid> PersonaCovid = new Repository<>();

    public PersonaCovidRepo(){

        init();
    }

    private void init()
    {
        Persona persona1 = new Persona(1, "Aldo", "Castagnoli", 36);
        Persona persona2 = new Persona(2, "Hugo", "Donoso", 36);
        Persona persona3 = new Persona(2, "Luz", "Ahumada", 66);
        Sintoma sintoma1 = new Sintoma("c-1", "Tos", "Leve");
        Sintoma sintoma2 = new Sintoma("c-2", "Fiebre", "Medio");
        this.Persona.add(persona1);
        this.Persona.add(persona2);
        this.Persona.add(persona3);
        this.Sintoma.add(sintoma1);
        this.Sintoma.add(sintoma2);

        Optional<Sintoma> sintomapersona1 =  this.Sintoma.firstOrDefaul(x ->x.getNombre().toLowerCase(Locale.ROOT) == "tos".toLowerCase(Locale.ROOT));
        Optional<Sintoma> sintomapersona2 =  this.Sintoma.firstOrDefaul(x ->x.getNombre().toLowerCase(Locale.ROOT) == "malestar estomacal".toLowerCase(Locale.ROOT));
        Optional<Sintoma> sintomapersona3 =  this.Sintoma.firstOrDefaul(x ->x.getNombre().toLowerCase(Locale.ROOT) == "fiebre".toLowerCase(Locale.ROOT));

        this.PersonaCovid.add(new PersonaCovid(persona1, sintomapersona1));
        this.PersonaCovid.add(new PersonaCovid(persona2, sintomapersona2));
        this.PersonaCovid.add(new PersonaCovid(persona3, sintomapersona3));
    }


}
