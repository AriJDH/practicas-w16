package com.mercadolibre.linktracker.controller;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LinkController {
  private final LinkService linkService;

  public LinkController(LinkService linkService) {
    this.linkService = linkService;
  }

  @PostMapping("create")
  public LinkDTO create(@RequestBody LinkDTO link) {
    return linkService.create(link);
  }

  @GetMapping("link/{linkId}")
  public void redirect(@PathVariable Integer linkId, HttpServletResponse response) throws IOException {
    LinkDTO link = linkService.redirect(linkId);
    if (link != null){
      response.sendRedirect(link.getLink());
    } else {
      response.sendError(404);
    }
  }

  @GetMapping(value = "link/{linkId}", params = {"password"})
  public void redirect(@PathVariable Integer linkId, @RequestParam("password") String password, HttpServletResponse response) throws IOException {
    LinkDTO link = linkService.redirect(linkId, password);
    if (link != null){
      response.sendRedirect(link.getLink());
    } else {
      response.sendError(404);
    }
  }

  @GetMapping("metrics/{linkId}")
  public LinkDTO metrics(@PathVariable Integer linkId) throws IOException {
    return linkService.metrics(linkId);
  }

  @PostMapping("invalidate/{linkId}")
  public void invalidate(@PathVariable Integer linkId) throws IOException {
    linkService.invalidate(linkId);
  }
}
