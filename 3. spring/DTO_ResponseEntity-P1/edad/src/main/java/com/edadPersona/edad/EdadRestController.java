package com.edadPersona.edad;


import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


@RestController
public class EdadRestController {

    @GetMapping("/{day}/{month}/{year}")

    public int calcularEdad(@PathVariable int day,
                            @PathVariable int month,
                            @PathVariable int year) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.parse(dtf.format(LocalDate.now()) , dtf);

        String mes = String.valueOf(month);
        if (month<10){
            mes = "0"+mes;
        }
        String dia = String.valueOf(day);
        if (day<10){
            dia = "0"+dia;
        }
        LocalDate birthday = LocalDate.parse(dia+"/"+mes+"/"+String.valueOf(year), dtf);

        Period period = Period.between(birthday, today);
        int age = Math.abs(period.getYears());

        return age;
    }

}
