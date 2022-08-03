package com.grodriguez.edadPersona;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static java.util.Calendar.*;

@RestController
public class EdadPersonaController {

    DateService dateService = new DateService();

    @GetMapping("/{dia}/{mes}/{anio}")
    public int getEdad(@PathVariable int dia,
                   @PathVariable int mes,
                   @PathVariable int anio)
    {
        int diff = dateService.getDiff(dia,mes,anio);
        return diff;
    }
}
