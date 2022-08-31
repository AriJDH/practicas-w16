package com.meli.implementacionjpa.service;

import com.meli.implementacionjpa.entity.Student;
import com.meli.implementacionjpa.repository.IStudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        return studentRepository.findAll();
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

    @Override
    @Transactional(readOnly = true)
    public Student findStudent(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        return student;
    }
}
