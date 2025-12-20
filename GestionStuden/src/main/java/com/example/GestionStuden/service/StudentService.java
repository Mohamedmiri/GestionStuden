package com.example.GestionStuden.service;

import com.example.GestionStuden.model.Student;
import com.example.GestionStuden.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {


   @Autowired
   StudentRepository studentRepository;


    public Student saveStudent(Student student) {
        if (student.getId() == null) {
            student.setId(UUID.randomUUID().toString());
        }
        return studentRepository.save(student);
    }


//    public Student getStudentById(String id) {
//        return studentRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Student introuvablle"));
//    }


    public Student getStudentByCode(String code) {
        Student student = studentRepository.findByCode(code);
        if (student == null) {
            throw new EntityNotFoundException("Student with code " + code + " introuvablel");
        }
        return student;
    }


    public List<Student> getStudentsByProgram(String programId) {
        return studentRepository.findByProgramId(programId);
    }


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public Student updateStudent(String code, Student student) {
        Student existing = getStudentByCode(code);

        existing.setNom(student.getNom());
        existing.setPrenom(student.getPrenom());
        existing.setProgramId(student.getProgramId());
        existing.setPhoto(student.getPhoto());

        return studentRepository.save(existing);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}

