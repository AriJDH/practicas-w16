package com.example.crudJPA.controller;

import com.example.crudJPA.model.Student;
import com.example.crudJPA.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private IStudentService stuServ;

    @GetMapping ("/students")
    public List<Student> getStudents () {
        List<Student> studentList = stuServ.getStudents();
        return studentList;
    }

    @PostMapping ("/create")
      public String createStudent(@RequestBody Student student) {
        stuServ.saveStudent(student);
        return "El estudiante fue agregado correctamente";
    }

    @PostMapping("delete/{id}")
    public String deleteStudent (@PathVariable long id) {
        stuServ.deleteStudent(id);
        return "El estudiante fue borrado correctamente";
    }

    @PostMapping ("edit/{id}")
    public Student editStudent (@PathVariable long id,
                                @RequestParam ("name") String newName,
                                @RequestParam ("lastname") String newLastname) {
        return stuServ.modifyStudent(id, newName, newLastname);
    }
}
