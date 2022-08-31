package com.example.joyerialp.controller;

import com.example.joyerialp.model.Jewerly;
import com.example.joyerialp.service.IJewerlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private IJewerlyService jewerlyServ;

    @GetMapping("/jewerly")
    public List<Jewerly> getJewerlys() {

        List<Jewerly> res = jewerlyServ.getJewerlys();
        return res;
    }

    @GetMapping("/jewerly/{nro_identificador}")
    public Jewerly getJewerly(@PathVariable Long nro_identificador) {

        Jewerly res = jewerlyServ.findJewerly(nro_identificador);
        return res;
    }

    @PostMapping("/jewerly/delete2/{nro_identificador}")
    public String delete2Jewerly(@PathVariable Long nro_identificador) {

        jewerlyServ.delete2Jewerly(nro_identificador);
        return "La joyeria fue borrada correctamente con nro_identificador: " + nro_identificador;
    }

    @PostMapping("/jewerly/delete/{nro_identificador}")
    public String deleteJewerly(@PathVariable Long nro_identificador) {

        jewerlyServ.deleteJewerly(nro_identificador);
        return "La joyeria fue borrada correctamente con nro_identificador: " + nro_identificador;
    }

    @PostMapping("/jewerly/new")
    public String saveJewerly(@RequestBody Jewerly body) {

        jewerlyServ.saveJewerly(body);
        return "La joyeria fue creada correctamente";
    }

    @PostMapping ("/jewerly/update/{nro_identificador}")
    public Jewerly editJewerly(@PathVariable long nro_identificador, @RequestBody Jewerly body) {
        var res = jewerlyServ.updateJewerly(nro_identificador, body);
        return res;
    }
}
