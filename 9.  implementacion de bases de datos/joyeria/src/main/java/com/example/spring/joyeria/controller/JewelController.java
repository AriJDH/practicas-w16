package com.example.spring.joyeria.controller;

import com.example.spring.joyeria.entity.Jewel;
import com.example.spring.joyeria.service.IJewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JewelController {

    @Autowired
    private IJewelService service;

    @PostMapping("/jewerly/new")
    public ResponseEntity<String> createJewerly(@RequestBody Jewel jewel){
        service.saveJewel(jewel);
        return new ResponseEntity<>("La joya fue agregado correctamente.", HttpStatus.CREATED);
    }

    @GetMapping("/jewerly")
    public List<Jewel> getJewelry(){
        return service.getJewelry();
    }
    @PostMapping("/jewerly/delete/{id}")
    public ResponseEntity<String> deleteJewel(@PathVariable long id){
        service.deleteJewel(id);
       return new ResponseEntity<>("La joya fue eliminada correctamente.", HttpStatus.OK);
    }

    @PostMapping("/jewerly/update/{id}")
    public Jewel editJewel(@PathVariable long id,
                               @RequestParam("name") String newName,
                               @RequestParam("material") String newMaterial,
                               @RequestParam("weight") Double newWeight,
                               @RequestParam("particularity") String newParticularity,
                               @RequestParam("jewel_stone") boolean jewel_stone,
                               @RequestParam("forSale") boolean forSale){
        Jewel jewel = service.findJewel(id);
        jewel.setName(newName);
        jewel.setMaterial(newMaterial);
        jewel.setWeight(newWeight);
        jewel.setParticularity(newParticularity);
        jewel.setJewel_stone(jewel_stone);
        jewel.setForSale(forSale);

        service.saveJewel(jewel);
        return jewel;
    }
}
