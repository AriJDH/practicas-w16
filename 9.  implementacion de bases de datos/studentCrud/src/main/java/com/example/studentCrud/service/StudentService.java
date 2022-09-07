package com.example.studentCrud.service;

import com.example.studentCrud.model.Student;
import com.example.studentCrud.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudent() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    @Override
    @Transactional(readOnly = true)
    public Student findStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        return student;
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
