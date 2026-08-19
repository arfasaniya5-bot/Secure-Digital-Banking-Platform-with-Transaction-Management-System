package edu.infosys.finCoreBankApplication.dao;

import java.util.List;

import edu.infosys.finCoreBankApplication.bean.Payment;

public interface PaymentDao {

    void addPayment(Payment payment);

    Payment getPaymentById(Long id);

    List<Payment> getAllPayments();

    Long getMaxPaymentId();

    List<Payment> getPaymentByCustomerId(long customerId);

    List<Payment> getPaymentByCustomerLoanId(String customerLoanId);
}