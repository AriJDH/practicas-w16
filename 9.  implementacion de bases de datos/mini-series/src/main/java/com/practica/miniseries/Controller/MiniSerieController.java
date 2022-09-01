package com.practica.miniseries.Controller;

import com.practica.miniseries.DTO.MiniSerieDto;
import com.practica.miniseries.service.IMiniSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mini-serie")
public class MiniSerieController {

    @Autowired
    IMiniSerieService miniSerieService;

    @PostMapping("/create")
    public ResponseEntity<MiniSerieDto> create(@RequestBody MiniSerieDto miniSerie) {
        MiniSerieDto result = miniSerieService.createMiniSerie(miniSerie);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("list-all")
    public ResponseEntity<List<MiniSerieDto>> list() {
        List<MiniSerieDto> result = miniSerieService.getListMiniSerie();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
