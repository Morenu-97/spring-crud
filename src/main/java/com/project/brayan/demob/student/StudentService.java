package com.project.brayan.demob.student;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    @GetMapping
    public List<Student> getStudents() {

        Student student1 =new Student(
                123L,
                "Andres",
                "gda@gmail.com",
                LocalDate.of(1998,5,14),
                26
        );

        Student student2 =new Student(
                1234L,
                "Fernanda",
                "fer@gmail.com",
                LocalDate.of(1999,2,11),
                24
        );

        return List.of(student1,student2);
    }
}
