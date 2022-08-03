package com.mercadolibre.bootcamp.deportistas.repositories;

import com.mercadolibre.bootcamp.deportistas.domain.Sport;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SportsRepository extends GenericRepository<Sport>{

    public Optional<Sport> searchByName(String name){
        return data
                .stream()
                .filter(sport -> sport.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
