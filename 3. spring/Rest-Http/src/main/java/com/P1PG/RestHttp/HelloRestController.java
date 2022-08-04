package com.P1PG.RestHttp;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloRestController {

    @GetMapping(path = "{name}/{lastname}/{age}")
public String sayHello(@PathVariable String name,
                       @PathVariable String lastname,
                       @PathVariable Integer age){
return ("Hola " + name + " " +lastname + " " + age);
    }

    @GetMapping(path = "user/{userId}")
    public String getUser(@PathVariable("userId") String userId){
        return ("Hola " + userId);
    }

    @GetMapping(path = "/student")
    public String sayHello(@RequestParam String name,
                           @RequestParam String lastname){
        return ("Hola " + name + " " +lastname);
    }

    /* @PostMapping(path = "/employee")
    public String newEmployee(@RequestBody Employee employee){
        //mi codigo para agregar nuevo empleado. Tengo que tener creada la clase Employee
    }*/
}
