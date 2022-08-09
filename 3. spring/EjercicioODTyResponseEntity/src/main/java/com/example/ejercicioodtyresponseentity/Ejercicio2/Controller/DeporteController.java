package com.example.ejercicioodtyresponseentity.Ejercicio2.Controller;
import com.example.ejercicioodtyresponseentity.Ejercicio2.Entity.Deporte;
import com.example.ejercicioodtyresponseentity.Ejercicio2.Service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class DeporteController {
    @Autowired
    private DeporteService deporteService;

    @GetMapping("/Deporte/{nombreDeporte}/{nivelDeporte}")
    public ResponseEntity<Deporte> addDeporte(@PathVariable String nombreDeporte, @PathVariable String nivelDeporte) {
        return new ResponseEntity<>(this.deporteService.addDeporte(nombreDeporte, nivelDeporte), HttpStatus.OK);
    }
    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> showDeportes(){
        return  new ResponseEntity<>(this.deporteService.showDeportes(),HttpStatus.OK);
    }

    @GetMapping("/findSports/{nombreDeporte}")
    public ResponseEntity<String> showDeportesName(@PathVariable String nombreDeporte){
        return new ResponseEntity<>(this.deporteService.showDeportesNameService(nombreDeporte),HttpStatus.OK);
    }


}
