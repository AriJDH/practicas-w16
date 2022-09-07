package com.bootcamp.aplication.service;

import com.bootcamp.aplication.dto.SWCharacterDTO;
import com.bootcamp.aplication.entity.SWCharacter;
import com.bootcamp.aplication.repository.StarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsService implements IStarWarsService {

    @Autowired
    StarWarsRepository starWarsRepository;

    @Override
    public List<SWCharacter> getDataCharacters() {
        return starWarsRepository.getCharacterList();
    }

    @Override
    public List<SWCharacterDTO> findCharacter(String s) {

        List<SWCharacterDTO> characterList = new ArrayList<>();

        getDataCharacters().stream()
                .filter(data -> data.getName().toUpperCase().contains(s.toUpperCase()))
                .forEach(data -> {
                    SWCharacterDTO characterDTO = new SWCharacterDTO();

                    int height = (data.getHeight().equals("NA")) ? -1 : Integer.valueOf(data.getHeight());
                    int mass = (data.getMass().equals("NA")) ? -1 : Integer.valueOf(data.getMass());

                    characterDTO.setName(data.getName());
                    characterDTO.setHeight(height);
                    characterDTO.setMass(mass);
                    characterDTO.setGender(data.getGender());
                    characterDTO.setHomeworld(data.getHomeworld());
                    characterDTO.setSpecies(data.getSpecies());

                    characterList.add(characterDTO);
                });

        return characterList;
    }
}
