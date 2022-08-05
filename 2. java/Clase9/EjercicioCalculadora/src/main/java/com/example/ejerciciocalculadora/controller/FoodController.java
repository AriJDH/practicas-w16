package com.example.ejerciciocalculadora.controller;

import com.example.ejerciciocalculadora.dto.FoodDTO;
import com.example.ejerciciocalculadora.model.Plato;
import com.example.ejerciciocalculadora.service.Calculadora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {
    @Autowired
    Calculadora calculadora;
    @GetMapping("/")
    public ResponseEntity<List<FoodDTO>> getFood(){

        return new ResponseEntity<>(calculadora.getFood(),HttpStatus.OK);
    }
    @GetMapping("/plato/{nombre}")
    public ResponseEntity<Plato> getPlato(@PathVariable String nombre){

        return new ResponseEntity<>(calculadora.getPlato(nombre),HttpStatus.OK);
    }
    @GetMapping("/menuMax/{plato}")
    public ResponseEntity<String> maxCalorias(@PathVariable String plato){

        return new ResponseEntity<>("el maximo de calorias es"+calculadora.maximoIngrdiente(plato),HttpStatus.OK);
    }

    @GetMapping("/menuTotal/{plato}")
    public ResponseEntity<Integer> sumaDeCalorias(@PathVariable String plato){

        return new ResponseEntity<>(calculadora.totalCalorias(plato),HttpStatus.OK);
    }

    @GetMapping("/menuIngredientes/{plato}")
    public ResponseEntity<List<FoodDTO>> listaIngredientes(@PathVariable String plato){

        return new ResponseEntity<>(calculadora.listaIngredientes(plato),HttpStatus.OK);
    }

    @GetMapping("/platos")
    public ResponseEntity<List<String>> listaIngredientes(@RequestBody List<String> plato){
        System.out.println(plato);

        return new ResponseEntity<>(calculadora.listaTotalDeCalorias(plato),HttpStatus.OK);
    }

    @GetMapping("/platosMaxCalorias")
    public ResponseEntity<List<String>> listaMaxCalorias(@RequestBody List<String> plato){

        return new ResponseEntity<>(calculadora.listaMaximaCalorias(plato),HttpStatus.OK);
    }


    @GetMapping("/platosingre")
    public ResponseEntity<List<String>> listaIngredientosTotales(@RequestBody List<String> plato){

        return new ResponseEntity<>(calculadora.listaDeIngredientes(plato),HttpStatus.OK);
    }
}
