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






    @PostMapping("/crearUrl")
    public ResponseEntity crearUrl(@RequestParam String url)
    {

        return ResponseEntity.ok(urlService.crearUrl(url).getId());


    }


    @GetMapping("/redireccion/{id}")
    public void redireccion(@PathVariable int id, HttpServletResponse response) throws IOException {


        urlService.addSolicitudes(id);
        response.sendRedirect(urlService.getUrl(id));

    }


    @GetMapping("/estadisticas/{id}")
    public ResponseEntity getEstadisticas(@PathVariable int id)
    {
        return ResponseEntity.ok(urlService.getLink(id).getSolicitudes());
    }




    @PostMapping("/invalidate/{id}")
    public void invalidateLink(@PathVariable int  id)
    {
        urlService.invalidateLink(id);
    }


    @GetMapping("/estado/{id}")
    public ResponseEntity getEstado(@PathVariable int id)
    {
        return ResponseEntity.ok(urlService.getLink(id));
    }

    


}
