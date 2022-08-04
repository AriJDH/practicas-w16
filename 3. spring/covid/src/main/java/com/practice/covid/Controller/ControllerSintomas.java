package com.practice.covid.Controller;

import com.practice.covid.DTO.GravedadSintomaDTO;
import com.practice.covid.DTO.ListSintomasDTO;
import com.practice.covid.Service.ServiceSintomas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControllerSintomas {

    @Autowired
    ServiceSintomas serviceSintomas;
    
    @GetMapping("/findSymptom")
    public ResponseEntity<ListSintomasDTO> findSymptom() {
        ListSintomasDTO result = serviceSintomas.findSymptom();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<GravedadSintomaDTO> findSymptomByName(@PathVariable String name) {
        GravedadSintomaDTO result = serviceSintomas.findSymptomByName(name);

        return result.getGravedad() != null ? new ResponseEntity<>(result, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
