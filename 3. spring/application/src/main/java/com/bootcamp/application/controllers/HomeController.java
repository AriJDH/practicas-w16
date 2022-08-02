package com.bootcamp.application.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String getHome(){
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
                "h1{text-align:center}" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class=\"splash-container\">\n" +
                "    <div class=\"splash\">\n" +
                "        <h1 class=\"splash-head\">Home:</h1>\n" +
                "        <p class=\"splash-subhead\">\n" +
                "<p>Acciones posibles:<p>" +
                "<ul>" +
                "<li> Romanizar números: <a href='/romanizar/123'>Ejemplo</a></li>" +
                "<li> Traductor código morse: <a href='/codigoMorse/-- . .-. -.-. .- -.. ---   .-.. .. -... .-. .'>Ejemplo</a></li>" +
                "</ul>" +
                "        </p>\n" +
                "    </div>\n" +
                "</div>" +
                "</body>";
    }
}
