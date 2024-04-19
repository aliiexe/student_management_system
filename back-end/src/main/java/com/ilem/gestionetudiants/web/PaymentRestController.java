package com.ilem.gestionetudiants.web;


import com.ilem.gestionetudiants.entities.Payment;
import com.ilem.gestionetudiants.entities.PaymentStatus;
import com.ilem.gestionetudiants.entities.PaymentType;
import com.ilem.gestionetudiants.entities.Student;
import com.ilem.gestionetudiants.repositories.PaymentRepository;
import com.ilem.gestionetudiants.repositories.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentRestController {

    private StudentRepository studentRepository;
    private PaymentRepository paymentRepository;

    private PaymentRestController(StudentRepository studentRepository, PaymentRepository paymentRepository) {
        this.studentRepository = studentRepository;
        this.paymentRepository = paymentRepository;
    }

    @GetMapping("/payments")
    public List<Payment> allPayments() {
        return paymentRepository.findAll();
    }

    @GetMapping("/payments/student/{code}")
    public List<Payment> getPaymentsByStudentCode(@PathVariable String code) {
        return paymentRepository.findByStudentCode(code);
    }

    @GetMapping("/payments/status/{status}")
    public List<Payment> getPaymentsByStatus(@PathVariable PaymentStatus status) {
        return paymentRepository.findByPaymentStatus(status);
    }

    @GetMapping("/payments/type/{type}")
    public List<Payment> getPaymentsByType(@PathVariable PaymentType type) {
        return paymentRepository.findByPaymentType(type);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{code}")
    public Student getStudentByCode(@PathVariable String code) {
        return studentRepository.findByCode(code);
    }

    @GetMapping("/students/program/{programId}")
    public List<Student> getStudentsByProgramId(@PathVariable String programId) {
        return studentRepository.findByProgramId(programId);
    }
}
