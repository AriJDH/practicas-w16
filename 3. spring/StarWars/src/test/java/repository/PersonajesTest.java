package repository;

import com.bootcamp.starwars.dto.PersonajeDTO;
import com.bootcamp.starwars.repository.Personajes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonajesTest {

    @Mock
    private Personajes mockPersonajes;

    @Test
    void loadCharacters(){
        //Arrange
        String query = "Boba Fett";
        PersonajeDTO character1 = new PersonajeDTO();
        character1.setName("Boba Fett");
        character1.setEye_color("brown");

        PersonajeDTO character2 = new PersonajeDTO();
        character2.setName("Jango Fett");
        character2.setEye_color("brown");

        List<PersonajeDTO> characterList = Arrays.asList(character1, character2);
        when(mockPersonajes.encontrarPersonajes(query)).thenReturn(characterList);

        //Act
        List<PersonajeDTO> result = mockPersonajes.encontrarPersonajes(query);

        //Assert
        assertEquals(result.size(), 2);
        assertEquals(result.get(0).getName(), "Boba Fett");
        assertEquals(result.get(1).getName(), "Jango Fett");
        verify(mockPersonajes, atLeastOnce()).encontrarPersonajes(query);
    }


}
