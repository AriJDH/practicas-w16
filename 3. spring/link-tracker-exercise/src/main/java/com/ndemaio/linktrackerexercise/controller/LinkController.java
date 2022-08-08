package com.ndemaio.linktrackerexercise.controller;

import com.ndemaio.linktrackerexercise.dto.InformativeMessage;
import com.ndemaio.linktrackerexercise.dto.LinkDTORequest;
import com.ndemaio.linktrackerexercise.dto.LinkDTOResponse;
import com.ndemaio.linktrackerexercise.exception.LinkNotFoundException;
import com.ndemaio.linktrackerexercise.service.LinkService;
import com.ndemaio.linktrackerexercise.exception.LinkUnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping (path = "/link")
public class LinkController {

    private final LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService){
        this.linkService = linkService;
    }

    @PostMapping
    public ResponseEntity createLink(@RequestBody LinkDTORequest linkDTORequest) throws MalformedURLException {
        LinkDTOResponse createdLink = linkService.createLinkBasedOn(linkDTORequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLink);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity redirectTo(@PathVariable UUID id, @RequestParam String password) throws LinkNotFoundException, LinkUnauthorizedException {
        LinkDTOResponse link = linkService.getLinkByIdIfMatchesPassword(id, password);
        if (link.getIsValid()) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(link.getUrl()));
            linkService.processRedirectTo(link);
            return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new InformativeMessage("Url no vàlida"));
        }
    }

}
