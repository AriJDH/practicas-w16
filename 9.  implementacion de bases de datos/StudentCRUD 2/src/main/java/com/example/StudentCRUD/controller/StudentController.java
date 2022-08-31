package com.example.StudentCRUD.controller;

import com.example.StudentCRUD.model.Student;
import com.example.StudentCRUD.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private IStudentService stuServ;

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){
        stuServ.saveStudent(student);
        return "El estudiante fue agregado correctamente";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> studentList = stuServ.getStudents();
        return studentList;
    }

    @PostMapping("delete/{id}")
    public String deleteStudent(@PathVariable long id){
        stuServ.deleteStudent(id);
        return "El estudiante fue borrado correctamente";
    }

    @GetMapping("find/{id}")
    public Student findStudent(@PathVariable long id){
        Student stu = stuServ.findStudent(id);
        return stu;
    }

    @PostMapping("edit/{id}")
    public Student editStudent(@PathVariable long id,
                               @RequestParam ("name") String newName,
                               @RequestParam ("lastname") String newLastname){

        Student stu = new Student();
        stu.setId(id);
        stu.setName(newName);
        stu.setLastname(newLastname);

        return stuServ.updateStudent(stu);
    }
}
