package com.example.obtenerdiploma.service;

import com.example.obtenerdiploma.model.StudentDTO;
import com.example.obtenerdiploma.model.SubjectDTO;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class ObtenerDiplomaService implements IObtenerDiplomaService{

    @Override
    public StudentDTO analyzeScores(StudentDTO request) {
        request.setAverageScore(calculateAverage(request.getSubjects()));
        request.setMessage(getMessage(request.getStudentName(), request.getAverageScore()));
        return request;
    }

    private String getMessage(String studentName, Double average){
        return "El alumno "+ studentName+" ha obtenido el promedio de "+new DecimalFormat("#.##").format(average) +
                ((average>9) ? ". FELICITACIONES!!!" : "PUEDES MEJORAR" );
    }

    private Double calculateAverage(List<SubjectDTO> scores){
        return scores.stream()
                .reduce(0D,(partialSum, score)->partialSum+score.getScore(), Double::sum)/scores.size();
    }
}
