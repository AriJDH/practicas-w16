package com.meli.deportista.Repository;

import com.meli.deportista.Dto.SportDto;

import java.util.List;

public interface ISportRepository {

    List<SportDto> getSports();

    SportDto getByName(String name);
}
