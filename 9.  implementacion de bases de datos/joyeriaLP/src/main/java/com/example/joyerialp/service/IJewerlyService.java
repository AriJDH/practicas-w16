package com.example.joyerialp.service;

import com.example.joyerialp.model.Jewerly;

import java.util.List;

public interface IJewerlyService {

    Jewerly findJewerly(Long id);
    Jewerly updateJewerly(Long id, Jewerly jewerly);
    void saveJewerly(Jewerly jewerly);
    void delete2Jewerly(Long id);
    Jewerly deleteJewerly(Long id);
    List<Jewerly> getJewerlys();

}
