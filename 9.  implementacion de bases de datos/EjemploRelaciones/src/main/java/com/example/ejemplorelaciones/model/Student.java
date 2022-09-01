package com.example.ejemplorelaciones.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/*
@Entity
@Table(name="students")
@Getter
@Setter

 */
public class Student {

/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany
    @JoinTable(
            name="course_stu",
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> linkedCourses;

 */
}
