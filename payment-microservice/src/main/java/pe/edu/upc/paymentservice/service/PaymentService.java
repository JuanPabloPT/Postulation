package pe.edu.upc.paymentservice.service;

import pe.edu.upc.paymentservice.entity.Payment;

import java.util.List;

public interface PaymentService {
    public List<Payment> getAllPayment();
    public Payment getPayment(Long id);
    public Payment createPayment(Payment payment);
    public Payment updatePayment(Payment payment);
    public void deletePayment(Payment payment);
}
