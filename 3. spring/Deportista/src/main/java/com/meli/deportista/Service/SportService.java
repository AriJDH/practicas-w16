package com.meli.deportista.Service;

import com.meli.deportista.Dto.SportDto;
import com.meli.deportista.Entity.Sport;
import com.meli.deportista.Repository.ISportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportService implements ISportService {

    @Autowired
    private ISportRepository sportRepository;
    @Override
    public List<SportDto> getSports() {
        return sportRepository.getSports();
    }

    @Override
    public SportDto getByName(String name) {
        return sportRepository.getByName(name);
    }
}
