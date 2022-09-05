package com.mercadolibre.demojpa.service;

import com.mercadolibre.demojpa.model.Student;

import java.util.List;

public interface IStudentService {

    public List<Student> getStudents();
    public void saveStudent(Student stu);
    public void deleteStudent(Long id);
    public Student findStudent(Long id);

}
