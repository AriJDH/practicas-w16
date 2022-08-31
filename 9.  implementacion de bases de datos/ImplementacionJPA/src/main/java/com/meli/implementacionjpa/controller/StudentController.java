package com.meli.implementacionjpa.controller;

import com.meli.implementacionjpa.entity.Student;
import com.meli.implementacionjpa.service.IStudentService;
import com.meli.implementacionjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "El estudiante fue agregado correctamente";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/edit/{id}")
    public Student editStudent(@PathVariable Long id,
                               @RequestParam("name") String newName,
                               @RequestParam("lastname") String newLastName) {
        Student student = studentService.findStudent(id);

        student.setName(newName);
        student.setLastName(newLastName);
        studentService.saveStudent(student);

        return student;
    }

    @PostMapping("delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "El estudiante fue borrado correctamente.";
    }

}
