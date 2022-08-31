package com.meli.implementacionjpa.service;

import com.meli.implementacionjpa.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getStudents();
    void saveStudent(Student student);
    void deleteStudent(Long id);
    Student findStudent(Long id);

}
