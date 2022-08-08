package com.meli.linktracker.controller;


import com.meli.linktracker.dto.LinkDto;
import com.meli.linktracker.repository.UrlRepository;
import com.meli.linktracker.service.UrlService;
import com.meli.linktracker.entity.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class LinkTrackerController {
@Autowired
UrlService urlService;
@Autowired
UrlRepository urlRepository;





    @PostMapping("/crearUrl")
    public ResponseEntity crearUrl(@RequestParam String url)
    {

        if(urlService.validarUrl(url))
        {

            Link link = new Link(urlService.generateId(),url);
            LinkDto linkDto= new LinkDto(link.getId(),link.getUrl(),0);
            System.out.println(link);
            System.out.println(linkDto);
            urlRepository.agregarLink(linkDto);

            return ResponseEntity.ok(linkDto.getId());

        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);


    }


    @GetMapping("/redireccion/{id}")
    public void redireccion(@PathVariable int id, HttpServletResponse response) throws IOException {


        urlRepository.addSolicitudes(id);
        response.sendRedirect(urlRepository.getUrl(id));

    }


    @GetMapping("/estadisticas/{id}")
    public ResponseEntity getEstadisticas(@PathVariable int id)
    {
        return ResponseEntity.ok(urlRepository.getLink(id));
    }



}
