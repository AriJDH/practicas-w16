package com.example.apistarwars.Service;

import com.example.apistarwars.Dto.CharacterDTO;
import com.example.apistarwars.Entity.Character;
import com.example.apistarwars.Repository.CharacterRepository;
import com.example.apistarwars.Repository.ICharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private final ICharacterRepository characterRepository;

    public CharacterService(ICharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }


    public List<CharacterDTO> getAllCharacter(){
        return characterRepository.getAllCharacter();
    }

    public List<CharacterDTO> getCharacterByName(String name){
        return characterRepository.getCharacterByName(name);
    }

}
