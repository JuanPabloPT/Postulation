package pe.edu.upc.paymentservice.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.paymentservice.entity.Payment;
import pe.edu.upc.paymentservice.repository.PaymentRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class PaymentServiceImplementation implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public List<Payment> getAllPayment() {
        List<Payment> paymentList = paymentRepository.findAll();
        if(paymentList == null) return null;
        return paymentList;
    }

    @Override
    public Payment getPayment(Long id) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        if(payment == null) return null;
        return payment;
    }

    @Override
    public Payment createPayment(Payment payment) {
        if(payment == null) return null;
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        if(payment == null) return null;
        Payment paymentDB = paymentRepository.findById(payment.getId()).orElse(null);
        paymentDB.setDescription(payment.getDescription());
        paymentDB.setName(payment.getName());

        return paymentRepository.save(paymentDB);
    }

    @Override
    public void deletePayment(Payment payment) {
        if(payment == null) return;
        paymentRepository.delete(payment);
    }
}
