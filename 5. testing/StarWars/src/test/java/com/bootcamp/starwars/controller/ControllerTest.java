package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.PersonajeDTO;
import com.bootcamp.starwars.service.Servicio;
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
public class ControllerTest {

        @Mock
        private Servicio mockServicio;

        @InjectMocks
        private Controller controller;

        @Test
        void shouldFindCharacterByName() {
            //Arrange
            String query = "Darth";
            PersonajeDTO character1 = new PersonajeDTO();
            character1.setName("Darth Vader");
            character1.setHair_color("Brown");

            PersonajeDTO character2 = new PersonajeDTO();
            character2.setName("Darth Maul");
            character2.setHair_color("Black");

            List<PersonajeDTO> characterList = Arrays.asList(character1, character2);
            when(mockServicio.listarPersonajes(query)).thenReturn(characterList);

            //Act
            List<PersonajeDTO> result = controller.parsearPersonajes(query);

            //Assert
            assertEquals(result.size(), 2);
            assertEquals(result.get(0).getName(), "Darth Vader");
            verify(mockServicio, atLeastOnce()).listarPersonajes(query);
        }
}

