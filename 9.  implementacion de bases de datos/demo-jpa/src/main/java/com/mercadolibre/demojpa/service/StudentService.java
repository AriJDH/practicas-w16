package com.mercadolibre.demojpa.service;

import com.mercadolibre.demojpa.exception.NotFoundException;
import com.mercadolibre.demojpa.model.Student;
import com.mercadolibre.demojpa.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public void saveStudent(Student stu) {
        studentRepository.save(stu);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("The user %s doesnt exists", id)));

        studentRepository.delete(student);
    }

    @Override
    @Transactional(readOnly = true)
    public Student findStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("The user %s doesnt exists",id)));
    }
}
