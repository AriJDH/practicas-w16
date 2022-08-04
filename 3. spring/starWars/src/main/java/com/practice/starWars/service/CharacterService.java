package com.practice.starWars.service;

import com.practice.starWars.dto.CharacterStarWarsDTO;
import com.practice.starWars.model.CharacterStarWars;
import com.practice.starWars.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService implements ICharterService {

    CharacterRepository characterRepository = new CharacterRepository();

    public CharacterService() {

    }

    @Override
    public List<CharacterStarWarsDTO> foundCharacterByName(String name) {
        List<CharacterStarWars> characterList = this.characterRepository.listCharactersFilterByName(name);
        List<CharacterStarWarsDTO> characterDTOList = new ArrayList<>();

        for (CharacterStarWars character: characterList) {

            CharacterStarWarsDTO characterDTO =
                    new CharacterStarWarsDTO(
                            character.getName(),
                            character.getGender(),
                            character.getHome_world(),
                            character.getSpecies(),
                            character.getHeight(),
                            character.getMass());

            characterDTOList.add(characterDTO);
        }

        return characterDTOList;
    }
}
