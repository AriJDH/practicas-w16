package com.example.starwars.controller;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.service.FindService;
import com.example.starwars.service.IFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindController {
  private IFindService findService;

  public FindController ( IFindService findService ) {
    this.findService = findService;
  }

  @GetMapping("/{query}")
  public List<CharacterDTO> find(@PathVariable String query) {
    return findService.find(query);
  }
}
