package com.bootcamp.demo.service;

import com.bootcamp.demo.model.Student;
import com.bootcamp.demo.repository.StudentRepository;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public class StudentService implements IStudentService {

    private final StudentRepository stuRepo;

    public StudentService(StudentRepository stuRepo) {
        this.stuRepo = stuRepo;
    }

    @Override
    @Transactional (readOnly = true)
    public List<Student> getStudents() {
        List<Student> studentList = stuRepo.findAll();
        return studentList;
    }

    @Override
    public void saveStudent(Student stu) {

    }

    @Override
    public void deleteStudent(long id) {

    }

    @Override
    public Student findStudent(long id) {
        return null;
    }
}
