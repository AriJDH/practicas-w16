package com.example.qatesters.controller;

import com.example.qatesters.dto.ReqPostTestCaseDTO;
import com.example.qatesters.dto.ReqPutUpdateTestCaseDTO;
import com.example.qatesters.dto.ResTestCaseDTO;
import com.example.qatesters.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/testcases")
public class TestCaseController {
    @Autowired
    ITestCaseService testCaseService;

    @GetMapping("")
    public ResponseEntity<List<ResTestCaseDTO>> listAllTestCase(@RequestParam("last_update") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> localDate) {
        return new ResponseEntity<>(this.testCaseService.listAllTestCase(localDate), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ResTestCaseDTO> addTestCase(@Valid @RequestBody ReqPostTestCaseDTO reqPostTestCaseDTO) {
        return new ResponseEntity<>(this.testCaseService.addTestCase(reqPostTestCaseDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResTestCaseDTO> getTestCaseById(@PathVariable Long id) {
        return new ResponseEntity<>(this.testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResTestCaseDTO> updateTestCaseById(@PathVariable Long id, @RequestBody ReqPutUpdateTestCaseDTO reqPutUpdateTestCaseDTO) {
        return new ResponseEntity<>(this.testCaseService.updateTestCaseById(id, reqPutUpdateTestCaseDTO), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResTestCaseDTO> deleteTestCaseById(@PathVariable Long id) {
        this.testCaseService.deleteTestCaseById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
