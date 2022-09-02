package com.example.joyeriameli.controller;

import com.example.joyeriameli.dto.MessageDto;
import com.example.joyeriameli.model.Joya;
import com.example.joyeriameli.service.IJoyaService;
import com.example.joyeriameli.service.JoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joya")
public class JoyaController {
    @Autowired
    private IJoyaService joyaService;

    @PostMapping("/jewerly/new")
    public ResponseEntity<MessageDto> createJoya(@RequestBody Joya joya) {
        return new ResponseEntity<>(joyaService.saveJoya(joya),HttpStatus.OK);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<Joya>> getJoya(){
        return new ResponseEntity<>(joyaService.getJoya(), HttpStatus.OK);
    }

    @PostMapping("/jewerly/deleterow/{id}")
    public ResponseEntity<MessageDto> deleteJoya(@PathVariable Long id) {
        return new ResponseEntity<>(joyaService.deleteJoya(id),HttpStatus.OK);
    }

    @PostMapping("/jewerly/find/{id}")
    public ResponseEntity<MessageDto> findJoya(@PathVariable Long id) {
        return new ResponseEntity<>(joyaService.findJoya(id),HttpStatus.OK);
    }
    @PostMapping("/jewerly/delete/{id}")
    public ResponseEntity<MessageDto> deleteJoyaLogic(@PathVariable Long id) {
        return new ResponseEntity<>(joyaService.deleteJoyaLogic(id),HttpStatus.OK);
    }

    @PostMapping("/jewerly/update/{id_modificar}")
    public ResponseEntity<MessageDto> editJoya(@PathVariable long id_modificar,
                               @RequestParam("nombre") String newName,
                               @RequestParam ("peso") Long newPeso) {
        return new ResponseEntity<>(joyaService.updateJoya(id_modificar,newName,newPeso),HttpStatus.OK);
    }
}
