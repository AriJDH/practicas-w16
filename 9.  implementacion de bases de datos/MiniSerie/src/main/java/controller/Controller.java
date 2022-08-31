package controller;

import entity.MiniSerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.Iservice;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {



    @Autowired
    private Iservice service;

    @GetMapping("/students")
    public List<MiniSerie> getMiniSeries () {

        List<MiniSerie> seriesList = service.getMiniseries();
        return seriesList;

    }

    @PostMapping("/create")
    public String createMiniSerie(@RequestBody MiniSerie miniSerie) {
        service.saveMiniSerie(miniSerie);
        return "OK";
    }

    //acá también puedo poner un objeto y lo relaciona a la id
    // (si se llaman igual ambos parámetros)
    @PostMapping("delete/{id}")
    public String deleteMiniSerie(@PathVariable long id) {
        service.deleteMiniSerie(id);
        return "OK";
    }

    @PostMapping ("edit/{id}")
    public MiniSerie editStudent (@PathVariable long id,
                                @RequestParam("name") String newName) {
        MiniSerie miniSerie = service.findMiniserie(id);
        //esto puede ir en el service
        miniSerie.setName(newName);
        service.saveMiniSerie(miniSerie);
        return miniSerie;
    }
}
