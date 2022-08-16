package repositories;


import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterRepositoryImplTest {

    @Autowired
    private CharacterRepositoryImpl characterRepository;

    private List<CharacterDTO> dataBase;

    @BeforeEach
    void setUp() {
        characterRepository = new CharacterRepositoryImpl();
        dataBase = new ArrayList<>();
    }

    @Test
    void shouldFindAllByNameContains() {
        String query = "Luke";
        List<CharacterDTO> result =  characterRepository.findAllByNameContains(query);
        assertEquals(result.size(),1);
    }
}
