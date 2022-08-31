package com.ndemaio.ejerciciotestcases.controller;

import com.ndemaio.ejerciciotestcases.model.TestCase;
import com.ndemaio.ejerciciotestcases.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping (path = "/api/testcases")
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;

    // POST /api/testcases/new Crear un nuevo caso de prueba.
    @PostMapping (path = "/new")
    public ResponseEntity createTestCase(@RequestBody TestCase testCase) {
        testCaseService.createTestCase(testCase);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created.");
    }

    // GET /api/testcases Devolver todos los casos de prueba.
    //     /api/testcases?last_update=’dd/mm/yyyy’ - casos de prueba que hayan sido actualizados después de una determinada fecha.
    @GetMapping
    public ResponseEntity getTestCases(@RequestParam(required = false) Map<String, String> filters) {
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.getTestCases(filters));
    }

    // GET /api/testcases/id Devolver un caso de prueba por id.
    @GetMapping (path = "/{id}")
    public ResponseEntity getTestCaseById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.getTestCaseById(id));
    }

    // PUT /api/testcases/id Actualizar un caso de prueba por id.
    @PutMapping (path = "/{id}")
    public ResponseEntity updateTestCase(@PathVariable Long id, @RequestBody TestCase updatedTestCase) {
        testCaseService.updateTestCaseById(id, updatedTestCase);
        return ResponseEntity.status(HttpStatus.OK).body("Updated correctly.");
    }

    // DELETE /api/testcases/id Eliminar un tutorial por id.
    @DeleteMapping (path = "/{id}")
    public ResponseEntity deleteTestCaseById(@PathVariable Long id) {
        testCaseService.deleteTestCaseById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted.");
    }

}
