package com.ilem.gestionetudiants.repositories;

import com.ilem.gestionetudiants.entities.Payment;
import com.ilem.gestionetudiants.entities.PaymentStatus;
import com.ilem.gestionetudiants.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, String>{
    List<Payment> findByStudentCode(String code);
    List<Payment> findByPaymentStatus(PaymentStatus status);
    List<Payment> findByPaymentType(PaymentType type);
}
