package com.practice.practiceDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/api")
public class ControllerCalculateAge {

    @GetMapping("/{day}/{month}/{year}")
    public int calculate(@PathVariable int day, @PathVariable int month, @PathVariable int year) {

        LocalDate dateBirthday = LocalDate.of(year,month,day);
        Period period = Period.between(dateBirthday, LocalDate.now());

        return period.getYears();
    }

}
