package service;

import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentService;


    public StudentService(StudentRepository studentService) {
        this.studentService = studentService;
    }
}
