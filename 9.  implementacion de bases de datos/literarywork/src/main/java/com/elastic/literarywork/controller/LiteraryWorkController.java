package com.elastic.literarywork.controller;

import com.elastic.literarywork.dto.ReqLiteraryWorkDTO;
import com.elastic.literarywork.model.LiteraryWork;
import com.elastic.literarywork.service.LiteraryWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/literarywork")
public class LiteraryWorkController {
    @Autowired
    LiteraryWorkService literaryWorkService;

    @PostMapping("/")
    public ResponseEntity addOne(@RequestBody ReqLiteraryWorkDTO reqLiteraryWorkDTO) {
        this.literaryWorkService.addOne(reqLiteraryWorkDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping("/author/{author}")
    public ResponseEntity<List<LiteraryWork>> findAllByAuthor(@PathVariable String author) {
        return new ResponseEntity<>(this.literaryWorkService.findAllByAuthor(author), HttpStatus.OK);
    }
    @GetMapping("/title/{title}")
    public ResponseEntity<List<LiteraryWork>> findAllByTitleContaining(@PathVariable String title) {
        return new ResponseEntity<>(this.literaryWorkService.findAllByTitleContaining(title), HttpStatus.OK);
    }
    @GetMapping("/pages/greater/{pages}")
    public ResponseEntity<List<LiteraryWork>> findAllByAmountPagesGreaterThanEqual(@PathVariable Integer pages) {
        return new ResponseEntity<>(this.literaryWorkService.findAllByAmountPagesGreaterThanEqual(pages), HttpStatus.OK);
    }
    @GetMapping("/pages/less/{pages}")
    public ResponseEntity<List<LiteraryWork>> findAllByAmountPagesLessThanEqual(@PathVariable Integer pages) {
        return new ResponseEntity<>(this.literaryWorkService.findAllByAmountPagesLessThanEqual(pages), HttpStatus.OK);
    }
    @GetMapping("/year-publish/before/{before}")
    public ResponseEntity<List<LiteraryWork>> findAllByYearPublicationBefore(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate before) {
        return new ResponseEntity<>(this.literaryWorkService.findAllByYearPublicationBefore(before), HttpStatus.OK);
    }
    @GetMapping("/year-publish/after/{after}")
    public ResponseEntity<List<LiteraryWork>> findAllByYearYearPublicationAfter(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate after) {
        return new ResponseEntity<>(this.literaryWorkService.findAllByYearYearPublicationAfter(after), HttpStatus.OK);
    }
    @GetMapping("/publisher/{publisher}")
    public ResponseEntity<List<LiteraryWork>> findAllByPublisherEquals(@PathVariable String publisher) {
        return new ResponseEntity<>(this.literaryWorkService.findAllByPublisherEquals(publisher), HttpStatus.OK);
    }
}
