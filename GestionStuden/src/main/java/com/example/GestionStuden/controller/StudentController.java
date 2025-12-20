package com.example.GestionStuden.controller;

import com.example.GestionStuden.model.Student;
import com.example.GestionStuden.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/code/{code}")
    public Student getStudentByCode(@PathVariable String code) {
        return studentService.getStudentByCode(code);
    }

    @GetMapping("/program/{programId}")
    public List<Student> getStudentsByProgram(@PathVariable String programId) {
        return studentService.getStudentsByProgram(programId);
    }

    @PutMapping("/code/{code}")
    public Student updateStudent(@PathVariable String code, @RequestBody Student student) {
        return studentService.updateStudent(code, student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
    }
}
