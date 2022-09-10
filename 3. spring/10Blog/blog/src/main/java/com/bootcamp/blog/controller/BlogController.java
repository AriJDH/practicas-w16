package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.dto.MensajeDTO;
import com.bootcamp.blog.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BlogController {

    @Autowired
    IBlogService iBlogService;

    @PostMapping("/blog")//para crear segun parametros
    public ResponseEntity<MensajeDTO> crearBlog(@RequestBody BlogDTO crearBlogDto){//el requestBody es el json de entrada. ResponseEntity para responder entidad
        return new ResponseEntity<>(iBlogService.crearBlog(crearBlogDto), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")//recibo id para buscar
    public ResponseEntity<BlogDTO> getBlog(@PathVariable String id){
      // /id/nombre/apellido/edad mejor es @PathVariable
      //  /id?nombre=yennh&apellido=marrerp  es @RequestParam
        return new ResponseEntity<>(iBlogService.buscarBlogById(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")//recibo id para buscar
    public ResponseEntity<List<BlogDTO>> listaBlog(){

        return new ResponseEntity<>(iBlogService.buscarListaBlog(), HttpStatus.OK);
    }

}
