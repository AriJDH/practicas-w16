package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class TestUtils {

    private static String SCOPE;

    public static void emptyFile() {
        Properties properties =  new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Escribiendo a ");
        System.out.println("./src/" + SCOPE + "/resources/users.json");
        try (FileWriter fr = new FileWriter("./src/" + SCOPE + "/resources/users.json", false);
             BufferedWriter br = new BufferedWriter(fr)) {
            br.write("[]");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StudentDTO generateStudentNoSubjects(String name, long id) {
        StudentDTO student = new StudentDTO();
        student.setStudentName(name);
        student.setId(id);
        return student;
    }

    public static StudentDTO generateStudent2Subjects(String name, long id) {
        StudentDTO student = new StudentDTO();
        student.setStudentName(name);
        List<SubjectDTO> subjects = List.of(generateSubject("Matemáticas"), generateSubject("Física"));
        student.setSubjects(subjects);
        student.setId(id);
        return student;
    }

    public static StudentDTO generateNormalStudent(String name, long id) {
        StudentDTO student = new StudentDTO();
        student.setStudentName(name);
        List<SubjectDTO> subjects = List.of(generateSubjectLowScore("Matemáticas"),
                generateSubjectLowScore("Física"));
        student.setSubjects(subjects);
        student.setId(id);
        return student;
    }

    public static StudentDTO generateHonoredStudent(String name, long id) {
        StudentDTO student = new StudentDTO();
        student.setStudentName(name);
        List<SubjectDTO> subjects = List.of(generateSubjectHighScore("Matemáticas"),
                generateSubjectHighScore("Física"));
        student.setSubjects(subjects);
        student.setId(id);
        return student;
    }

    private static SubjectDTO generateSubject(String name) {
        Random r = new Random();
        double randomScore = 10 * r.nextDouble();
        return new SubjectDTO(name, randomScore);
    }

    private static SubjectDTO generateSubjectHighScore(String name) {
        Random r = new Random();
        double randomScore = 9 + r.nextDouble();
        return new SubjectDTO(name, randomScore);
    }

    private static SubjectDTO generateSubjectLowScore(String name) {
        Random r = new Random();
        double randomScore = 9 * r.nextDouble();
        return new SubjectDTO(name, randomScore);
    }

}
