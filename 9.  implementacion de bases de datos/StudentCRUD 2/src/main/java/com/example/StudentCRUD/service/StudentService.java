package com.example.StudentCRUD.service;

import com.example.StudentCRUD.model.Student;
import com.example.StudentCRUD.repository.StudentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentService implements IStudentService{

    private final StudentRepository stuRepo;

    public StudentService(StudentRepository stuRepo){
        this.stuRepo = stuRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        List<Student> studentList = stuRepo.findAll();
        return studentList;
    }

    @Override
    public void saveStudent(Student stu) {
        stuRepo.save(stu);
    }

    @Override
    public void deleteStudent(long id) {
        stuRepo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Student findStudent(long id) {
        Student stu = stuRepo.findById(id).orElse(null);
        return stu;
    }

    @Override
    public Student updateStudent(Student stu) {
        Student stu_db = this.findStudent(stu.getId());

        stu_db.setName(stu.getName());
        stu_db.setLastname(stu.getLastname());

        this.saveStudent(stu_db);

        return stu_db;
    }


}
