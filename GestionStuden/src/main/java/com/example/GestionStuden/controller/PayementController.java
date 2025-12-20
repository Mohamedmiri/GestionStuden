package com.example.GestionStuden.controller;

import com.example.GestionStuden.model.Payement;
import com.example.GestionStuden.model.PayementStatus;
import com.example.GestionStuden.model.PayementType;
import com.example.GestionStuden.service.PayementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payements")
@CrossOrigin("*")
public class PayementController {

    @Autowired
    private PayementService payementService;

    @PostMapping("/student/{code}")
    public Payement savePayement(@PathVariable String code, @RequestBody Payement payement) {
        return payementService.savePayement(code, payement);
    }

    @GetMapping
    public List<Payement> getAllPayements() {
        return payementService.getAllPayements();
    }

    @GetMapping("/{id}")
    public Payement getPayementById(@PathVariable Long id) {
        return payementService.getPayementById(id);
    }

    @GetMapping("/student/{code}")
    public List<Payement> getPayementsByStudentCode(@PathVariable String code) {
        return payementService.getPayementsByStudentCode(code);
    }

    @GetMapping("/status/{status}")
    public List<Payement> getPayementsByStatus(@PathVariable PayementStatus status) {
        return payementService.getPayementsByStatus(status);
    }

    @GetMapping("/type/{type}")
    public List<Payement> getPayementsByType(@PathVariable PayementType type) {
        return payementService.getPayementsByType(type);
    }

    @PutMapping("/{id}")
    public Payement updatePayement(@PathVariable Long id, @RequestBody Payement payement) {
        return payementService.updatePayement(id, payement);
    }

    @PutMapping("/{id}/status/{status}")
    public Payement changeStatus(@PathVariable Long id, @PathVariable PayementStatus status) {
        return payementService.changeStatus(id, status);
    }

    @PutMapping("/{id}/file")
    public Payement attachFile(@PathVariable Long id, @RequestParam String filePath) {
        return payementService.attachFile(id, filePath);
    }

    @DeleteMapping("/{id}")
    public void deletePayement(@PathVariable Long id) {
        payementService.deletePayement(id);
    }
}
