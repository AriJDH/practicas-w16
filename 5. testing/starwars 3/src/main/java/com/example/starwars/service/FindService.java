package com.example.starwars.service;

import com.example.starwars.exception.CharacterNotFoundException;
import com.example.starwars.model.Character;
import com.example.starwars.repositories.ICharacterRepository;
import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.utils.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindService implements IFindService {
    private final ICharacterRepository characterRepository;
    private final ModelMapper          mapper;

    public FindService ( ICharacterRepository characterRepository ) {
        this.characterRepository = characterRepository;
        mapper                   = new ModelMapper();
    }

    @Override
    public List<CharacterDTO> find ( String query ) {
        List<Character> characters = characterRepository.findAllByNameContains(query);

        List<CharacterDTO> characterDTOS = characters.stream()
//          .map(character -> {
//              CharacterDTO characterDTO = mapper.map(character, CharacterDTO.class);
//              Character    otrosDatos   = character;
//              Character    otroModel    = character;
//              mapper.map(otrosDatos, characterDTO);
//              mapper.map(otroModel, characterDTO);
//              return characterDTO;
//
//          })
      .map(Mapper::DTOFromCharacter)
          .collect(Collectors.toList());

        if (characterDTOS.isEmpty()) {
            //lanzar exception - CharacterNotFoundException
            throw new CharacterNotFoundException(query);
        }

        return characterDTOS;
    }
}
