package com.example.crud.controller;

import com.example.crud.model.Student;
import com.example.crud.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private IStudentService stuServ;

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student) {
        stuServ.saveStudent(student);
        return "El estudiante fue agregado correctamente";
    }

    @GetMapping("/students")
    public List<Student> getStudents () {
        List<Student> studentList = stuServ.getStudents();
        return studentList;
    }

    @PostMapping("edit/{id}")
    public Student editStudent (@PathVariable long id,
                                @RequestParam("name") String newName,
                                @RequestParam("lastname") String newLastname) {
        Student stu = stuServ.findStudent(id);
        //esto puede ir en el service
        stu.setName(newName);
        stu.setLastname(newLastname);
        stuServ.saveStudent(stu);
        return stu;
    }

    @PostMapping("delete/{id}")
    public String deleteStudent (@PathVariable long id) {
        stuServ.deleteStudent(id);
        return "El estudiante fue borrado correctamente";
    }
}
