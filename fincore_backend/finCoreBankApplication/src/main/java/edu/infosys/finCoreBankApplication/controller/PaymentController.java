package edu.infosys.finCoreBankApplication.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.infosys.finCoreBankApplication.bean.Payment;
import edu.infosys.finCoreBankApplication.dao.PaymentDao;
import edu.infosys.finCoreBankApplication.service.PaymentService;

@RestController
@RequestMapping("/fincore")
@CrossOrigin(
        origins = {
                "http://localhost:3737",
                "http://localhost:3738",
                "http://localhost:3739"
        },
        allowCredentials = "true"
)
public class PaymentController {

    @Autowired
    private PaymentDao paymentDao;

    @Autowired
    private PaymentService service;

    // Add Payment
    @PostMapping("/pay")
    public void addPayment(@RequestBody Payment payment) {
        paymentDao.addPayment(payment);
    }

    // Get Payment By Id
    @GetMapping("/pay/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentDao.getPaymentById(id);
    }

    // Get All Payments
    @GetMapping("/pay")
    public List<Payment> getAllPayments() {
        return paymentDao.getAllPayments();
    }

    // Generate Payment Id
    @GetMapping("/pay-id")
    public Long generatePaymentId() {
        return service.generatePaymentId();
    }

    // Get Payments By Customer Id
    @GetMapping("/pay-cus/{id}")
    public List<Payment> getPaymentByCustomerId(@PathVariable Long id) {
        return paymentDao.getPaymentByCustomerId(id);
    }

    // Get Payments By Customer Loan Id
    @GetMapping("/pay-loan/{id}")
    public List<Payment> getPaymentByCustomerLoanId(@PathVariable String id) {
        return paymentDao.getPaymentByCustomerLoanId(id);
    }
}
