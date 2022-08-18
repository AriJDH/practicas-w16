package com.diploma.util;

import com.diploma.diploma.model.StudentDTO;
import com.diploma.diploma.model.SubjectDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.util.ResourceUtils;

public class UtilTestTools {

  private static Long id = 0L;

  public static List<SubjectDTO> getSubjects() {
    List<SubjectDTO> subjects = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      SubjectDTO subject = new SubjectDTO();
      subject.setName("Subject " + id);
      subject.setScore(Math.abs(Math.random() * 10));
      subjects.add(subject);
    }
    return subjects;
  }

  public static StudentDTO generateStudent(String name) {
    List<SubjectDTO> subjects = getSubjects();
    StudentDTO student = new StudentDTO(
      ++id,
      name,
      "Esto es un mensaje",
      0.0,
      subjects
    );
    return student;
  }

  public static Set<StudentDTO> generateStudents(String... names) {
    Set<StudentDTO> students = new HashSet<>();
    for (String name : names) {
      students.add(generateStudent(name));
    }
    return students;
  }

  public static boolean compareSets(
    Set<StudentDTO> students1,
    Set<StudentDTO> students2
  ) {
    if (students1.size() != students2.size()) {
      return false;
    }

    for (StudentDTO student1 : students1) {
      if (!students2.contains(student1)) {
        return false;
      }
    }

    return true;
  }

  private static String SCOPE = "main";

  public static Set<StudentDTO> findAll() {
    Set<StudentDTO> loadedData = new HashSet<>();

    ObjectMapper objectMapper = new ObjectMapper();
    try {
      File file = ResourceUtils.getFile(
        "./src/" + SCOPE + "/resources/users.json"
      );
      loadedData =
        objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>() {});
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      System.out.println(
        "Failed while initializing DB, check your resources files"
      );
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println(
        "Failed while initializing DB, check your JSON formatting."
      );
    }

    return loadedData;
  }

  public static StudentDTO generateStudentWithAverage(Double average) {
    List<SubjectDTO> subjects = new ArrayList<>();

    for (int i = 0; i < 5; i++) {
      subjects.add(new SubjectDTO("Subject " + i, average));
    }

    StudentDTO student = new StudentDTO(
      ++id,
      "Student " + id,
      "",
      average,
      subjects
    );

    return student;
  }

  public static String getMessageAccordingToAverage(Double average) {
    if (average >= 9.0) {
      return "Felicitaciones!";
    } 
    
    return "Puedes mejorar.";
  }

  public static Double calculateAverage(List<SubjectDTO> subjects) {
    DecimalFormat oneDigit = new DecimalFormat("#,##0.0");
    Double average = subjects.stream()
           .reduce(0D, (partialSum, score)  -> partialSum + score.getScore(), Double::sum)
           / subjects.size();
    return Double.valueOf(oneDigit.format(average));
  }
}
