package com.persona.persona;

import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @GetMapping("/{day}/{month}/{year}")
    public String getAge(@PathVariable("day") int day, @PathVariable("month") int month, @PathVariable("year") int year) {
        int age = 0;
        if (month < Calendar.getInstance().get(Calendar.MONTH) + 1) {
            age = Calendar.getInstance().get(Calendar.YEAR) - year - 1;
        } else if (month == Calendar.getInstance().get(Calendar.MONTH) + 1 && day <= Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) {
            age = Calendar.getInstance().get(Calendar.YEAR) - year - 1;
        } else {
            age = Calendar.getInstance().get(Calendar.YEAR) - year;
        }
        return "La edad es: " + age;
    }
}
