package com.example.link.controller;

import com.example.link.dto.CreateLinkDto;
import com.example.link.dto.ResponseCreateLinkDto;
import com.example.link.service.ILinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/api")
public class LinkController {

    private final ILinkService linkService;


    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping()
    public EntityResponse<ResponseCreateLinkDto> createLink(@RequestBody CreateLinkDto createLinkDto){
        return new ResponseEntity<>(res)
    }
}
