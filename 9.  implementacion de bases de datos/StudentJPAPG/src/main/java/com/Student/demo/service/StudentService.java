package com.Student.demo.service;


import com.Student.demo.dto.StudentDto;
import com.Student.demo.model.Student;
import com.Student.demo.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService{

    @Autowired
    IStudentRepository iStudentRepository;

    @Override

    public List<StudentDto> getStudents() {
        return iStudentRepository.findAll().stream().map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override

    public StudentDto getStudentById(Long id) {
        return entityToDTO(iStudentRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe el id")));
    }

    @Override

    public void createStudent(StudentDto student) {
        iStudentRepository.save(dtoToEntity(student));
    }

    @Override

    public void deleteStudent(Long id) {
        dtoToEntity(this.getStudentById(id));
        iStudentRepository.deleteById(id);
    }

    @Override
   
    public StudentDto updateStudent(StudentDto studentDto, Long id) {
        Student studentToUpdate = dtoToEntity(this.getStudentById(id));

        studentToUpdate.setDni(studentDto.getDni());
        studentToUpdate.setName(studentDto.getName());
        studentToUpdate.setLastName(studentDto.getLastName());

        return entityToDTO(iStudentRepository.save(studentToUpdate));
    }

    private StudentDto entityToDTO(Student student){
        return new StudentDto(student.getId(), student.getName(), student.getLastName(), student.getDni());
    }

    private Student dtoToEntity(StudentDto student){
        return new Student(student.getId(), student.getName(), student.getLastName(), student.getDni());
    }
}
