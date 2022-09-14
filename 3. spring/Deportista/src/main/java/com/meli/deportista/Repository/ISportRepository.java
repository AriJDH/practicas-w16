package com.meli.deportista.Repository;

import com.meli.deportista.Dto.SportDto;
import com.meli.deportista.Dto.SportPeopleDto;

import java.util.List;

public interface ISportRepository {

    List<SportDto> getSports();

    SportDto getByName(String name);

    List<SportPeopleDto> findSportsPersons();
}
