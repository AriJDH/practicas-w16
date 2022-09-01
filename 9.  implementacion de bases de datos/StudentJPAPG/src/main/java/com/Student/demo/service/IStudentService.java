package com.Student.demo.service;

import java.util.List;
import com.Student.demo.dto.StudentDto;

public interface IStudentService {
    public List<StudentDto> getStudents();
    public StudentDto getStudentById(Long id);
    public void createStudent(StudentDto student);
    public void deleteStudent(Long id);

    StudentDto updateStudent(StudentDto studentDto, Long id);

}
