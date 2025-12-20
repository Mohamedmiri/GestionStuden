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
	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepository studentRepository,
			PayementRepository paymentRepository
	) {
		return args -> {

			studentRepository.save(
					Student.builder()
							.id(UUID.randomUUID().toString())
							.prenom("Mohamed")
							.code("112233")
							.programId("SDIA")
							.build()
			);

			studentRepository.save(
					Student.builder()
							.id(UUID.randomUUID().toString())
							.prenom("Imane")
							.code("112244")
							.programId("SDIA")
							.build()
			);

			studentRepository.save(
					Student.builder()
							.id(UUID.randomUUID().toString())
							.prenom("Yasmine")
							.code("112255")
							.programId("GLSID")
							.build()
			);

			studentRepository.save(
					Student.builder()
							.id(UUID.randomUUID().toString())
							.prenom("Najat")
							.code("112266")
							.programId("BDCC")
							.build()
			);

			PayementType[] paymentTypes = PayementType.values();
			Random random = new Random();

			studentRepository.findAll().forEach(st -> {
				for (int i = 0; i < 5; i++) {
					int index = random.nextInt(paymentTypes.length);

					Payement payment = Payement.builder()
							.amount(1000 + (int) (Math.random() * 20000))
							.type(paymentTypes[index])
							.status(PayementStatus.CREATED)
							.date(LocalDate.now())
							.student(st)
							.build();

					paymentRepository.save(payment);
				}
			});
		};
	}


}
