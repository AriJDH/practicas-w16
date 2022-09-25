package com.bootcamp.elastic.Controller;

import com.bootcamp.elastic.DTO.ObraDTO;
import com.bootcamp.elastic.service.IObraService;
import org.elasticsearch.search.rescore.RescorePhase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/obras")
public class ObraController {
    @Autowired
    IObraService iObraService;

    @PostMapping("/new")
    public ResponseEntity<String> saveObre(@RequestBody ObraDTO obraDTO){
        return new ResponseEntity<>(iObraService.saveObra(obraDTO), HttpStatus.OK);
    }

    @GetMapping("/byautor/{autor}")
    public ResponseEntity<?> getAllByAutor(@PathVariable String autor){
        return new ResponseEntity<>(iObraService.findByAutor(autor), HttpStatus.OK);
    }

}
