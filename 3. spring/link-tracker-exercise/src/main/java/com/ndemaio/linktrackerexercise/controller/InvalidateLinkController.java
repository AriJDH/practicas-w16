package com.ndemaio.linktrackerexercise.controller;

import com.ndemaio.linktrackerexercise.dto.InformativeMessage;
import com.ndemaio.linktrackerexercise.service.InvalidateLinkService;
import com.ndemaio.linktrackerexercise.exception.LinkNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/invalidate")
public class InvalidateLinkController {

    private final InvalidateLinkService invalidateLinkService;

    @Autowired
    public InvalidateLinkController(InvalidateLinkService invalidateLinkService){
        this.invalidateLinkService = invalidateLinkService;
    }

    @PostMapping(path = "/{id}")
    public ResponseEntity invalidate(@PathVariable UUID id) throws LinkNotFoundException {
        invalidateLinkService.invalidateLinkById(id);
        return ResponseEntity.ok(new InformativeMessage("Link invalidado correctamente."));
    }

}
