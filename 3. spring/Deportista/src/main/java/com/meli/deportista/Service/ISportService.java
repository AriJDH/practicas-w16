package com.meli.deportista.Service;

import com.meli.deportista.Dto.SportDto;
import com.meli.deportista.Dto.SportPeopleDto;

import java.util.List;

public interface ISportService {
    List<SportDto> getSports();

    SportDto getByName(String name);

    List<SportPeopleDto> findSportsPersons();
}
