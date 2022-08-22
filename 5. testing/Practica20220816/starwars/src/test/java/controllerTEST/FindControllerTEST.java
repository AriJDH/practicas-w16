package controllerTEST;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@ExtendWith(MockitoExtension.class)
public class FindControllerTEST {

    /*@Autowired
    CharacterRepositoryImpl repo = new CharacterRepositoryImpl();
*/
    @Mock
    FindService findService;
    @InjectMocks
    FindController controller;

    @Test
    public void findCharacter(){
        List<CharacterDTO> buscado = controller.find("Luke");
        System.out.println(buscado.size());
        Assertions.assertEquals(0,buscado.size());
    }
}
