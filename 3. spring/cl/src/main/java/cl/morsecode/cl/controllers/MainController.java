package cl.morsecode.cl.controllers;

import cl.morsecode.cl.dto.MainDTO;
import cl.morsecode.cl.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private MainService mainService;

    @PostMapping
    public String holaMundo(@RequestBody MainDTO mainDTO){
        return mainService.decodificarMorse(mainDTO.getMessage());
    }

}
