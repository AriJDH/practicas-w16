package UnitsTest;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerUnitTest {

    @Mock
    CalculateService calculateService;

    @InjectMocks
    CalculateRestController calculateRestController;

    private final HouseDTO house = new HouseDTO();
    private final RoomDTO room1 = new RoomDTO();
    private final RoomDTO room2 = new RoomDTO();

    @BeforeEach
    public void setUp() {
        room1.setName("room1");
        room1.setWidth(2);
        room1.setLength(3);

        room2.setName("room2");
        room2.setWidth(3);
        room2.setLength(4);

        house.setName("Casa Mariana");
        house.setAddress("Carrera 76");
        house.setRooms(Arrays.asList(room1, room2));
    }

    @Test
    public void calculateRestControllerTest() {

        HouseResponseDTO houseResponse = new HouseResponseDTO(house);
        houseResponse.setBiggest(room2);
        houseResponse.setPrice(14400);
        houseResponse.setSquareFeet(18);

        when(calculateService.calculate(house)).thenReturn(houseResponse);

        HouseResponseDTO response = calculateRestController.calculate(house);

        Assertions.assertEquals(houseResponse.getPrice(), response.getPrice());
    }
}
