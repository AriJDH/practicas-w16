package com.example.crudJPA.service;

import com.example.crudJPA.model.Student;
import com.example.crudJPA.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    @Autowired
    StudentRepository stuRepo;

    @Override
    @Transactional (readOnly = true)
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
    public void deleteStudent(long id) {
        stuRepo.deleteById(id);
    }

    @Override
    @Transactional
    public Student modifyStudent(long id, String name, String lastname){
        Student stu=stuRepo.findById(id).orElse(null);
        if (stu != null) {
            stu.setName(name);
            stu.setLastname(lastname);
            stuRepo.save(stu);
        }
        return stu;
    }

    @Override
    @Transactional (readOnly = true)
    public Student findStudent(long id) {
        Student stu=stuRepo.findById(id).orElse(null);
        return stu;
    }
}



