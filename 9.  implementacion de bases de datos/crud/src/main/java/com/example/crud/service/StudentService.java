package com.example.crud.service;

import com.example.crud.model.Student;
import com.example.crud.repository.IStudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class StudentService implements IStudentService{

    private final IStudentRepository stuRepo;

    public StudentService(IStudentRepository stuRepo) {
        this.stuRepo = stuRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        List<Student> studentList = stuRepo.findAll();
        return studentList;
    }

    @Override
    @Transactional
    public void saveStudent(Student stu) {
        stuRepo.save(stu);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        stuRepo.deleteById(id);
    }

    @Override
    @Transactional (readOnly = true)
    public Student findStudent(Long id) {
        Student stu = stuRepo.findById(id).orElse(null);
        return stu;
    }
}
