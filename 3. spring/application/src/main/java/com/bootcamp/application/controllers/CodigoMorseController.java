package com.bootcamp.application.controllers;

import com.bootcamp.application.services.CodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {
    @Autowired
    private CodigoMorseService codigoMorseService;

    @GetMapping("/codigoMorse/{palabra}")
    public String traducir(@PathVariable String palabra) {
        return "<head>" +
                "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css\" integrity=\"sha384-yHIFVG6ClnONEA5yB5DJXfW2/KC173DIQrYoZMEtBvGzmf0PKiGyNEqe9N6BNDBH\" crossorigin=\"anonymous\">" +
                "<style>" +
                "body{" +
                "background-color: #FFF059;" +
                "margin: 0;" +
                "padding: 0;" +
                "display: flex;" +
                "align-items: center;" +
                "justify-content: center" +
                "}" +
                "h1{" +
                "text-align: center;" +
                "}" +
                "code{" +
                "font-size: 0.8em;\n" +
                "background-color: #e7e7e7;\n" +
                "padding: 4px 4px;\n" +
                "border-radius: 5px;"+
                "}" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class=\"splash-container\">\n" +
                "    <div class=\"splash\">\n" +
                "        <h1 class=\"splash-head\">Traductor código morse:</h1>\n" +
                "        <p class=\"splash-subhead\">\n" +
                String.format("La traducción para <code>%s</code> es: %s.\n", palabra, codigoMorseService.getTraduccion(palabra)) +
                "        </p>\n" +
                "    </div>\n" +
                "</div>" +
                "</body>";
    }
}
