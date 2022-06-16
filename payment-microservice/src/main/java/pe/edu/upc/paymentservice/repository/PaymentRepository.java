package pe.edu.upc.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.paymentservice.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
