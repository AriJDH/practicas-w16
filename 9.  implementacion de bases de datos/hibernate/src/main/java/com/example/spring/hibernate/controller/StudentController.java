package com.example.spring.hibernate.controller;

import com.example.spring.hibernate.entity.Student;
import com.example.spring.hibernate.service.IStudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "El estudiante fue agregado correctamente.";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = studentService.getStudents();
        return students;
    }

    @PostMapping("/edit/{id}")
    public Student editStudent(@PathVariable long id,
                               @RequestParam("name") String newName,
                               @RequestParam("lastName") String newLastName){
        Student student = studentService.findStudent(id);
        student.setName(newName);
        student.setLastName(newLastName);
        studentService.saveStudent(student);
        return student;
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return "El estudiante fue borrado correctamente.";
    }


}
