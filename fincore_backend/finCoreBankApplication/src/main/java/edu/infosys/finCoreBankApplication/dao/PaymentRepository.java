package edu.infosys.finCoreBankApplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.infosys.finCoreBankApplication.bean.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT MAX(p.paymentId) FROM Payment p")
    Long getMaxPaymentId();

    @Query("SELECT p FROM Payment p WHERE p.customerId = ?1")
    List<Payment> getPaymentByCustomerId(Long customerId);

    @Query("SELECT p FROM Payment p WHERE p.customerLoanId = ?1")
    List<Payment> getPaymentByCustomerLoanId(String customerLoanId);
}