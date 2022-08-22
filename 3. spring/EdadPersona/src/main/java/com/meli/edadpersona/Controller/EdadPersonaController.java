package com.meli.edadpersona.Controller;

import com.meli.edadpersona.Service.EdadPersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Edad")
public class EdadPersonaController {

    EdadPersonaService edadPersonaService = new EdadPersonaService();

    @GetMapping("/{day}/{month}/{year}")
    public Integer calcular(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        return edadPersonaService.calcularEdad(day, month, year);
    }

}
