package com.example.GestionStuden.service;

import com.example.GestionStuden.model.Payement;
import com.example.GestionStuden.model.PayementStatus;
import com.example.GestionStuden.model.PayementType;
import com.example.GestionStuden.model.Student;
import com.example.GestionStuden.repository.PayementRepository;
import com.example.GestionStuden.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PayementService {

    @Autowired
    PayementRepository payementRepository;

    @Autowired
    StudentRepository studentRepository;


    public Payement savePayement(String studentCode, Payement payement) {
        Student student = studentRepository.findByCode(studentCode);
        if (student == null) {
            throw new EntityNotFoundException("Student with code " + studentCode + " introuvable");
        }

        if (payement.getDate() == null) {
            payement.setDate(LocalDate.now());
        }
        if (payement.getStatus() == null) {
            payement.setStatus(PayementStatus.CREATED);
        }

        payement.setStudent(student);
        return payementRepository.save(payement);
    }

    // READ
    public Payement getPayementById(Long id) {
        return payementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payement introuvable"));
    }

    public List<Payement> getAllPayements() {
        return payementRepository.findAll();
    }


    public List<Payement> getPayementsByStudentCode(String code) {
        return payementRepository.findByStudentCode(code);
    }

    public List<Payement> getPayementsByStatus(PayementStatus status) {
        return payementRepository.findByStatus(status);
    }

    public List<Payement> getPayementsByType(PayementType type) {
        return payementRepository.findByType(type);
    }


    public Payement updatePayement(Long id, Payement payement) {
        Payement existing = getPayementById(id);

        existing.setDate(payement.getDate());
        existing.setAmount(payement.getAmount());
        existing.setType(payement.getType());
        existing.setStatus(payement.getStatus());
        existing.setFile(payement.getFile());


        if (payement.getStudent() != null && payement.getStudent().getCode() != null) {
            Student student = studentRepository.findByCode(payement.getStudent().getCode());
            if (student == null) {
                throw new EntityNotFoundException("Student with code " + payement.getStudent().getCode() + " introuvable");
            }
            existing.setStudent(student);
        }

        return payementRepository.save(existing);
    }


    public Payement changeStatus(Long id, PayementStatus status) {
        Payement existing = getPayementById(id);
        existing.setStatus(status);
        return payementRepository.save(existing);
    }

    public Payement attachFile(Long id, String filePath) {
        Payement existing = getPayementById(id);
        existing.setFile(filePath);
        return payementRepository.save(existing);
    }

    public void deletePayement(Long id) {
        payementRepository.deleteById(id);
    }
}
