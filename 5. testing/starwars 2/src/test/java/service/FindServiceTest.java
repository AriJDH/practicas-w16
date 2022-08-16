package service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    private CharacterRepository mockCharacterRepository;

    @InjectMocks
    private FindService findService;

    @Test
    void findOneByName() {
        String query = "Luke";

        CharacterDTO characterDTO1 = new CharacterDTO();
        characterDTO1.setName("Luke Skywalker");
        characterDTO1.setHair_color("blond");

        CharacterDTO characterDTO2 = new CharacterDTO();
        characterDTO2.setName("Luke Floorwalker");
        characterDTO2.setHair_color("black");

        List<CharacterDTO> characterDTOList = Arrays.asList(characterDTO1, characterDTO2);

        when(mockCharacterRepository.findAllByNameContains(query)).thenReturn(characterDTOList);

        List<CharacterDTO> result = findService.find(query);

        assertEquals(result.size(),2);
    }
}
