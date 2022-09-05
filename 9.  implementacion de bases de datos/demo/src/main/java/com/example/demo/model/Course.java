package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "likedCourses")
    private Set<Student> students;

}
