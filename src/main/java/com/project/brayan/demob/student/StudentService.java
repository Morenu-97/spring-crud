package com.project.brayan.demob.student;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudent(Long studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (!optionalStudent.isPresent()) {
            throw new IllegalArgumentException("Id no existe");
        }
        return optionalStudent.get();
    }

    public void deleteStudent(Long studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (!optionalStudent.isPresent()) {
            throw new IllegalArgumentException("Id no existe");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (!optionalStudent.isPresent()) {
            throw new IllegalArgumentException("Id no existe");
        }
        Student student = optionalStudent.get();
        if (name != null && name.length() > 0 && !name.equals(student.getName())) {
            student.setName(name);
        }
        if (email != null && email.length() > 0 && !email.equals(student.getEmail())) {
            student.setEmail(email);
        }

    }
}
