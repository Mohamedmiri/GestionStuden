package com.example.GestionStuden.repository;

import com.example.GestionStuden.model.Payement;
import com.example.GestionStuden.model.PayementStatus;
import com.example.GestionStuden.model.PayementType;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface PayementRepository extends JpaRepository<Payement,Long> {

    List<Payement> findByStudentCode(String code);

    List<Payement> findByStatus(PayementStatus status);

    List<Payement> findByType(PayementType type);
}
