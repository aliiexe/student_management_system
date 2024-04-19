package com.ilem.gestionetudiants;

import com.ilem.gestionetudiants.entities.Payment;
import com.ilem.gestionetudiants.entities.PaymentStatus;
import com.ilem.gestionetudiants.entities.PaymentType;
import com.ilem.gestionetudiants.entities.Student;
import com.ilem.gestionetudiants.repositories.PaymentRepository;
import com.ilem.gestionetudiants.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class GestionetudiantsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionetudiantsApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, PaymentRepository paymentRepository) {
        return args -> {
            Student student1 = Student.builder().id(UUID.randomUUID().toString()).firstName("John").lastName("Doe").code("JD001").programId("PR001").photo("john.jpg").build();
            studentRepository.save(student1);

            Student student2 = Student.builder().id(UUID.randomUUID().toString()).firstName("Jane").lastName("Doe").code("JD002").programId("PR001").photo("jane.jpg").build();
            studentRepository.save(student2);

            Student student3 = Student.builder().id(UUID.randomUUID().toString()).firstName("Alice").lastName("Smith").code("AS001").programId("PR002").photo("alice.jpg").build();
            studentRepository.save(student3);

            PaymentType[] paymentTypes = PaymentType.values();
            Random random = new Random();

            studentRepository.findAll().forEach(student -> {
                int index = random.nextInt(paymentTypes.length);
                for (int i=0; i<10; i++){
                    Payment payment =  Payment.builder()
                            .amount(1000+(int)(Math.random()+20000))
                            .paymentType(paymentTypes[index])
                            .paymentStatus(PaymentStatus.CREATED)
                            .date(LocalDate.now())
                            .student(student)
                            .build();
                    paymentRepository.save(payment);
                }
            });
        };
    }

}
