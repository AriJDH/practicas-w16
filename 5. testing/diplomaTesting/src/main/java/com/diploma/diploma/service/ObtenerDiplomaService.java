package com.diploma.diploma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diploma.diploma.model.StudentDTO;
import com.diploma.diploma.model.SubjectDTO;
import com.diploma.diploma.repository.IStudentDAO;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class ObtenerDiplomaService implements IObtenerDiplomaService {

    @Autowired
    IStudentDAO studentDAO;

    @Override
    public StudentDTO analyzeScores(Long studentId) {
        StudentDTO stu = studentDAO.findById(studentId);

        stu.setAverageScore(calculateAverage(stu.getSubjects()));
        stu.setMessage(getGreetingMessage(stu.getStudentName(), stu.getAverageScore()));

        return stu;
    }

    private String getGreetingMessage(String studentName, Double average) {
        return "El alumno " + studentName + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ((average > 9) ? ". Felicitaciones!" : ". Puedes mejorar.");
    }

    private Double calculateAverage(List<SubjectDTO> scores) {
        DecimalFormat oneDigit = new DecimalFormat("#,##0.0");
        Double average = scores.stream()
               .reduce(0D, (partialSum, score)  -> partialSum + score.getScore(), Double::sum)
               / scores.size();
       return Double.valueOf(oneDigit.format(average));
    }
}

