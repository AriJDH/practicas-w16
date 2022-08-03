package cl.morsecode.cl.controllers;

import cl.morsecode.cl.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/romanos")
public class RomanosController {

    @Autowired
    MainService mainService;

    @GetMapping("/{numero}")
    public String getRomano(@PathVariable int numero){
        return mainService.decodificarRomano(numero);
    }
}
