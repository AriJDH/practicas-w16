package com.example.crud.service;

import com.example.crud.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> getStudents ();
    void saveStudent (Student stu);
    void deleteStudent (Long id);
    Student findStudent (Long id);

}
