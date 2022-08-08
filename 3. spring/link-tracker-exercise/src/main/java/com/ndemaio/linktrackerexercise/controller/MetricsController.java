package com.ndemaio.linktrackerexercise.controller;

import com.ndemaio.linktrackerexercise.dto.InformativeMessage;
import com.ndemaio.linktrackerexercise.dto.LinkDTOResponse;
import com.ndemaio.linktrackerexercise.exception.LinkNotFoundException;
import com.ndemaio.linktrackerexercise.service.LinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path = "/metrics")
public class MetricsController {

    private LinkService linkService;

    public MetricsController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getMetricsForLinkIdentifiedWith(@PathVariable UUID id) throws LinkNotFoundException {
        LinkDTOResponse linkDTOResponse = linkService.getLinkById(id);
        return ResponseEntity.ok(new InformativeMessage("Veces redireccionado: " + linkDTOResponse.getTimesRedirected().toString()));
    }

}
