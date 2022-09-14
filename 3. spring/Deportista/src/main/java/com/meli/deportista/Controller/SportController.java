package com.meli.deportista.Controller;

import com.meli.deportista.Dto.SportDto;
import com.meli.deportista.Dto.SportPeopleDto;
import com.meli.deportista.Service.ISportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sport")
public class SportController {

    @Autowired
    private ISportService sportService;

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDto>> getSports() {
        return new ResponseEntity<>(sportService.getSports(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<SportDto> getByName(@PathVariable String name) {
        return new ResponseEntity<>(sportService.getByName(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportPeopleDto>> findSportsPersons() {
        return new ResponseEntity<>(sportService.findSportsPersons(), HttpStatus.OK);
    }
}
