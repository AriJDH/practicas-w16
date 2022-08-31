package UnitsTest;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceUnitTest {

  private final HouseDTO house = new HouseDTO();
  private final RoomDTO room1 = new RoomDTO();
  private final RoomDTO room2 = new RoomDTO();

  private CalculateService calculateService;

  @BeforeEach
  public void setUp() {

    calculateService = new CalculateService();

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
  public void calculateCostProperty() {

    HouseResponseDTO result = calculateService.calculate(house);

    Assertions.assertEquals(14400, result.getPrice());
  }

  @Test
  public void calculateMoreBigRoom() {

    HouseResponseDTO result = calculateService.calculate(house);

    Assertions.assertEquals(room2, result.getBiggest());
  }

  @Test
  public void calculateCountSquareMeter() {

    HouseResponseDTO result = calculateService.calculate(house);

    Assertions.assertEquals(18, result.getSquareFeet());
  }
}
