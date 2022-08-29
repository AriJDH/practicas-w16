package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * Ejercicio > Modulo 12: Testing > EjercitandoUnitTestsEIntegrationTests-PG
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
@RestController
public class CalculateRestController {
    @Autowired
    CalculateService calculateService;

    @PostMapping("/calculate")
    public HouseResponseDTO calculate(@RequestBody HouseDTO house) {
        return calculateService.calculate(house);
    }
}
