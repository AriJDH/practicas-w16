package com.example.studentCrud.service;

import com.example.studentCrud.model.Student;

import java.util.List;

public interface IStudentService {

    public List<Student> getStudent();
    public Student findStudentById(Long id);
    public void saveStudent(Student student);
    public void deleteStudent(Long id);

}
