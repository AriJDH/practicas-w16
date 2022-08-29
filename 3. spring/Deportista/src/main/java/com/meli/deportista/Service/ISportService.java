package com.meli.deportista.Service;

import com.meli.deportista.Dto.SportDto;

import java.util.List;

public interface ISportService {
    List<SportDto> getSports();

    SportDto getByName(String name);
}
