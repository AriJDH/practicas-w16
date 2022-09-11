package com.example.spring.hibernate.service;

import com.example.spring.hibernate.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IStudentService {

    public List<Student> getStudents();
    public void saveStudent(Student student);
    public void deleteStudent(long id);
    public Student findStudent(long id);
}
