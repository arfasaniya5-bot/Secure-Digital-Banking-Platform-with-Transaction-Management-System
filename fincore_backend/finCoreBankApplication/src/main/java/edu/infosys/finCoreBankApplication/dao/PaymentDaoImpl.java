package edu.infosys.finCoreBankApplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import edu.infosys.finCoreBankApplication.bean.Payment;

@Repository
@Service
public class PaymentDaoImpl implements PaymentDao {

    @Autowired
    private PaymentRepository repository;

    @Override
    public void addPayment(Payment payment) {
        repository.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    @Override
    public Long getMaxPaymentId() {
        return repository.getMaxPaymentId();
    }

    @Override
    public List<Payment> getPaymentByCustomerId(long customerId) {
        return repository.getPaymentByCustomerId(customerId);
    }

    @Override
    public List<Payment> getPaymentByCustomerLoanId(String customerLoanId) {
        return repository.getPaymentByCustomerLoanId(customerLoanId);
    }
}