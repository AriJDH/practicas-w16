package com.example.studentCrud.controller;

import com.example.studentCrud.model.Student;
import com.example.studentCrud.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/create")
        public String createStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return "El estudiante fue agregado correctamente";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> studentList = studentService.getStudent();
        return studentList;
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id){
        Student student = studentService.findStudentById(id);
        return student;
    }

    @PostMapping("edit/{id}")
    public Student editStudent (@PathVariable Long id,
                                @RequestParam ("name") String newName,@RequestParam ("lastname") String newLastname){
        Student student = studentService.findStudentById(id);
        student.setLastname(newLastname);
        student.setName(newName);
        studentService.saveStudent(student);
        return student;
    }

    @PostMapping("delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "El estudiante fue borrado correctamente";
    }
}
