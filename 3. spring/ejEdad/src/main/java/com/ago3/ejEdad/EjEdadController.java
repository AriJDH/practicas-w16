package com.ago3.ejEdad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
public class EjEdadController {
    EjEdadService service = new EjEdadService();

    @GetMapping(path = "/edad/{dia}/{mes}/{anio}")
    public String getEdadPersona(@PathVariable int dia,
                                 @PathVariable int mes,
                                 @PathVariable int anio) {
        return service.calcularEdad(dia, mes, anio);
    }
}
