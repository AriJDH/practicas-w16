package com.example.codigomorse.Controller;

import com.example.codigomorse.Service.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CodigoMorse")
public class Controller {

    @GetMapping("/{original}")
    public String codigoMorse(@PathVariable String original){
        Service s = new Service();
        return  s.decodificarMorse(original);
    }
}
