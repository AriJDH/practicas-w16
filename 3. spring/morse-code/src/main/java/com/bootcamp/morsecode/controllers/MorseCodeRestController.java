package com.bootcamp.morsecode.controllers;

import com.bootcamp.morsecode.services.MorseCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseCodeRestController {
    MorseCodeService mcService = new MorseCodeService();

    @GetMapping("/{morse}")
    public String morse2Text(@PathVariable String morse){
        return mcService.morse2Text(morse);
    }
}
