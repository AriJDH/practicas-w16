package serviceTEST;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FindServiceTEST {

    @Autowired
    CharacterRepositoryImpl irepo = new CharacterRepositoryImpl();

    FindService service = new FindService(irepo);

    @Test
    public void foundCharacter(){
        List<CharacterDTO> cha = service.find("Luke");
        Assertions.assertEquals(1, cha.size());
    }

    @Test
    public void foundNotCharacter(){
        List<CharacterDTO> cha = service.find("PersojaArgento");
        Assertions.assertEquals(0, cha.size());
    }
}
