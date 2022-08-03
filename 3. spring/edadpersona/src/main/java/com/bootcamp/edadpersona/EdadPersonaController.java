package com.bootcamp.edadpersona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edad")
public class EdadPersonaController {
        @Autowired
        private EdadService edadService;

        @GetMapping("/{dia}/{mes}/{anio}")
        public String edadPersona(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){
            return edadService.edadPersona(dia, mes, anio);
        }


}
