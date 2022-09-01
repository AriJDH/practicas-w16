package com.bootcamp.demo.controller;

import com.bootcamp.demo.model.Jewel;
import com.bootcamp.demo.service.IJewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    public IJewelService jewelServ;

    @PostMapping("/jewelry/new")
    public String addJewel(@RequestBody Jewel jewel){
        jewelServ.saveJewel(jewel);
        return "se ha añadido la joya con el número identificatorio " + jewel.getNro_identificatorio();
    }

    @GetMapping("/jewelry")
    public List<Jewel> getJewels(){
        return jewelServ.getJewels();
    }

    @PostMapping("/jewelry/delete/{id}")
    public String deleteJewel (@PathVariable long id){
        Jewel jew = jewelServ.findJewel(id);
        if (!jew.isVentaONo()){
            jewelServ.deleteJewel(id);
            return "la joya fue eliminada correctamente";
        }
        else{
            return "La joya no se ha podido eliminar";
        }
    }

    @PostMapping("/jewelry/update/{id}")
    public Jewel editStudent (@PathVariable long id,
                              @RequestParam ("nombre") String newName,
                              @RequestParam ("material") String newMaterial,
                              @RequestParam ("particularidad") String newParticularidad,
                              @RequestParam ("posee_piedra") boolean newPiedra,
                              @RequestParam ("ventaONo") boolean newVentaONo) {
        Jewel jew = jewelServ.findJewel(id);
        jew.setNombre(newName);
        jew.setMaterial(newMaterial);
        jew.setParticularidad(newParticularidad);
        jew.setPosee_piedra(newPiedra);
        jew.setVentaONo(newVentaONo);
        jewelServ.saveJewel(jew);
        return jew;
    }
}
