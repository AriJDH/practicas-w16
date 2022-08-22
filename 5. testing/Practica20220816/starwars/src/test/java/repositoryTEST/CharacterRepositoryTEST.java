package repositoryTEST;

import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CharacterRepositoryTEST {
    @Autowired
    CharacterRepository irepo = new CharacterRepositoryImpl();


    @Test
    public void characterLoad(){
        //Assertions.assertEquals(irepo.);
    }
}
