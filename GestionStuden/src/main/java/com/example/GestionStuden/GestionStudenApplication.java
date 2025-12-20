package com.example.GestionStuden;

import com.example.GestionStuden.model.Payement;
import com.example.GestionStuden.model.PayementStatus;
import com.example.GestionStuden.model.PayementType;
import com.example.GestionStuden.model.Student;
import com.example.GestionStuden.repository.PayementRepository;
import com.example.GestionStuden.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class GestionStudenApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionStudenApplication.class, args);
	}

	}



