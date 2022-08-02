package com.morse.morse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.morse.util.Morse;

@RestController
public class MorseRestController {
    
    @GetMapping("/translateMorse/")
    public String getMorse(@RequestParam String text) {
        return Morse.translateMorse(text);
    }
    
}
