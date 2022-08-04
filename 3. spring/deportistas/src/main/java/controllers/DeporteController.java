package controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import services.DeporteService;
import dto.DeporteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController
public class DeporteController {
    @Autowired
    private DeporteService servicio;

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports() {
        List<DeporteDTO> deportes = servicio.obtenerDeportes();
        return new ResponseEntity<>(deportes, HttpStatus.ACCEPTED);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<DeporteDTO> findSportByName(@PathVariable String name){
        return new ResponseEntity<>(servicio.obtenerDeporteXNombre(name), HttpStatus.ACCEPTED);
    }

}
