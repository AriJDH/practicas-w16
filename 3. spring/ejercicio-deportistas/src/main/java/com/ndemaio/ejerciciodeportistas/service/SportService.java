package com.ndemaio.ejerciciodeportistas.service;

import com.ndemaio.ejerciciodeportistas.entity.Sport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SportService {

    private final List<Sport> sports;

    public SportService() {
        this.sports = new ArrayList<>();
    }

    public List<Sport> findAll() {
        return sports;
    }

    public Sport findByName(String name) {
        return sports.stream().filter(sport -> sport.getName().equals(name)).findFirst().orElseThrow(() -> new IllegalStateException("No sport found"));
    }
}
