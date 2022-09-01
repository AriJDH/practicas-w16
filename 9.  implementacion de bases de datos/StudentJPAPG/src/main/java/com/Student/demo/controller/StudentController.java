package com.Student.demo.controller;

import com.Student.demo.dto.StudentDto;
import com.Student.demo.model.Student;
import com.Student.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
   private IStudentService iStudentService;

    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@RequestBody StudentDto studentDto){
        iStudentService.createStudent(studentDto);
        return new ResponseEntity<>("Creaste un nuevo estudiante", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudents(){
        return new ResponseEntity<>(iStudentService.getStudents(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return new ResponseEntity<>(iStudentService.getStudentById(id), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto, @PathVariable Long id){
        return new ResponseEntity<>(iStudentService.updateStudent(studentDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        iStudentService.deleteStudent(id);
    return new ResponseEntity<>(HttpStatus.OK);
    }

}
