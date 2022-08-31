package com.example.crudJPA.service;

import com.example.crudJPA.model.Student;
import java.util.List;

public interface IStudentService {
    List<Student> getStudents ();
    void saveStudent (Student student);
    void deleteStudent (long id);
    Student modifyStudent(long id, String name, String lastname);
    Student findStudent (long id);
}
