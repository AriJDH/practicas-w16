package com.example.numerosromanos.Controller;

import com.example.numerosromanos.Service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/NumerosRomanos")
public class Controller {

    @GetMapping(path = "/{numero}")
    public String numerosRomanos(@PathVariable int numero) {
        Service s = new Service();
        return s.numerosRomanos(numero);
    }
}
