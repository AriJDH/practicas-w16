package com.example.ejercicio1;

import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

    @RestController
    public class EdadPersonaRestController {

        @GetMapping("/{dia}/{mes}/{anio}")
        public String calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){

            try{
                Period edad = Period.between(LocalDate.of(anio, mes, dia), LocalDate.now());
                String retorno = "Tienes "+edad.getYears()+" años, "+edad.getMonths()+" meses y "+edad.getDays()+" dias.";
                return retorno;
            }catch (Exception e){
                e.printStackTrace();
                return "valor incorrecto";
            }
        }
        @GetMapping("pepe/{dia}/{mes}/{anio}")
        @ResponseBody
            public ResponseEntity<EdadDTO> calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){

            try{
                Period edad = Period.between(LocalDate.of(anio, mes, dia), LocalDate.now());
                //String retorno = "Tienes "+edad.getYears()+" años, "+edad.getMonths()+" meses y "+edad.getDays()+" dias.";
                EdadDTO year= new EdadDTO(edad.getYears());
                return new ResponseEntity<>(year,HttpStatus.OK);
            }catch (Exception e){
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }

