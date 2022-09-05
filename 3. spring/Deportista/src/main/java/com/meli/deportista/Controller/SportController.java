package com.meli.deportista.Controller;

import com.meli.deportista.Dto.SportDto;
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

    @GetMapping("/get")
    public ResponseEntity<List<SportDto>> getSports() {
        return new ResponseEntity<>(sportService.getSports(), HttpStatus.OK);
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<SportDto> getByName(@PathVariable String name) {
        return new ResponseEntity<>(sportService.getByName(name), HttpStatus.OK);
    }
}
