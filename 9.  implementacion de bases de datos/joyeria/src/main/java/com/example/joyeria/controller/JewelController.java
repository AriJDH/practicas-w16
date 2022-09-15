package com.example.joyeria.controller;

import com.example.joyeria.dto.ReqJewelDTO;
import com.example.joyeria.dto.ReqUpdateJewelDTO;
import com.example.joyeria.dto.ResJewelDTO;
import com.example.joyeria.service.IJewelService;
import com.example.joyeria.service.JewelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/jewel")
public class JewelController {
    IJewelService jewelService;
    JewelController(JewelService jewelService) {
        this.jewelService = jewelService;
    }

    @GetMapping("")
    public ResponseEntity<List<ResJewelDTO>> getAll() {
        return new ResponseEntity<>(this.jewelService.getAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ResJewelDTO>  add(@RequestBody ReqJewelDTO reqJewelDTO) {
        ResJewelDTO resJewelDTO = this.jewelService.addJewel(reqJewelDTO);
        return new ResponseEntity<>(resJewelDTO, HttpStatus.OK);
    }
    @PutMapping("/{jewelId}")
    public ResponseEntity<ResJewelDTO>  update(@RequestBody ReqUpdateJewelDTO reqUpdateJewelDTO, @PathVariable Long jewelId) {
        ResJewelDTO resJewelDTO = this.jewelService.update(reqUpdateJewelDTO, jewelId);
        return new ResponseEntity<>(resJewelDTO, HttpStatus.OK);
    }
    @DeleteMapping("/{jewelId}")
    public ResponseEntity<ResJewelDTO>  delete(@PathVariable Long jewelId) {
        this.jewelService.delete(jewelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
