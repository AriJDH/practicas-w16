package com.romanos.romanos;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.romanos.util.Romanos;

@RestController
public class romanoRestController {
    
    @GetMapping("/toRoman/{number}")
    public String toRoman(@PathVariable String number) {
        
        return "Your number in roman : " + Romanos.toRoman(Integer.valueOf(number));
    }
}
